package com.endurance.dealsndealers.dealer;

import org.springframework.orm.hibernate4.HibernateTemplate;

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
