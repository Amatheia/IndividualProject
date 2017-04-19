package com.producttracker.controller;

import com.producttracker.entity.User;
import com.producttracker.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by amatheia.
 */
public class UserRegister extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private static String RETURN_TO_LOGIN = "/login.jsp";
    private UserDao dao;

    public UserRegister() {
        super();
        dao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In the doGet()");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("In the doPost()");

        User user = new User();
        user.setRole("registered-user");
        user.setFirstName(request.getParameter("firstname"));
        user.setLastName(request.getParameter("lastname"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        String userid = request.getParameter("userid");
        if(userid == null || userid.isEmpty())
        {
            dao.addUser(user);
        }

        RequestDispatcher view = request.getRequestDispatcher(RETURN_TO_LOGIN);
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);

        log.info("Added user: " + request.getParameter("firstName"));
    }
}
