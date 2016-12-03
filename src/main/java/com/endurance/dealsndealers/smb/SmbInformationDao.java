package com.endurance.dealsndealers.smb;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

/**
 * Created by chaitanya.m on 12/2/16.
 */
public class SmbInformationDao implements ISmbInformationDao
{
    private HibernateTemplate template;

    public SmbInformationDao(HibernateTemplate template)
    {
        this.template = template;
    }

    @Override
    public List<SmbInformation> getSmbs()
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(SmbInformation.class);
        List<SmbInformation> result = (List<SmbInformation>) template.findByCriteria(criteria);
        return result;
    }

    @Override
    public SmbInformation getSmbInformationById(int id)
    {
        SmbInformation smbInformation = (SmbInformation) template.get(SmbInformation.class, id);
        return smbInformation;
    }

    @Override
    public void insertSmbInformation(SmbInformation smbInformation)
    {
        template.persist(smbInformation);
    }

    @Override
    public void updateSmbInformation(SmbInformation smbInformation)
    {
        template.update(smbInformation);
    }

    @Override
    public void deleteSmbInformation(SmbInformation smbInformation)
    {
        template.delete(smbInformation);
    }
}
