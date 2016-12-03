package com.endurance.dealsndealers.expense;

import java.util.Date;

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
    private int expenseStatus;
    private int creationDate;
    private double rating;

    public int getExpenseStatus()
    {
        return expenseStatus;
    }

    public void setExpenseStatus(int expenseStatus)
    {
        this.expenseStatus = expenseStatus;
    }

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

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
