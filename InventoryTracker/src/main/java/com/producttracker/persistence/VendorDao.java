package com.producttracker.persistence;

import com.producttracker.entity.Vendor;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author amatheia.
 */
public class VendorDao extends Dao {

    private final Logger log = Logger.getLogger(this.getClass());
    private Dao genDao = new Dao();
    private int id = 0;

    /**
     * Empty constructor assigns session
     */
    public VendorDao() {
        super();
    }

    /**
     * Return a list of all vendors
     *
     * @return All vendors
     */
    public List<Vendor> getAllVendors() {
        List<Vendor> vendors;
        vendors = session.createCriteria(Vendor.class).list();
        return vendors;
    }

    /**
     * retrieve a vendor given their id
     *
     * @param id the vendor's id
     * @return vendor
     */
    public Vendor getVendor(int id) {
        log.debug("getting Vendors with id: " + id);
        return (Vendor) session.get(Vendor.class, id);
    }

    /**
     * add a vendor
     *
     * @param vendor
     * @return the id of the inserted record
     */
    public int addVendor(Vendor vendor) {
        session.beginTransaction();
        id = (int) session.save(vendor);
        log.info("Inserting record" + vendor.getVendorId());
        session.getTransaction().commit();
        return id;
    }

    /**
     * delete a vendor by id
     *
     * @param id the vendor's id
     */
    public int deleteVendor(int id) {
        session.beginTransaction();
        Vendor vendor = (Vendor) session.load(Vendor.class, id);
        session.delete(vendor);
        session.getTransaction().commit();
        log.info("Deleted vendor: " + id);
        return id;
    }

    /**
     * Update the vendor
     *
     * @param vendor
     */
    public void updateVendor(Vendor vendor) {
        genDao.session.beginTransaction();
        genDao.session.update(vendor);
        genDao.session.getTransaction().commit();
        log.info("Updated: " + vendor);
    }
}

