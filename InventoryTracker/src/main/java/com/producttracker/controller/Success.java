package com.producttracker.controller;

import java.io.IOException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by amalbaugh on 2/25/17.
 */

@WebServlet(
        urlPatterns = {"/success"}
)

public class Success extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("In the doGet()");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/usersuccess.jsp");
        dispatcher.forward(req, resp);

    }

}

