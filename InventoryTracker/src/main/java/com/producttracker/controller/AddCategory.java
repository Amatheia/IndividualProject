package com.producttracker.controller;

import com.producttracker.entity.Category;
import com.producttracker.persistence.CategoryDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;


/**
 * A servlet to add categories.
 * @author amatheia
 */

@WebServlet(
        urlPatterns = {"/addCategories"}
)
public class AddCategory extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        response.setContentType("text/plain");

        String categoryName = request.getParameter("categoryName");
        String description = request.getParameter("description");

        Category cat = new Category();
        cat.setCategoryName(categoryName);
        cat.setDescription(description);

        CategoryDao dao = new CategoryDao();

        dao.addCategory(cat);

    }

}
