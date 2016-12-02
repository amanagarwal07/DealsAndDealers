package com.endurance.dealsndealers.productsperdealer;

import com.endurance.dealsndealers.dealer.DealerInformation;

import java.util.List;

/**
 * Created by aman.aga on 02/12/16.
 */
public interface IProductsDealersInformatonDao
{
    public void insertProductInformation(ProductsDealersInformation productsDealersInformation);

    public void updateProductInformation(ProductsDealersInformation productsDealersInformation);

    public void deleteProductInformation(ProductsDealersInformation productsDealersInformation);

    public List<ProductsDealersInformation> getDealerInfoForProduct(int productId);

    public double getPriceForProductForDealer(int dealerID, int productId);
}
