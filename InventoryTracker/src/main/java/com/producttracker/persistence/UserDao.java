package com.producttracker.persistence;

import com.producttracker.entity.User;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author amatheia.
 */
public class UserDao extends Dao {

    private final Logger log = Logger.getLogger(this.getClass());
    private Dao genDao = new Dao();
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
     * @param user
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
     * @param user
     */
    public void updateUser(User user) {
        genDao.session.beginTransaction();
        genDao.session.update(user);
        genDao.session.getTransaction().commit();
        log.info("Updated: " + user);
    }

}
