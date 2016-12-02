package com.endurance.dealsndealers.expense;

import java.util.Date;
import java.util.List;

/**
 * Created by chaitanya.m on 12/2/16.
 */
public interface IExpenseInformationDao
{
    public List<ExpenseInformation>  getExpensesOfSmb(int smbId, Date startDate, Date endDate);
    public List<ExpenseInformation>  getExpensesForProduct(int productId, Date startDate, Date endDate);
    public void addExpenseInformation(ExpenseInformation expenseInformation);
    public ExpenseInformation getExpenseInformation(int id);
    public void updateExpenseInformation(ExpenseInformation expenseInformation);
    public void deleteExpenseInformation(ExpenseInformation expenseInformation);
}
