package com.producttracker.controller;

import com.producttracker.entity.User;
import com.producttracker.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * A servlet to get categories.
 * @author amatheia
 */


public class UserController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/userlist.jsp";
    private UserDao dao;

    public UserController() {
        super();
        dao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doGet()");

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userid = Integer.parseInt(request.getParameter("userid"));
            dao.deleteUser(userid);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userid = Integer.parseInt(request.getParameter("userid"));
            User user = dao.getUser(userid);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("userlist")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doPost()");

        User user = new User();
        user.setRole(request.getParameter("role"));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        String userid = request.getParameter("userid");
        if(userid == null || userid.isEmpty())
        {
            dao.addUser(user);
        }
        else
        {
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);

        log.info("Added user: " + request.getParameter("firstName"));

    }

    
}
