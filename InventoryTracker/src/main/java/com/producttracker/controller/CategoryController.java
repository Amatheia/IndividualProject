package com.producttracker.controller;

import com.producttracker.entity.Category;
import com.producttracker.persistence.CategoryDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
 * A servlet to add categories, perform delete action, and forward to update category form.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = "admin"))
public class CategoryController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private static String INSERT_OR_EDIT = "/categories.jsp";
    private static String LIST_CATEGORY = "/categoryList.jsp";
    private CategoryDao dao;

    public CategoryController() {
        super();
        dao = new CategoryDao();
    }

    /**
     *  Handles HTTP GET requests. Performs delete action. Forwards to update category form.
     *
     *@param  request               The request parameter
     *@param  response              The response parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doGet()");

        String forward = "";
        String action = request.getParameter("action");

        HttpSession session = request.getSession(true);

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

    /**
     *  Handles HTTP POST requests. Gets categories form parameters and adds category to database.
     *  Forwards to category list.
     *
     *@param  request               The request parameter
     *@param  response              The response parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
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
