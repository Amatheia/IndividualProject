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
 * A servlet to add tasks and perform delete action.
 *
 * The Food Inventory Tracker program outputs an inventory management web application
 * for internal use by a restaurant. It implements a food expiration web service to get
 * a food expiration duration. User roles are in place. Registered users are able to add tasks,
 * update the current quantity of a product, and view products, categories, and vendors.
 * Only admin are allowed to completely update a product; add/delete products, categories,
 * and vendors. Only admin may view/update/delete the users list. A registered user may request
 * admin privileges by filling out the contact form.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
public class TaskController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private TaskDao dao;

    public TaskController() {
        super();
        dao = new TaskDao();
    }

    /**
     *  Handles HTTP GET requests. Performs delete action.
     *
     *@param  request               The request parameter
     *@param  response              The response parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
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

    /**
     *  Handles HTTP POST requests. Gets task form parameters and adds task to database.
     *
     *@param  request               The request parameter
     *@param  response              The response parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
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
