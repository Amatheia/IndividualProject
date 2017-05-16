package com.producttracker.persistence;

import com.producttracker.entity.Category;
import org.apache.log4j.Logger;

import java.util.List;

/**
 *  A DAO for the Category class. Extends generic Dao.
 *
 * The Food Inventory Tracker program outputs an inventory management web application
 * for internal use by a restaurant. It implements a food expiration web service to get
 * a food expiration duration. User roles are in place. Registered users are able to add tasks,
 * update the current quantity of a product, and view products, categories, and vendors.
 * Only admin are allowed to completely update a product; add/delete products, categories,
 * and vendors. Only admin may view/update/delete the users list. A registered user may request
 * admin privileges by filling out the contact form.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
public class CategoryDao extends Dao {

    private final Logger log = Logger.getLogger(this.getClass());
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
     * @param category the category object
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
     * @return the id of the deleted record
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
     * @param category the category object
     */
    public void updateCategory(Category category) {
        session.beginTransaction();
        session.merge(category);
        session.getTransaction().commit();
        log.info("Updated: " + category);
    }
}
