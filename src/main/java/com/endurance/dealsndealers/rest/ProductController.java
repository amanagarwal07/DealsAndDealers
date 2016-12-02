package com.endurance.dealsndealers.rest;

import com.endurance.dealsndealers.dealer.DealerInformation;
import com.endurance.dealsndealers.dealer.IDealerInformationDao;
import com.endurance.dealsndealers.product.IProductInformationDao;
import com.endurance.dealsndealers.product.ProductInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by chaitanya.m on 12/3/16.
 */
@Path("/product")
public class ProductController
{
    @Autowired
    private ApplicationContext appContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProductInformation get(@QueryParam("id") int id)
    {
        IProductInformationDao productInformationDao = (IProductInformationDao) appContext.getBean("productInformationDao");
        return productInformationDao.getProductInformationById(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(ProductInformation productInformation)
    {
        IProductInformationDao productInformationDao = (IProductInformationDao) appContext.getBean("productInformationDao");
        productInformationDao.insertProductInformation(productInformation);
    }
}
