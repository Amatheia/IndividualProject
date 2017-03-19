package com.producttracker.controller;

import com.producttracker.entity.Category;
import com.producttracker.persistence.CategoryDao;
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

public class CategoryController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private static String INSERT_OR_EDIT = "/categories.jsp";
    private static String LIST_CATEGORY = "/categoryList.jsp";
    private CategoryDao dao;

    public CategoryController() {
        super();
        dao = new CategoryDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doGet()");

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int categoryid = Integer.parseInt(request.getParameter("categoryId"));
            dao.deleteCategory(categoryid);
            forward = LIST_CATEGORY;
            request.setAttribute("categories", dao.getAllCategories());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int categoryid = Integer.parseInt(request.getParameter("categoryId"));
            Category category = dao.getCategory(categoryid);
            request.setAttribute("category", category);
        } else if (action.equalsIgnoreCase("categorylist")){
            forward = LIST_CATEGORY;
            request.setAttribute("categories", dao.getAllCategories());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doPost()");

        Category cat = new Category();
        cat.setCategoryName(request.getParameter("categoryName"));
        cat.setDescription(request.getParameter("description"));
        String categoryid = request.getParameter("categoryId");
        if(categoryid == null || categoryid.isEmpty())
        {
            dao.addCategory(cat);
        }
        else
        {
            cat.setCategoryId(Integer.parseInt(categoryid));
            dao.updateCategory(cat);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CATEGORY);
        request.setAttribute("categories", dao.getAllCategories());
        view.forward(request, response);

        log.info("Added category: " + request.getParameter("categoryName"));

    }

}
