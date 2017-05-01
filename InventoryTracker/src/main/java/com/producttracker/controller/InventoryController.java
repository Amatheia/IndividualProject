package com.producttracker.controller;

import com.producttracker.entity.Product;
import com.producttracker.persistence.ProductDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to get items and current quantity based on category.
 * @author amatheia
 */
public class InventoryController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    private ProductDao dao;

    public InventoryController() {
        super();
        dao = new ProductDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doPost()");

        Product product = new Product();
        try {
            product.setCurrentQuantity(Integer.parseInt(request.getParameter("currentQuantity")));
        } catch (NumberFormatException e) {
            log.info("NumberFormatException" + e + "null");
            product.setCurrentQuantity(null);
        }

        dao.updateProduct(product);


        RequestDispatcher view = request.getRequestDispatcher("/inventory.jsp");
        request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);


        log.info("Updated product current quantity: " + request.getParameter("currentQuantity"));
    }
}
