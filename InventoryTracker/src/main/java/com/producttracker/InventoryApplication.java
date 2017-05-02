package com.producttracker;

import com.producttracker.controller.JsonOutput;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by amalbaugh on 5/1/17.
 */
//Defines the base URI for all resource URIs.
@ApplicationPath("/")
//The java class declares root resource and provider classes
public class InventoryApplication extends Application {

        //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
        @Override
        public Set<Class<?>> getClasses() {
            HashSet h = new HashSet<Class<?>>();
            h.add(JsonOutput.class );
            return h;
        }

}
