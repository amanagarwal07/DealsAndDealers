package com.endurance.dealsndealers.services;

import com.endurance.dealsndealers.dealer.DealerInformation;

import java.util.List;

/**
 * Created by chaitanya.m on 12/3/16.
 */
public interface IExpenseServices
{
    public List<DealerInformation> addExpense(int receiptId,
                                              int smbId,
                                              int productId,
                                              int dealerId,
                                              double quantity,
                                              double price, double rating);

}
