package com.endurance.dealsndealers.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/health")
public class HealthCheck
{
    @Autowired
    private ApplicationContext appContext;

    @GET
    @Path("/hello")
    public String health()
    {
        return "GOOD";
    }
}
