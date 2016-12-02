package com.endurance.dealsndealers.dealer;


/**
 * Created by chaitanya.m on 12/2/16.
 */
public interface IDealerInformationDao
{
    public DealerInformation getDealerInformationById(int id);

    public void insertDealerInformation(DealerInformation dealerInformation);

    public void updateDealerInformation(DealerInformation dealerInformation);

    public void deleteDealerInformation(DealerInformation dealerInformation);
}
