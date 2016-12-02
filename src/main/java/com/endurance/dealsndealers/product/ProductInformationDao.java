package com.endurance.dealsndealers.product;

import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * Created by chaitanya.m on 12/2/16.
 */
public class ProductInformationDao implements IProductInformationDao
{

    private HibernateTemplate template;

    public ProductInformationDao(HibernateTemplate template)
    {
        this.template = template;
    }

    @Override
    public ProductInformation getProductInformationById(int id)
    {
        ProductInformation productInformation = (ProductInformation) template.get(ProductInformation.class, id);
        return productInformation;
    }

    @Override
    public void insertProductInformation(ProductInformation productInformation)
    {
        template.setCheckWriteOperations(false);
        template.persist(productInformation);
    }

    @Override
    public void updateProductInformation(ProductInformation productInformation)
    {
        template.update(productInformation);
    }

    @Override
    public void deleteProductInformation(ProductInformation productInformation)
    {
        template.delete(productInformation);
    }
}
