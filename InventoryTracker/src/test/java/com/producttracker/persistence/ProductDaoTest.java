package com.producttracker.persistence;

import com.producttracker.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by amalbaugh on 2/25/17.
 */
public class ProductDaoTest {

    ProductDao dao;

    @Before
    public void setup() {
        dao = new ProductDao();
    }


    @Test
    public void getAllProducts() throws Exception {
        List<Product> products = dao.getAllProducts();
        assertTrue(products.size() > 0);
    }
/*
    @Test
    public void addProduct(){
        Product p = new Product();
        CategoryDao cat = new CategoryDao();
        Category id = cat.getCategory(2);
        VendorDao v = new VendorDao();
        Vendor vid = v.getVendor(5);
        p.setProductId(9);
        p.setCategory(id);
        p.setVendor(vid);
        p.setProductName("Celery");
        p.setQuantityOrdered(5);
        p.setWeight(BigDecimal.valueOf(10));
        p.setPerUnitCost(BigDecimal.valueOf(3.50));
        dao.addProduct(p);

        assertEquals("Product name incorrect", "Celery", dao.getProduct(9).getProductName());
    }
*/
}