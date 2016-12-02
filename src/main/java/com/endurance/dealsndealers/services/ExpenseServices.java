package com.endurance.dealsndealers.services;

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
import java.util.List;

/**
 * Created by aman.aga on 02/12/16.
 */
public class ExpenseServices
{
    @Autowired
    private ApplicationContext appContext;

    public void addExpense( int id,
                            int receiptId,
                            int smbId,
                            int productId,
                            int dealerId,
                            double quantity,
                            double price)
    {
        ExpenseInformation expenseInformation = new ExpenseInformation();
        expenseInformation.setId(id);
        expenseInformation.setReceiptId(receiptId);
        expenseInformation.setDealerId(dealerId);
        expenseInformation.setSmbId(smbId);
        expenseInformation.setProductId(productId);
        expenseInformation.setQuantity(quantity);
        expenseInformation.setPrice(price);

        IExpenseInformationDao expenseInformationDao = (IExpenseInformationDao) appContext.getBean("expenseInformationDao");
        List<DealerInformation> listOfBetterDealer = getListOfBetterDealers(expenseInformation);

        int flag = listOfBetterDealer.size() > 0 ? 1:0;
        if(flag == 1)
        {
            expenseInformation.setExpenseStatus(1);
        }

        expenseInformationDao.addExpenseInformation(expenseInformation);
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

        for(ProductsDealersInformation productsDealersInformation : productsDealersInformationList)
        {
            DealerInformation dealerInformation = dealerInformationDao.getDealerInformationById(productsDealersInformation.getDealerId());
            if(dealerInformation.getRating() >= dealer.getRating() && !dealerInformation.getCity().equals(dealer.getCity()))
            {
                long distanceOfDealerInMeters = getDistance(dealerInformation.getZipCode(),smbInformation.getZipCode());
                double finalCost = productsDealersInformatonDao.getPriceForProductForDealer(dealerInformation.getId(),expenseInformation.getProductId());
                finalCost = finalCost + distanceOfDealerInMeters * 0.4;
                if(finalCost < productsDealersInformatonDao.getPriceForProductForDealer(expenseInformation.getDealerId(),expenseInformation.getProductId()))
                {
                    result.add(dealerInformation);
                }
            }
            else if(dealerInformation.getRating() >= dealer.getRating() &&
                productsDealersInformatonDao.getPriceForProductForDealer(dealerInformation.getId(),expenseInformation.getProductId()) <
                        productsDealersInformatonDao.getPriceForProductForDealer(expenseInformation.getDealerId(),expenseInformation.getProductId()))
            {
                result.add(dealerInformation);
            }
        }
        return result;
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
