package com.producttracker.controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;


/**
 * A servlet to logout users.
 * @author amatheia
 */

@WebServlet("/logout")

public class LogoutServlet extends HttpServlet {

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