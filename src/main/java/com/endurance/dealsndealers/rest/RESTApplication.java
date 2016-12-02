package com.endurance.dealsndealers.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class RESTApplication extends ResourceConfig {

    public RESTApplication() {
        packages("com.endurance.dealsndealers.rest");
        register(JacksonFeature.class);
    }

}