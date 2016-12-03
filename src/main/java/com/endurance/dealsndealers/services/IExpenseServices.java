package com.endurance.dealsndealers.services;

/**
 * Created by chaitanya.m on 12/3/16.
 */
public interface IExpenseServices
{
    public void addExpense( int receiptId,
                            int smbId,
                            int productId,
                            int dealerId,
                            double quantity,
                            double price);

}
