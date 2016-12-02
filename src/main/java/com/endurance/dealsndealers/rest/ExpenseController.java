package com.endurance.dealsndealers.rest;

import com.endurance.dealsndealers.expense.ExpenseInformation;
import com.endurance.dealsndealers.expense.IExpenseInformationDao;
import com.endurance.dealsndealers.services.ExpenseServices;
import com.endurance.dealsndealers.smb.SmbInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by chaitanya.m on 12/3/16.
 */
@Path("/expense")
public class ExpenseController
{
    @Autowired
    private ApplicationContext appContext;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(ExpenseInformation expenseInformation)
    {
      new ExpenseServices().addExpense(expenseInformation.getReceiptId()
              , expenseInformation.getSmbId(), expenseInformation.getProductId(),expenseInformation.getDealerId()
              , expenseInformation.getQuantity(), expenseInformation.getPrice());
    }
}
