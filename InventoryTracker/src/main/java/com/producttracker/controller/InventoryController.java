package com.producttracker.controller;

import com.producttracker.entity.Product;
import com.producttracker.persistence.ProductDao;
import com.producttracker.persistence.SessionFactoryProvider;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to get a product and update current quantity.
 *
 * The Food Inventory Tracker program outputs an inventory management web application
 * for internal use by a restaurant. It implements a food expiration web service to get
 * a food expiration duration. User roles are in place. Registered users are able to add tasks,
 * update the current quantity of a product, and view products, categories, and vendors.
 * Only admin are allowed to completely update a product; add/delete products, categories,
 * and vendors. Only admin may view/update/delete the users list. A registered user may request
 * admin privileges by filling out the contact form.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
public class InventoryController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    private ProductDao dao;

    public InventoryController() {
        super();
        dao = new ProductDao();
    }

    /**
     *  Handles HTTP POST requests. Gets product and current quantity parameters.
     *  Updates current quantity field. Forwards to category list.
     *
     *@param  request               The request parameter
     *@param  response              The response parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doPost()");

        int productId = Integer.parseInt(request.getParameter("productList"));
        int currentQuantity = Integer.parseInt(request.getParameter("currentQuantity"));

        SessionFactory factory = SessionFactoryProvider.getSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Product product = (Product) session.get(Product.class, productId);
        product.setCurrentQuantity(currentQuantity);
        session.update(product);
        tx.commit();
        session.close();

        RequestDispatcher view = request.getRequestDispatcher("/inventory.jsp");
        request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);

        log.info("Updated product current quantity: " + currentQuantity);
    }
}
