package com.producttracker.persistence;

import com.producttracker.entity.Category;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author amatheia.
 */
public class CategoryDao extends Dao {

    private final Logger log = Logger.getLogger(this.getClass());
    private Dao genDao = new Dao();
    private int id = 0;

    /**
     * Empty constructor assigns session
     */
    public CategoryDao() {
        super();
    }

    /** Return a list of all categories
     *
     * @return All categories
     */
    public List<Category> getAllCategories() {
        List<Category> categories;
        categories = session.createCriteria(Category.class).list();
        return categories;
    }

    /**
     * retrieve a category given the id
     *
     * @param id the category id
     * @return category
     */
    public Category getCategory(int id) {
        log.debug("getting Categories with id: " + id);
        return (Category)session.get(Category.class, id);
    }

    /**
     * add a category
     *
     * @param category
     * @return the id of the inserted record
     */
    public int addCategory(Category category) {
        session.beginTransaction();
        id = (int)session.save(category);
        log.info("Inserting record" + category.getCategoryId());
        session.getTransaction().commit();
        return id;
    }

    /**
     * delete a category by id
     * @param id the category's id
     */
    public int deleteCategory(int id) {
        session.beginTransaction();
        Category category = (Category) session.load(Category.class, id);
        session.delete(category);
        session.getTransaction().commit();
        log.info("Deleted category: " + id);
        return id;
    }

    /**
     * Update the category
     * @param category
     */
    public void updateCategory(Category category) {
        genDao.session.beginTransaction();
        genDao.session.update(category);
        genDao.session.getTransaction().commit();
        log.info("Updated: " + category);
    }
}
