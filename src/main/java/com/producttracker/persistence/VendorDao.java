package com.producttracker.persistence;

import com.producttracker.entity.Vendor;
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
public class VendorDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all vendors
     *
     * @return All vendors
     */
    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = new ArrayList<Vendor>();
        Session session = null;
        try {
            session = openSession();
            vendors = session.createCriteria(Vendor.class).list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }
        return vendors;
    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}

