package com.endurance.dealsndealers.services;

import com.endurance.dealsndealers.better_dealers.BetterDealerInformation;
import com.endurance.dealsndealers.better_dealers.IBetterDealerInformationDao;
import com.endurance.dealsndealers.productsperdealer.IProductsDealersInformatonDao;
import com.endurance.dealsndealers.dealer.DealerInformation;
import com.endurance.dealsndealers.dealer.DealerInformationDao;
import com.endurance.dealsndealers.expense.ExpenseInformation;
import com.endurance.dealsndealers.expense.IExpenseInformationDao;
import com.endurance.dealsndealers.productsperdealer.ProductsDealersInformation;
import com.endurance.dealsndealers.smb.SmbInformation;
import com.endurance.dealsndealers.smb.SmbInformationDao;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by aman.aga on 02/12/16.
 */
public class ExpenseServices
{
    @Autowired
    private ApplicationContext appContext;

    public void addExpense( int receiptId,
                            int smbId,
                            int productId,
                            int dealerId,
                            double quantity,
                            double price)
    {
        ExpenseInformation expenseInformation = new ExpenseInformation();
        expenseInformation.setReceiptId(receiptId);
        expenseInformation.setDealerId(dealerId);
        expenseInformation.setSmbId(smbId);
        expenseInformation.setProductId(productId);
        expenseInformation.setQuantity(quantity);
        expenseInformation.setPrice(price);

        IExpenseInformationDao expenseInformationDao = (IExpenseInformationDao) appContext.getBean("expenseInformationDao");
        List<DealerInformation> listOfBetterDealers = getListOfBetterDealers(expenseInformation);

        int flag = listOfBetterDealers.size() > 0 ? 1:0;
        if(flag == 1)
        {
            expenseInformation.setExpenseStatus(1);
        }
        expenseInformationDao.addExpenseInformation(expenseInformation);

        insertBetterDealers(expenseInformation.getId(), listOfBetterDealers);
    }

    private void insertBetterDealers(int expenseId, List<DealerInformation> listOfBetterDealers)
    {
        StringBuffer betterDealers = new StringBuffer();
        for(DealerInformation dealerInformation: listOfBetterDealers)
        {
            betterDealers.append(String.valueOf(dealerInformation.getId())).append(",");
        }

        BetterDealerInformation betterDealerInformation = new BetterDealerInformation();
        betterDealerInformation.setExpenseId(expenseId);
        betterDealerInformation.setBetterDealers(betterDealers.toString());
        IBetterDealerInformationDao betterDealerInformationDao = (IBetterDealerInformationDao) appContext.getBean("betterDealerInformation");
        betterDealerInformationDao.insertBetterDealerInformation(betterDealerInformation);
    }

    private List<DealerInformation> getListOfBetterDealers(ExpenseInformation expenseInformation)
    {
        IProductsDealersInformatonDao productsDealersInformatonDao =
                (IProductsDealersInformatonDao) appContext.getBean("productsDealersInformationDao");

        List<ProductsDealersInformation> productsDealersInformationList = productsDealersInformatonDao.getDealerInfoForProduct(expenseInformation.getProductId());

        DealerInformationDao dealerInformationDao = (DealerInformationDao) appContext.getBean("dealerInformationDao");
        DealerInformation dealer = dealerInformationDao.getDealerInformationById(expenseInformation.getDealerId());

        SmbInformationDao smbInformationDao = (SmbInformationDao) appContext.getBean("smbInformationDao");
        SmbInformation smbInformation = smbInformationDao.getSmbInformationById(expenseInformation.getSmbId());

        List<DealerInformation> result = new ArrayList<>();

        result = getBetterDealersInternal(expenseInformation, productsDealersInformatonDao, productsDealersInformationList, dealerInformationDao, dealer, smbInformation, result);
        return result;
    }

    private ArrayList<DealerInformation> getBetterDealersInternal(ExpenseInformation expenseInformation,
                                                                  IProductsDealersInformatonDao productsDealersInformatonDao,
                                                                  List<ProductsDealersInformation> dealerInformationList,
                                                                  DealerInformationDao dealerInformationDao,
                                                                  DealerInformation dealer,
                                                                  SmbInformation smbInformation,
                                                                  List<DealerInformation> result)
    {
        double quantity = expenseInformation.getQuantity();
        double unitPrice = expenseInformation.getPrice()/quantity;

        TreeMap<Double, DealerInformation> metricDealerMap = new TreeMap<>();
        ArrayList<DealerInformation> listOfBetterDealers = new ArrayList<>();
        double ratingOfDealer = 0;
        double ratingDifference = 0;
        double unitPriceForDealer = 0;
        double unitPriceDifference = 0;
        long distanceOfDealerInKms = 0;
        double finalMetricValue = 0;
        double ratingMetric = 0;
        double unitPriceMetric = 0;
        double distanceMetric = 0;
        DealerInformation dealerInformation;

        for(ProductsDealersInformation productsDealersInformation: dealerInformationList) {
            dealerInformation = dealerInformationDao.getDealerInformationById(productsDealersInformation.getProductId());
            ratingOfDealer = dealerInformation.getRating();
            ratingDifference = ratingOfDealer - dealer.getRating();
            unitPriceForDealer = productsDealersInformatonDao.getPriceForProductForDealer(dealerInformation.getId(), expenseInformation.getProductId());
            unitPriceDifference = unitPriceForDealer - unitPrice;

            distanceOfDealerInKms = getDistance(dealerInformation.getZipCode(), smbInformation.getZipCode()) / 1000;

            ratingMetric = ((ratingDifference * 100) / ratingOfDealer) * ratingDifference;
            unitPriceMetric = ((unitPriceDifference * 100) / unitPriceDifference) * unitPriceDifference;

            distanceMetric = (distanceOfDealerInKms / 10000) * 50;

            finalMetricValue = ratingMetric + unitPriceMetric - distanceMetric;

            metricDealerMap.put(finalMetricValue, dealerInformation);
        }

        TreeMap<Double, DealerInformation> metricDealerMapDescending = new TreeMap<>(Collections.reverseOrder());
        metricDealerMapDescending.putAll(metricDealerMap);
        int numberOfDealers=10;

        for(Double key : metricDealerMapDescending.keySet()){
            listOfBetterDealers.add(metricDealerMapDescending.get(key));
            numberOfDealers--;
            if(numberOfDealers <= 0)    break;
        }

        return listOfBetterDealers;
    }

    private long getDistance(int origin, int destination)
    {
        String API_KEY = "AIzaSyCGLNJWX2lV8xtOG-iTGe6aTcXfvvW5QpE";
        GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);

        DistanceMatrix distanceMatrix =  DistanceMatrixApi.newRequest(context).
                origins(String.valueOf(origin)).destinations(String.valueOf(destination)).units(Unit.METRIC).awaitIgnoreError();
        long distance = 0;
        for(DistanceMatrixRow row: distanceMatrix.rows)
        {
            distance = row.elements[0].distance.inMeters;
        }
        return distance;
    }
}
