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
 * JsonOutput provides json output of categories and products for ajax call of dropdown options
 * in the update inventory form.
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
