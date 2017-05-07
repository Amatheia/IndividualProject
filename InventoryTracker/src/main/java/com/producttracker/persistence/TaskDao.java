package com.producttracker.persistence;

import com.producttracker.entity.Task;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by amatheia.
 */
public class TaskDao extends Dao {

    private final Logger log = Logger.getLogger(this.getClass());
    private int id = 0;

    /**
     * Empty constructor assigns session
     */
    public TaskDao() {
        super();
    }

    /** Return a list of all tasks
     *
     * @return All tasks
     */
    public List<Task> getAllTasks() {
        List<Task> tasks;
        tasks = session.createCriteria(Task.class).list();
        return tasks;
    }

    /**
     * retrieve a task given the id
     *
     * @param id the task id
     * @return task
     */
    public Task getTask(int id) {
        log.debug("getting Tasks with id: " + id);
        return (Task)session.get(Task.class, id);
    }

    /**
     * add a task
     *
     * @param task
     * @return the id of the inserted record
     */
    public int addTask(Task task) {
        session.beginTransaction();
        id = (int) session.save(task);
        log.info("Inserting record" + task.getTaskId());
        session.getTransaction().commit();
        return id;
    }

    /**
     * delete a task by id
     * @param id the task's id
     */
    public int deleteTask(int id) {
        session.beginTransaction();
        Task task = (Task) session.load(Task.class, id);
        session.delete(task);
        session.getTransaction().commit();
        log.info("Deleted task: " + id);
        return id;
    }

    /**
     * Update the task
     * @param task
     */
    public void updateTask(Task task) {
        session.beginTransaction();
        session.update(task);
        session.getTransaction().commit();
        log.info("Updated: " + task);
    }
}