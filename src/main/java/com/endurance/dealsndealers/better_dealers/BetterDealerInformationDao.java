package com.endurance.dealsndealers.better_dealers;

import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * Created by aman.aga on 03/12/16.
 */
public class BetterDealerInformationDao implements IBetterDealerInformationDao
{
    private HibernateTemplate template;

    public BetterDealerInformationDao(HibernateTemplate template)
    {
        this.template = template;
    }

    @Override
    public void insertBetterDealerInformation(BetterDealerInformation betterDealerInformation)
    {
        template.persist(betterDealerInformation);
    }

    @Override
    public BetterDealerInformation getBetterDealerInformation(int receiptId)
    {
        return (BetterDealerInformation) template.get(BetterDealerInformation.class,receiptId);
    }
}
