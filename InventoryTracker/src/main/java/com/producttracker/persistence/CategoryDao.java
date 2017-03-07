package com.producttracker.persistence;

import com.producttracker.entity.Category;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amatheia.
 */
public class CategoryDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all categories
     *
     * @return All categories
     */
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<Category>();
        Session session = null;
        try {
            session = openSession();
            categories = session.createCriteria(Category.class).list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }
        return categories;
    }

    /**
     * retrieve a category given their id
     *
     * @param id the category's id
     * @return category
     */
    public Category getCategory(int id) {
        Category category = null;
        Session session = null;
        try {
            session = openSession();
            category = (Category) session.get(Category.class, id);
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return category;
    }


    /**
     * add a category
     *
     * @param category
     * @return the id of the inserted record
     */
    public int addCategory(Category category) {
        int id = 0;
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            id = (int) session.save(category);
            log.info("Inserting record" + category);
            transaction.commit();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return id;
    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
