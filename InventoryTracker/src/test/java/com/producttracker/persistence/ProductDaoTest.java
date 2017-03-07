package com.producttracker.persistence;

import com.producttracker.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.List;
import java.math.BigDecimal;

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

    @Test
    public void addProduct(){
        Product p = new Product();

        p.setProductId(1);
        p.setAddDate(new java.sql.Date(new GregorianCalendar(2017, 03, 05).getTime().getTime()));
        p.setCategoryName("Coffee");
        p.setVendorName("Royal Coffee");
        p.setProductName("Indonesian Bali Blue Moon");
        p.setQuantityOrdered(5);
        p.setWeight(60);
        p.setPerUnitCost(BigDecimal.valueOf(3.50));
        p.setTotalCost(BigDecimal.valueOf(17.50));
        p.setOrderDate(new java.sql.Date(new GregorianCalendar(2017, 03, 05).getTime().getTime()));
        dao.addProduct(p);

        assertEquals("Product name incorrect", "Indonesian Bali Blue Moon", dao.getProduct(1).getProductName());
    }

}