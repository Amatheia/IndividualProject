package com.producttracker.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * The Food Inventory Tracker program outputs an inventory management web application
 * for internal use by a restaurant. It implements a food expiration web service to get
 * a food expiration duration. User roles are in place. Registered users are able to add tasks,
 * update the current quantity of a product, and view products, categories, and vendors.
 * Only admin are allowed to completely update a product; add/delete products, categories,
 * and vendors. Only admin may view/update/delete the users list. A registered user may request
 * admin privileges by filling out the contact form.
 *
 * A class to represent a task.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "task_id")
    private int taskId;

    @Column(name="task_description")
    private String taskDescription;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="task_date_added", insertable=false, updatable=false)
    private Date taskDateAdded;

    /**
     * Instantiates a new Task.
     */
    public Task() {
    }

    /**
     * Instantiates a new Task.
     *
     * @param taskId    the task id
     * @param taskDescription   the task description
     * @param taskDateAdded    the task date added
     */
    public Task(int taskId, String taskDescription, Date taskDateAdded) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskDateAdded = taskDateAdded;
    }

    /**
     * Gets taskId.
     *
     * @return the taskId
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * Sets taskId.
     *
     * @param taskId the taskId
     */
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    /**
     * Gets taskDescription.
     *
     * @return the taskDescription
     */
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * Sets taskDescription.
     *
     * @param taskDescription the task description
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * Gets taskDateAdded.
     *
     * @return the taskDateAdded
     */
    public Date getTaskDateAdded() {
        return taskDateAdded;
    }

    @Override
    public String toString() {
        return "{" +
                "taskId=" + taskId +
                ", taskDescription=" + taskDescription +
                ", taskDateAdded=" + taskDateAdded +
                '}';
    }

}

