package com.producttracker.controller;

import com.producttracker.persistence.CategoryDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * A servlet to get categories.
 * @author amatheia
 */

@WebServlet(
        urlPatterns = {"/searchCategories"}
)

public class SearchCategories extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("In the doGet()");

        CategoryDao categoryData = new CategoryDao();
        req.setAttribute("categories", categoryData.getAllCategories());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/addcategories.jsp");
        dispatcher.forward(req, resp);

    }


}
