package com.endurance.dealsndealers.better_dealers;

/**
 * Created by aman.aga on 03/12/16.
 */
public class BetterDealerInformation
{
    public int expenseId;
    public String betterDealers; // list of comma separated dealers


    public void setBetterDealers(String betterDealers)
    {
        this.betterDealers = betterDealers;
    }

    public void setExpenseId(int expenseId)
    {
        this.expenseId = expenseId;
    }

    public int getExpenseId()
    {

        return expenseId;
    }

    public String getBetterDealers()
    {
        return betterDealers;
    }
}
