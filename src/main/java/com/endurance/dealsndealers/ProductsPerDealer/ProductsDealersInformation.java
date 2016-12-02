package com.endurance.dealsndealers.ProductsPerDealer;

/**
 * Created by aman.aga on 02/12/16.
 */
public class ProductsDealersInformation
{
    private int dealerId;
    private int productId;
    private double price;

    public int getDealerId()
    {
        return dealerId;
    }

    public int getProductId()
    {
        return productId;
    }

    public double getPrice()
    {
        return price;
    }

    public void setDealerId(int dealerId)
    {
        this.dealerId = dealerId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
