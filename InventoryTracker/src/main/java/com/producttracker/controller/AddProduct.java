package com.producttracker.controller;

import com.producttracker.entity.Product;
import com.producttracker.persistence.ProductDao;
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
 * A servlet to add products.
 * @author amatheia
 */

@WebServlet(
        urlPatterns = {"/addProduct"}
)
public class AddProduct extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        response.setContentType("text/plain");

        String categoryName = request.getParameter("categoryName");
        String vendorName = request.getParameter("vendorName");
        String productName = request.getParameter("productName");
        //String quantityOrdered = request.getParameter("quantityOrdered");
        //String weight = request.getParameter("weight");
        //String perUnitCost = request.getParameter("perUnitCost");
        //String totalCost = request.getParameter("totalCost");
        //String orderDate = request.getParameter("orderDate");
        //String dateReceived = request.getParameter("dateReceived");
        String notes = request.getParameter("notes");

        Product product = new Product();
        product.setCategoryName(categoryName);
        product.setVendorName(vendorName);
        product.setProductName(productName);
        //product.setQuantityOrdered(quantityOrdered);
        //product.setWeight(weight);
        //product.setPerUnitCost(perUnitCost);
        //product.setTotalCost(totalCost);
        //product.setOrderDate(orderDate);
        //product.setDateReceived(dateReceived);
        product.setNotes(notes);

        ProductDao dao = new ProductDao();

        dao.addProduct(product);

    }

}

