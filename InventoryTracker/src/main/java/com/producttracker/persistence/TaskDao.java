package com.producttracker.persistence;

import com.producttracker.entity.Task;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by amatheia.
 */
public class TaskDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all categories
     *
     * @return All categories
     */
    public List<Task> getAllTasks() {
        List<Task> tasks = null;
        Session session = null;
        try {
            session = openSession();
            tasks = session.createCriteria(Task.class).list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }
        return tasks;
    }

    /**
     * add a task
     *
     * @param task
     * @return the id of the inserted record
     */
    public int addTask(Task task) {
        int id = 0;
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            id = (int) session.save(task);
            log.info("Inserting record" + task);
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
     * delete a task by id
     * @param id the task's id
     */
    public int deleteTask(int id) {
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            Task task = (Task) session.load(Task.class, id);
            session.delete(task);
            transaction.commit();
            log.info("Deleted task: " + id);
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
     * Update the task
     * @param task
     */
    public void updateTask(Task task) {
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            session.update(task);
            transaction.commit();
            log.info("Updated: " + task);
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
