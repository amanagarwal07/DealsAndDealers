package com.endurance.dealsndealers.ProductsPerDealer;

import com.endurance.dealsndealers.dealer.DealerInformation;

import java.util.List;

/**
 * Created by aman.aga on 02/12/16.
 */
public class ProductsDealersInformationDao implements IProductsDealersInformatonDao
{

    @Override
    public void insertProductInformation(ProductsDealersInformation productsDealersInformation)
    {

    }

    @Override
    public void updateProductInformation(ProductsDealersInformation productsDealersInformation)
    {

    }

    @Override
    public void deleteProductInformation(ProductsDealersInformation productsDealersInformation)
    {

    }

    @Override
    public List<DealerInformation> getDelaerInfoForProduct(int productId)
    {
        return null;
    }

    @Override
    public double getPriceForProductForDealer(int dealerID, int productId)
    {
        return 0;
    }
}
