package com.endurance.dealsndealers.product;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<ProductInformation> getProducts()
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProductInformation.class);
        List<ProductInformation> result = (List<ProductInformation>) template.findByCriteria(criteria);
        return result;
    }

    @Override
    public ProductInformation getProductInformationById(int id)
    {
        ProductInformation productInformation = (ProductInformation) template.get(ProductInformation.class, id);
        return productInformation;
    }

    @Override
    @Transactional(readOnly = false)
    public void insertProductInformation(ProductInformation productInformation)
    {
        template.setCheckWriteOperations(false);
        template.persist(productInformation);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateProductInformation(ProductInformation productInformation)
    {
        template.setCheckWriteOperations(false);
        template.update(productInformation);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteProductInformation(ProductInformation productInformation)
    {
        template.setCheckWriteOperations(false);
        template.delete(productInformation);
    }
}
