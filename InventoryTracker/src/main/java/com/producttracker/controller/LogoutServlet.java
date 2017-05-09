package com.producttracker.controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * The Food Inventory Tracker program outputs an inventory management web application
 * for internal use by a restaurant. It implements a food expiration web service to get
 * a food expiration duration. User roles are in place. Registered users are able to add tasks,
 * update the current quantity of a product, and view products, categories, and vendors.
 * Only admin are allowed to completely update a product; add/delete products, categories,
 * and vendors. Only admin may view/update/delete the users list. A registered user may request
 * admin privileges by filling out the contact form.
 *
 * A servlet to logout users.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
@WebServlet(
        name = "logout",
        urlPatterns = { "/logout" }
)
public class LogoutServlet extends HttpServlet {

    /**
     *  Handles HTTP POST requests. Logs out user.
     *  Redirects to login.
     *
     *@param  request               The request parameter
     *@param  response              The response parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession newsession = request.getSession(false);
        if (newsession != null)
        {
            newsession.invalidate();
        }
        response.sendRedirect("/inventorytracker/");
    }

}