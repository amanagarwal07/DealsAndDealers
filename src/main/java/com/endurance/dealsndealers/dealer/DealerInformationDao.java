package com.endurance.dealsndealers.dealer;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

/**
 * Created by chaitanya.m on 12/2/16.
 */
public class DealerInformationDao implements IDealerInformationDao
{
    private HibernateTemplate template;

    public DealerInformationDao(HibernateTemplate template)
    {
        this.template = template;
    }

    @Override
    public List<DealerInformation> getDealers()
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(DealerInformation.class);
        List<DealerInformation> result = (List<DealerInformation>) template.findByCriteria(criteria);
        return result;
    }

    @Override
    public DealerInformation getDealerInformationById(int id)
    {
        DealerInformation dealerInformation = (DealerInformation) template.get(DealerInformation.class, id);
        return dealerInformation;
    }

    @Override
    public void insertDealerInformation(DealerInformation dealerInformation)
    {
        template.persist(dealerInformation);
    }

    @Override
    public void updateDealerInformation(DealerInformation dealerInformation)
    {
        template.update(dealerInformation);
    }

    @Override
    public void deleteDealerInformation(DealerInformation dealerInformation)
    {
        template.delete(dealerInformation);
    }
}
