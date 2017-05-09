package com.producttracker.persistence;

import com.producttracker.entity.Product;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * The Food Inventory Tracker program outputs an inventory management web application
 * for internal use by a restaurant. It implements a food expiration web service to get
 * a food expiration duration. User roles are in place. Registered users are able to add tasks,
 * update the current quantity of a product, and view products, categories, and vendors.
 * Only admin are allowed to completely update a product; add/delete products, categories,
 * and vendors. Only admin may view/update/delete the users list. A registered user may request
 * admin privileges by filling out the contact form.
 *
 * A DAO for the Product class. Extends generic Dao.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
public class ProductDao extends Dao {

    private final Logger log = Logger.getLogger(this.getClass());
    private int id = 0;

    /**
     * Empty constructor assigns session
     */
    public ProductDao() {
        super();
    }

    /**
     * Return a list of all products
     *
     * @return All products
     */
    public List<Product> getAllProducts() {
        List<Product> products = null;
        products = session.createCriteria(Product.class).list();
        return products;
    }

    /**
     * retrieve a product given their id
     *
     * @param id the product's id
     * @return product
     */
    public Product getProduct(int id) {
        log.debug("getting Products with id: " + id);
        return (Product) session.get(Product.class, id);
    }

    /**
     * add a product
     *
     * @param product
     * @return the id of the inserted record
     */
    public int addProduct(Product product) {
        session.beginTransaction();
        id = (int) session.save(product);
        log.info("Inserting record" + product.getProductId());
        session.getTransaction().commit();
        return id;
    }

    /**
     * delete a product by id
     *
     * @param id the product's id
     */
    public int deleteProduct(int id) {
        session.beginTransaction();
        Product product = (Product) session.load(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
        log.info("Deleted category: " + id);
        return id;
    }

    /**
     * Update the product
     *
     * @param product
     */
    public void updateProduct(Product product) {
        session.beginTransaction();
        session.merge(product);
        session.getTransaction().commit();
        log.info("Updated: " + product);
    }

}

