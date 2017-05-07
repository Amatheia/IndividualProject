package com.producttracker.persistence;

import com.producttracker.entity.Vendor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by amatheia.
 */
public class VendorDaoTest {

    VendorDao dao;
    Vendor vendor;
    int newVendor = 0;

    @Before
    public void setUp() throws Exception {
        dao = new VendorDao();
        vendor = new Vendor();
        vendor.setVendorName("Bryant Family Farms LLC");
        vendor.setContactName("Nico Bryant");
        vendor.setAddress("3102 Cty Road Y");
        vendor.setCity("Dodgeville");
        vendor.setStateProvince("WI");
        vendor.setPostalCode("53533");
        vendor.setPhone("847-293-9988");
    }

    @After
    public void tearDown() throws Exception {
        // cleans up test vendor
        if (newVendor != 0) {
            dao.deleteVendor(newVendor);
        }
    }

    @Test
    public void getAllVendors() throws Exception {
        newVendor = dao.addVendor(vendor);
        List<Vendor> vendors = dao.getAllVendors();
        assertTrue(vendors.size() > 0);
    }

    @Test
    public void getVendor() throws Exception {
        newVendor = dao.addVendor(vendor);
        assertNotNull("vendor not returned", dao.getVendor(newVendor));
        assertEquals("vendor ID not returned", vendor.getVendorId(), dao.getVendor(newVendor).getVendorId());
        assertEquals("vendor name not returned", vendor.getVendorName(), dao.getVendor(newVendor).getVendorName());
        assertEquals("vendor contact name not returned", vendor.getContactName(), dao.getVendor(newVendor).getContactName());
        assertEquals("vendor address not returned", vendor.getAddress(), dao.getVendor(newVendor).getAddress());
        assertEquals("vendor city not returned", vendor.getCity(), dao.getVendor(newVendor).getCity());
        assertEquals("vendor state/province not returned", vendor.getStateProvince(), dao.getVendor(newVendor).getStateProvince());
        assertEquals("vendor postal code not returned", vendor.getPostalCode(), dao.getVendor(newVendor).getPostalCode());
        assertEquals("vendor phone not returned", vendor.getPhone(), dao.getVendor(newVendor).getPhone());
    }

    @Test
    public void addVendor() throws Exception {
        newVendor = dao.addVendor(vendor);
        assertNotEquals("no vendor added", 0, newVendor);
        assertEquals("vendor ID not added", vendor.getVendorId(), dao.getVendor(newVendor).getVendorId());
        assertEquals("vendor name not added", vendor.getVendorName(), dao.getVendor(newVendor).getVendorName());
        assertEquals("vendor contact name not added", vendor.getContactName(), dao.getVendor(newVendor).getContactName());
        assertEquals("vendor address not added", vendor.getAddress(), dao.getVendor(newVendor).getAddress());
        assertEquals("vendor city not added", vendor.getCity(), dao.getVendor(newVendor).getCity());
        assertEquals("vendor state/province not added", vendor.getStateProvince(), dao.getVendor(newVendor).getStateProvince());
        assertEquals("vendor postal code not added", vendor.getPostalCode(), dao.getVendor(newVendor).getPostalCode());
        assertEquals("vendor phone not added", vendor.getPhone(), dao.getVendor(newVendor).getPhone());
    }

    @Test
    public void deleteVendor() throws Exception {
        dao.addVendor(vendor);
        dao.deleteVendor(vendor.getVendorId());
        assertNull("Failed to delete vendor", dao.getVendor(vendor.getVendorId()));
    }

    @Test
    public void updateVendor() throws Exception {
        newVendor = dao.addVendor(vendor);
        vendor.setVendorName("Sugar River Farm");
        vendor.setContactName("Jonas Adams");
        vendor.setAddress("W2726 Doyle Rd");
        vendor.setCity("Belleville");
        vendor.setStateProvince("WI");
        vendor.setPostalCode("53508");
        vendor.setPhone("608-469-0903");
        dao.updateVendor(vendor);
        assertEquals("vendor name change not made", vendor.getVendorName(), dao.getVendor(newVendor).getVendorName());
        assertEquals("vendor contact name change not made", vendor.getContactName(), dao.getVendor(newVendor).getContactName());
        assertEquals("vendor address change not made", vendor.getAddress(), dao.getVendor(newVendor).getAddress());
        assertEquals("vendor city change not made", vendor.getCity(), dao.getVendor(newVendor).getCity());
        assertEquals("vendor state/province change not made", vendor.getStateProvince(), dao.getVendor(newVendor).getStateProvince());
        assertEquals("vendor postal code change not made", vendor.getPostalCode(), dao.getVendor(newVendor).getPostalCode());
        assertEquals("vendor phone change not made", vendor.getPhone(), dao.getVendor(newVendor).getPhone());
    }

}