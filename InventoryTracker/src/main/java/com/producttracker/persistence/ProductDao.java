package com.producttracker.persistence;

import com.producttracker.entity.Product;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amatheia.
 */
public class ProductDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all products
     *
     * @return All products
     */
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        Session session = null;
        try {
            session = openSession();
            products = session.createCriteria(Product.class).list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }
        return products;
    }

    /**
     * retrieve a product given their id
     *
     * @param id the product's id
     * @return product
     */
    public Product getProduct(int id) {
        Product product = null;
        Session session = null;
        try {
            session = openSession();
            product = (Product) session.get(Product.class, id);
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    /** Retrieve products by product name
     *
     * @param productName Product's name which is the search criteria
     * @return Product
     */
    public List<Product> getProductsByProductName(String productName) {
        List<Product> products = new ArrayList<Product>();
        Session session = null;
        try {
            session = openSession();
            Criteria criteria = session.createCriteria(Product.class);
            criteria.add(Restrictions.eq("productName", productName));
            products = criteria.list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e );
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

    /**
     * add a product
     *
     * @param product
     * @return the id of the inserted record
     */
    public int addProduct(Product product) {
        int id = 0;
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            id = (int) session.save(product);
            transaction.commit();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return id;
    }

    /**
     * delete a product by id
     * @param id the product's id
     */
    public int deleteProduct(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        int index;

        try {
            tx = session.beginTransaction();
            Product product = (Product) session.load(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
            log.info("Deleted product: " + id);
            index = 1;
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            index = 0;
            log.info("Runtime exception to delete product: " + e);
        } finally {
            session.close();
        }

        return index;
    }

    /**
     * Update the product
     * @param product
     */
    public void updateProduct(Product product) {
        Transaction tx = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            log.info("Updated: " + product);
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            log.info("Runtime exception to update product: " + e);
        } finally {
            session.close();
        }
    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}

