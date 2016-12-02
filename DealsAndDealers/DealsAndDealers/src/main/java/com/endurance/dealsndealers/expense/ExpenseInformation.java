package com.endurance.dealsndealers.expense;

/**
 * Created by chaitanya.m on 12/2/16.
 */
public class ExpenseInformation
{
    private int id;
    private int receiptId;
    private int smbId;
    private int productId;
    private int dealerId;
    private double quantity;
    private double price;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getReceiptId()
    {
        return receiptId;
    }

    public void setReceiptId(int receiptId)
    {
        this.receiptId = receiptId;
    }

    public int getSmbId()
    {
        return smbId;
    }

    public void setSmbId(int smbId)
    {
        this.smbId = smbId;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public int getDealerId()
    {
        return dealerId;
    }

    public void setDealerId(int dealerId)
    {
        this.dealerId = dealerId;
    }

    public double getQuantity()
    {
        return quantity;
    }

    public void setQuantity(double quantity)
    {
        this.quantity = quantity;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
