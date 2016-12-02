package com.endurance.dealsndealers.rest;

import com.endurance.dealsndealers.dealer.DealerInformation;
import com.endurance.dealsndealers.dealer.IDealerInformationDao;
import com.endurance.dealsndealers.smb.ISmbInformationDao;
import com.endurance.dealsndealers.smb.SmbInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by chaitanya.m on 12/3/16.
 */
@Path("/dealer")
public class DealerController
{
    @Autowired
    private ApplicationContext appContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DealerInformation get(@QueryParam("id") int id)
    {
        IDealerInformationDao dealerInformationDao = (IDealerInformationDao) appContext.getBean("dealerInformationDao");
        return dealerInformationDao.getDealerInformationById(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(DealerInformation dealerInformation)
    {
        IDealerInformationDao dealerInformationDao = (IDealerInformationDao) appContext.getBean("dealerInformationDao");
        dealerInformationDao.insertDealerInformation(dealerInformation);
    }
}
