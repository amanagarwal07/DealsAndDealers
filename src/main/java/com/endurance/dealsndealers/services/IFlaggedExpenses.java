package com.endurance.dealsndealers.services;

import com.endurance.dealsndealers.dealer.DealerInformation;

import java.util.List;

/**
 * Created by chaitanya.m on 12/3/16.
 */
public interface IFlaggedExpenses
{
    public List<DealerInformation> getBetterDealersForReceiptId(int expenseId);
}
