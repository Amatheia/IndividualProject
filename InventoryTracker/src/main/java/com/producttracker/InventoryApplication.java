package com.producttracker;

import com.producttracker.controller.JsonOutput;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * InventoryApplication provides root resource and provider classes for accessing json output.
 *
 * The Food Inventory Tracker program outputs an inventory management web application
 * for internal use by a restaurant. It implements a food expiration web service to get
 * a food expiration duration. User roles are in place. Registered users are able to add tasks,
 * update the current quantity of a product, and view products, categories, and vendors.
 * Only admin are allowed to completely update a product; add/delete products, categories,
 * and vendors. Only admin may view/update/delete the users list. A registered user may request
 * admin privileges by filling out the contact form.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
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
