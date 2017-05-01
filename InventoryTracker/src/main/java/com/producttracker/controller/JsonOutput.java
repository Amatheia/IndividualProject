package com.producttracker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producttracker.entity.Category;
import com.producttracker.entity.Product;
import com.producttracker.persistence.CategoryDao;
import com.producttracker.persistence.ProductDao;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by amalbaugh on 4/30/17.
 */
@Path("/json")
public class JsonOutput {

    private final Logger log = Logger.getLogger(this.getClass());

    CategoryDao dao = new CategoryDao();
    ProductDao daoProduct = new ProductDao();


    /**
     * This method is used to return all categories
     * in JSON.
     * @return method This returns all categories.
     */
    @GET
    @Path("/categories")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Category> getCategories() throws JsonProcessingException {
        log.info("Categories: " + dao.getAllCategories());
        return dao.getAllCategories();
    }

    /**
     * This method is used to return all products
     * in JSON.
     * @return method This returns all products.
     */
    @GET
    @Path("/products")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> getProducts() throws JsonProcessingException {
        log.info("Products: " + daoProduct.getAllProducts());
        return daoProduct.getAllProducts();
    }
}
