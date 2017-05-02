package com.producttracker.controller;

import com.producttracker.entity.Task;
import com.producttracker.persistence.TaskDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by amatheia.
 */
public class TaskController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private TaskDao dao;

    public TaskController() {
        super();
        dao = new TaskDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doGet()");

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int taskid = Integer.parseInt(request.getParameter("taskId"));
            dao.deleteTask(taskid);
            response.sendRedirect("/inventorytracker/");
            request.setAttribute("tasks", dao.getAllTasks());
        } else {
            response.sendRedirect("/inventorytracker/");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doPost()");
        String taskDescription = request.getParameter("taskDescription");
        Task tsk = new Task();
        tsk.setTaskDescription(taskDescription);
        String taskid = request.getParameter("taskId");
        if(taskid == null || taskid.isEmpty())
        {
            dao.addTask(tsk);
        }
        else
        {
            tsk.setTaskId(Integer.parseInt(taskid));
            dao.updateTask(tsk);
        }

        response.sendRedirect("/inventorytracker/");

        log.info("Added task: " + taskid);

    }
}
