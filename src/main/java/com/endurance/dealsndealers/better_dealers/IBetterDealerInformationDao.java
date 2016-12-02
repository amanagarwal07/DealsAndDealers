package com.endurance.dealsndealers.better_dealers;

/**
 * Created by aman.aga on 03/12/16.
 */
public interface IBetterDealerInformationDao
{
    public void insertBetterDealerInformation(BetterDealerInformation betterDealerInformation);

    public BetterDealerInformation getBetterDealerInformation(int receiptId);
}
