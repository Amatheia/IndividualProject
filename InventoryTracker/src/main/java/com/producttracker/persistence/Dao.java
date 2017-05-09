package com.producttracker.persistence;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * The Food Inventory Tracker program outputs an inventory management web application
 * for internal use by a restaurant. It implements a food expiration web service to get
 * a food expiration duration. User roles are in place. Registered users are able to add tasks,
 * update the current quantity of a product, and view products, categories, and vendors.
 * Only admin are allowed to completely update a product; add/delete products, categories,
 * and vendors. Only admin may view/update/delete the users list. A registered user may request
 * admin privileges by filling out the contact form.
 *
 * A Generic DAO that implements AutoCloseable.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
public class Dao implements AutoCloseable {

    protected Session session;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Empty constructor sets up session
     */
    public Dao() {
        log.info("Open new Hibernate session");
        session = SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Create a new Dao with a session
     * @param session Session
     */
    public Dao (Session session) {
        this.session = session;
    }

    /**
     * Closes session, catches exceptions
     */
    @Override
    public void close() throws Exception {
        try {
            if (session != null) {
                session.close();
            }
            log.info("Close Hibernate session");
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }
    }
}
