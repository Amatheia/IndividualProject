package com.producttracker.controller;

import com.producttracker.entity.User;
import com.producttracker.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;


/**
 * A servlet to add users.
 * @author amatheia
 */

@WebServlet(
        urlPatterns = {"/addUser"}
)
public class AddUser extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



    }

}
