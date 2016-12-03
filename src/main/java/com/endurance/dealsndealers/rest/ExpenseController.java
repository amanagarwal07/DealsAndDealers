package com.endurance.dealsndealers.rest;

import com.endurance.dealsndealers.dealer.DealerInformation;
import com.endurance.dealsndealers.expense.ExpenseInformation;
import com.endurance.dealsndealers.expense.IExpenseInformationDao;
import com.endurance.dealsndealers.services.ExpenseServices;
import com.endurance.dealsndealers.services.FlaggedExpenses;
import com.endurance.dealsndealers.smb.SmbInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by chaitanya.m on 12/3/16.
 */
@Path("/expense")
public class ExpenseController
{
    @Autowired
    private ApplicationContext appContext;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public List<DealerInformation>  addExpense(ExpenseInformation expenseInformation)
    {
        return ((ExpenseServices)appContext.getBean("expenseServices")).addExpense(expenseInformation.getReceiptId()
              , expenseInformation.getSmbId(), expenseInformation.getProductId(),expenseInformation.getDealerId()
              , expenseInformation.getQuantity(), expenseInformation.getPrice(), expenseInformation.getRating());
    }

    @GET
    @Path("/getBetterDealersForExpense")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DealerInformation> getBetterDealersForExpense(@QueryParam("expenseId") int expenseId)
    {
        return ((FlaggedExpenses)appContext.getBean("flaggedExpenses"))
                .getBetterDealersForReceiptId(expenseId);
    }

    @GET
    @Path("/getFlaggedExpenses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ExpenseInformation> getFlaggedExpenses(@QueryParam("smbId") int smbId)
    {
        return null;
    }
}
