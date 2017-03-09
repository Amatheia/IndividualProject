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
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.http.HttpSession;


/**
 * A servlet to add users.
 * @author amatheia
 */

@WebServlet(
        urlPatterns = {"/addUser"}
)
public class AddUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        response.setContentType("text/plain");

        String role = request.getParameter("role");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setRole(role);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.getDateAdded();

        UserDao dao = new UserDao();

        dao.addUser(user);

        log.info("Added user: " + firstName);

    }

}
