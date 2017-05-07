package com.producttracker.persistence;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Generic dao
 * @author amatheia
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
