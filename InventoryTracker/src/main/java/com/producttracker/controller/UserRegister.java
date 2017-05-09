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

/**
 * The Food Inventory Tracker program outputs an inventory management web application
 * for internal use by a restaurant. It implements a food expiration web service to get
 * a food expiration duration. User roles are in place. Registered users are able to add tasks,
 * update the current quantity of a product, and view products, categories, and vendors.
 * Only admin are allowed to completely update a product; add/delete products, categories,
 * and vendors. Only admin may view/update/delete the users list. A registered user may request
 * admin privileges by filling out the contact form.
 *
 * A servlet to register new users.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
@WebServlet(
        name = "register",
        urlPatterns = { "/register" }
)
public class UserRegister extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private UserDao dao;

    public UserRegister() {
        super();
        dao = new UserDao();
    }

    /**
     *  Handles HTTP POST requests. Gets user registration form parameters
     *  and adds user to database. Forwards to login.
     *
     *@param  request               The request parameter
     *@param  response              The response parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    @Override
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

        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);

        log.info("Added user: " + request.getParameter("firstName"));
    }
}
