package com.producttracker.persistence;

import com.producttracker.entity.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by amalbaugh on 2/25/17.
 */
public class CategoryDaoTest {

    CategoryDao dao;

    @Before
    public void setup() {
        dao = new CategoryDao();
    }

    @Test
    public void getAllCategories() throws Exception {
        List<Category> categories = dao.getAllCategories();
        assertTrue(categories.size() > 0);
    }

    @Test
    public void addCategory(){
        Category cat = new Category();

        cat.setCategoryId(1);
        cat.setCategoryName("Coffee");
        cat.setDescription("green coffee beans");
        dao.addCategory(cat);

        assertEquals("Category name incorrect", "Coffee", dao.getCategory(1).getCategoryName());
    }

}