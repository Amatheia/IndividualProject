package com.producttracker.persistence;

import com.producttracker.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

}