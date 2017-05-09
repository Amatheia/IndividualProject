package com.producttracker.persistence;

import com.producttracker.entity.Vendor;
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
 * A DAO for the Vendor class. Extends generic Dao.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
public class VendorDao extends Dao {

    private final Logger log = Logger.getLogger(this.getClass());
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
     * @param vendor the vendor object
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
     * @return the id of the deleted record
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
     * @param vendor the vendor object
     */
    public void updateVendor(Vendor vendor) {
        session.beginTransaction();
        session.merge(vendor);
        session.getTransaction().commit();
        log.info("Updated: " + vendor);
    }
}

