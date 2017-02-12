package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @author amatheia.
 */
public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try {
            session = openSession();
            users = session.createCriteria(User.class).list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }
        return users;
    }

    /**
     * retrieve a user given their id
     *
     * @param id the user's id
     * @return user
     */
    public User getUser(int id) {
        User user = null;
        Session session = null;
        try {
            session = openSession();
            user = (User) session.get(User.class, id);
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    /** Retrieve users by lastname
     *
     * @param lastName User's last name which is the search criteria
     * @return User
     */
    public List<User> getUsersByLastName(String lastName) {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try {
            session = openSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("lastName", lastName));
            users = criteria.list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e );
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     */
    public int add(User user) {
        int id = 0;
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            id = (int) session.save(user);
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
     * delete a user by id
     * @param id the user's id
     */
    public int deleteUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        int index;

        try {
            tx = session.beginTransaction();
            User user = (User) session.load(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            log.info("Deleted user: " + id);
            index = 1;
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            index = 0;
            log.info("Runtime exception to delete user: " + e);
        } finally {
            session.close();
        }

        return index;
    }

    /**
     * Update the user
     * @param user
     */
    public void updateUser(User user) {
        Transaction tx = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            log.info("Updated: " + user);
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            log.info("Runtime exception to update user: " + e);
        } finally {
            session.close();
        }
    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

}
