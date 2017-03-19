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

    /**
     * retrieve a vendor given their id
     *
     * @param id the vendor's id
     * @return vendor
     */
    public Vendor getVendor(int id) {
        Vendor vendor = null;
        Session session = null;
        try {
            session = openSession();
            vendor = (Vendor) session.get(Vendor.class, id);
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return vendor;
    }

    /**
     * add a vendor
     *
     * @param vendor
     * @return the id of the inserted record
     */
    public int addVendor(Vendor vendor) {
        int id = 0;
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            id = (int) session.save(vendor);
            log.info("Inserting record" + vendor);
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
     * delete a vendor by id
     * @param id the vendor's id
     */
    public int deleteVendor(int id) {
        Session session = null;

        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            Vendor vendor = (Vendor) session.load(Vendor.class, id);
            session.delete(vendor);
            transaction.commit();
            log.info("Deleted vendor: " + id);
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
     * Update the vendor
     * @param vendor
     */
    public void updateVendor(Vendor vendor) {
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            session.update(vendor);
            transaction.commit();
            log.info("Updated: " + vendor);
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}

