package com.endurance.dealsndealers.better_dealers;

/**
 * Created by aman.aga on 03/12/16.
 */
public class BetterDealerInformation
{
    public int receiptId;
    public String betterDealers; // list of comma separated dealers

    public void setReceiptId(int receiptId)
    {
        this.receiptId = receiptId;
    }

    public void setBetterDealers(String betterDealers)
    {
        this.betterDealers = betterDealers;
    }

    public int getReceiptId()
    {

        return receiptId;
    }

    public String getBetterDealers()
    {
        return betterDealers;
    }
}
