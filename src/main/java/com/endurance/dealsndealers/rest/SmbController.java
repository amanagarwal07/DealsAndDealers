package com.endurance.dealsndealers.rest;

import com.endurance.dealsndealers.smb.ISmbInformationDao;
import com.endurance.dealsndealers.smb.SmbInformation;
import com.endurance.dealsndealers.smb.SmbInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/smb")
public class SmbController
{
    @Autowired
    private ApplicationContext appContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SmbInformation get(@QueryParam("id") int id)
    {
        ISmbInformationDao smbInformationDao = (ISmbInformationDao) appContext.getBean("smbInformationDao");
        return smbInformationDao.getSmbInformationById(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(SmbInformation smbInformation)
    {
        ISmbInformationDao smbInformationDao = (ISmbInformationDao) appContext.getBean("smbInformationDao");
        smbInformationDao.insertSmbInformation(smbInformation);
    }
}
