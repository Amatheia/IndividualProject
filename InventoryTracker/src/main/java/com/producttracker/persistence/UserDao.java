package com.producttracker.persistence;

import com.producttracker.entity.User;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * The Food Inventory Tracker program outputs an inventory management web application
 * for internal use by a restaurant. It implements a food expiration web service to get
 * a food expiration duration. User roles are in place. Registered users are able to add tasks,
 * update the current quantity of a product, and view products, categories, and vendors.
 * Only admin are allowed to completely update a product; add/delete products, categories,
 * and vendors. Only admin may view/update/delete the users list. A registered user may request
 * admin privileges by filling out the contact form.
 *
 * A DAO for the User class. Extends generic Dao.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
public class UserDao extends Dao {

    private final Logger log = Logger.getLogger(this.getClass());
    private int id = 0;

    /**
     * Empty constructor assigns session
     */
    public UserDao() {
        super();
    }

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users;
        users = session.createCriteria(User.class).list();
        log.debug("getting Users: " + users);
        return users;
    }

    /**
     * retrieve a user given their id
     *
     * @param id the user's id
     * @return user
     */
    public User getUser(int id) {
        log.debug("getting User with id: " + id);
        return (User)session.get(User.class, id);
    }

    /**
     * add a user
     *
     * @param user the user object
     * @return the id of the inserted record
     */
    public int addUser(User user) {
        session.beginTransaction();
        id = (int) session.save(user);
        log.info("Inserting record" + user.getUserid());
        session.getTransaction().commit();
        return id;
    }

    /**
     * delete a user by id
     * @param id the user's id
     * @return the id of the deleted record
     */
    public int deleteUser(int id) {
        session.beginTransaction();
        User user = (User)session.load(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        log.info("Deleted user: " + id);
        return id;
    }

    /**
     * Update the user
     * @param user the user object
     */
    public void updateUser(User user) {
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
        log.info("Updated: " + user);
    }

}
