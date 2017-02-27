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

}