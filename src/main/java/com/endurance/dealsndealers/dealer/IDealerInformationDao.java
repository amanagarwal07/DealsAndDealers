package com.endurance.dealsndealers.dealer;


import java.util.List;

/**
 * Created by chaitanya.m on 12/2/16.
 */
public interface IDealerInformationDao
{
    public List<DealerInformation> getDealers();

    public DealerInformation getDealerInformationById(int id);

    public void insertDealerInformation(DealerInformation dealerInformation);

    public void updateDealerInformation(DealerInformation dealerInformation);

    public void deleteDealerInformation(DealerInformation dealerInformation);
}
