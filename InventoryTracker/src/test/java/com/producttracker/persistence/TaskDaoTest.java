package com.producttracker.persistence;

import com.producttracker.entity.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by amatheia.
 */
public class TaskDaoTest {

    TaskDao dao;
    Task task;
    int newTask = 0;

    @Before
    public void setUp() throws Exception {
        dao = new TaskDao();
        task = new Task();
        task.setTaskDescription("order 5 bags of apples");
    }

    @After
    public void tearDown() throws Exception {
        // cleans up test task
        if (newTask != 0) {
            dao.deleteTask(newTask);
        }
    }

    @Test
    public void getAllTasks() throws Exception {
        newTask = dao.addTask(task);
        List<Task> tasks = dao.getAllTasks();
        assertTrue(tasks.size() > 0);
    }

    @Test
    public void getTask() throws Exception {
        newTask = dao.addTask(task);
        assertNotNull("task not returned", dao.getTask(newTask));
        assertEquals("task ID not returned", task.getTaskId(), dao.getTask(newTask).getTaskId());
        assertEquals("task description not returned", task.getTaskDescription(), dao.getTask(newTask).getTaskDescription());
    }

    @Test
    public void addTask() throws Exception {
        newTask = dao.addTask(task);
        assertNotEquals("no task added", 0, newTask);
        assertEquals("task ID not added", task.getTaskId(), dao.getTask(newTask).getTaskId());
        assertEquals("task description not added", task.getTaskDescription(), dao.getTask(newTask).getTaskDescription());
    }

    @Test
    public void deleteTask() throws Exception {
        dao.addTask(task);
        dao.deleteTask(task.getTaskId());
        assertNull("Failed to delete task", dao.getTask(task.getTaskId()));
    }

    @Test
    public void updateTask() throws Exception {
        newTask = dao.addTask(task);
        task.setTaskDescription("order 4 bags of oranges");
        dao.updateTask(task);
        assertEquals("task description change not made", task.getTaskDescription(), dao.getTask(newTask).getTaskDescription());
    }

}