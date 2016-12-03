package com.endurance.dealsndealers.product;

import java.util.List;

/**
 * Created by chaitanya.m on 12/2/16.
 */
public interface IProductInformationDao
{
    public List<ProductInformation> getProducts();

    public ProductInformation getProductInformationById(int id);

    public void insertProductInformation(ProductInformation productInformation);

    public void updateProductInformation(ProductInformation productInformation);

    public void deleteProductInformation(ProductInformation productInformation);
}
