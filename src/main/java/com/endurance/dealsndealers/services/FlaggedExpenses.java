package com.endurance.dealsndealers.services;

import com.endurance.dealsndealers.better_dealers.IBetterDealerInformationDao;
import com.endurance.dealsndealers.dealer.DealerInformation;
import com.endurance.dealsndealers.dealer.DealerInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman.aga on 03/12/16.
 */
public class FlaggedExpenses
{
    @Autowired
    private ApplicationContext appContext;

    public List<DealerInformation> getBetterDealersForReceiptId(int receiptId)
    {
        IBetterDealerInformationDao expenseInformationDao =
                (IBetterDealerInformationDao) appContext.getBean("betterDealerInformation");

        String betterDealers =  expenseInformationDao.getBetterDealerInformation(receiptId).getBetterDealers();
        List<DealerInformation> dealerInformationList = new ArrayList<>();
        DealerInformationDao dealerInformationDao = (DealerInformationDao) appContext.getBean("dealerInformationDao");

        for (String s : betterDealers.split(","))
        {
            dealerInformationList.add(dealerInformationDao.getDealerInformationById(Integer.parseInt(s)));
        }
        return dealerInformationList;
    }
}
