package com.producttracker.persistence;

import com.producttracker.entity.Vendor;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by amalbaugh on 2/25/17.
 */
public class VendorDaoTest {

    VendorDao dao;

    @Before
    public void setup() {
        dao = new VendorDao();
    }

    @Test
    public void getAllVendors() throws Exception {
        List<Vendor> vendors = dao.getAllVendors();
        assertTrue(vendors.size() > 0);
    }

    @Test
    public void addVendor(){
        Vendor v = new Vendor();

        v.setVendorId(1);
        v.setVendorName("Royal Coffee");
        v.setContactName("Jim Johnson");
        v.setAddress("325 Spaight St");
        v.setCity("Madison");
        v.setStateProvince("WI");
        v.setPostalCode("53719");
        v.setPhone("608-275-8967");
        dao.addVendor(v);

        assertEquals("Vendor name incorrect", "Royal Coffee", dao.getVendor(1).getVendorName());
    }

}