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
    List<Category> categoriesList;

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

    /** Retrieve categories by name
     *
     * @param categoryName Category's name which is the search criteria
     * @return Category
     */
    public List<Category> getCategoriesList(String categoryName) {
        categoriesList = new ArrayList<Category>();
        Session session = null;
        try {
            session = openSession();
            Criteria criteria = session.createCriteria(Category.class);
            criteria.add(Restrictions.eq("categoryName", categoryName));
            categoriesList = criteria.list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e );
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return categoriesList;
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

    /**
     * delete a category by id
     * @param id the category's id
     */
    public int deleteCategory(int id) {
        Session session = null;

        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            Category category = (Category) session.load(Category.class, id);
            session.delete(category);
            transaction.commit();
            log.info("Deleted category: " + id);
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

    /**
     * Update the category
     * @param category
     */
    public void updateCategory(Category category) {
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            session.update(category);
            transaction.commit();
            log.info("Updated: " + category);
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
