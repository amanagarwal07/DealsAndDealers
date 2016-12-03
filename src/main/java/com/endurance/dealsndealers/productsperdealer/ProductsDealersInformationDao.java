package com.endurance.dealsndealers.productsperdealer;

import com.endurance.dealsndealers.dealer.DealerInformation;
import com.endurance.dealsndealers.dealer.IDealerInformationDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by aman.aga on 02/12/16.
 */
public class ProductsDealersInformationDao implements IProductsDealersInformatonDao {


    private HibernateTemplate template;

    public ProductsDealersInformationDao(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    @Transactional(readOnly = false)
    public void insertProductInformation(ProductsDealersInformation productsDealersInformation) {
        template.persist(productsDealersInformation);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateProductInformation(ProductsDealersInformation productsDealersInformation) {
        template.update(productsDealersInformation);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteProductInformation(ProductsDealersInformation productsDealersInformation) {
        template.delete(productsDealersInformation);
    }

    @Override
    public List<ProductsDealersInformation> getDealerInfoForProduct(int productId)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProductsDealersInformation.class)
               .add(Restrictions.eq("productId", productId));
        List<ProductsDealersInformation> result = (List<ProductsDealersInformation>) template.findByCriteria(criteria);
        return result;
    }

    @Override
    public ProductsDealersInformation getInfoForProductForDealer(int dealerId, int productId)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProductsDealersInformation.class)
                .add(Restrictions.eq("dealerId", dealerId))
                .add(Restrictions.eq("productId", productId));
        List<ProductsDealersInformation> result = (List<ProductsDealersInformation>) template.findByCriteria(criteria);
        return (result == null || result.size() == 0) ? null : result.get(0);
    }

    @Override
    public double getPriceForProductForDealer(int dealerId, int productId)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProductsDealersInformation.class)
                .add(Restrictions.eq("dealerId", dealerId))
                .add(Restrictions.eq("productId", productId));
        List<ProductsDealersInformation> result = (List<ProductsDealersInformation>) template.findByCriteria(criteria);
        return result.get(0).getPrice();
    }
}
