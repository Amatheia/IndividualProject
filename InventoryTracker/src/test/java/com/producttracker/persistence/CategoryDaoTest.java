package com.producttracker.persistence;

import com.producttracker.entity.Category;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by amatheia on 2/25/17.
 */
public class CategoryDaoTest {

    CategoryDao dao;
    Category category;
    int newCategory = 0;

    @Before
    public void setUp() throws Exception {
        dao = new CategoryDao();
        category = new Category();
        category.setCategoryName("coffee");
        category.setDescription("coffee beans");
    }

    @After
    public void tearDown() throws Exception {
        // cleans up test category
        if (newCategory != 0) {
            dao.deleteCategory(newCategory);
        }
    }

    @Test
    public void getAllCategories() throws Exception {
        newCategory = dao.addCategory(category);
        List<Category> categories = dao.getAllCategories();
        assertTrue(categories.size() > 0);
    }

    @Test
    public void getCategory() throws Exception {
        newCategory = dao.addCategory(category);
        assertNotNull("category not returned", dao.getCategory(newCategory));
        assertEquals("category ID not returned", category.getCategoryId(), dao.getCategory(newCategory).getCategoryId());
        assertEquals("category name not returned", category.getCategoryName(), dao.getCategory(newCategory).getCategoryName());
        assertEquals("category description not returned", category.getDescription(), dao.getCategory(newCategory).getDescription());
    }

    @Test
    public void addCategory() throws Exception {
        newCategory = dao.addCategory(category);
        assertNotEquals("no category added", 0, newCategory);
        assertEquals("category ID not added", category.getCategoryId(), dao.getCategory(newCategory).getCategoryId());
        assertEquals("category name not added", category.getCategoryName(), dao.getCategory(newCategory).getCategoryName());
        assertEquals("category description not added", category.getDescription(), dao.getCategory(newCategory).getDescription());
    }

    @Test
    public void deleteCategory() throws Exception {
        dao.addCategory(category);
        dao.deleteCategory(category.getCategoryId());
        assertNull("Failed to delete category", dao.getCategory(category.getCategoryId()));
    }

    @Test
    public void updateCategory() throws Exception {
        newCategory = dao.addCategory(category);
        category.setCategoryName("tea");
        category.setDescription("loose leaf teas");
        dao.updateCategory(category);
        assertEquals("category name change not made", category.getCategoryName(), dao.getCategory(newCategory).getCategoryName());
        assertEquals("category description change not made", category.getDescription(), dao.getCategory(newCategory).getDescription());
    }

}