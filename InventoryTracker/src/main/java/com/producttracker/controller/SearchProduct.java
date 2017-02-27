package com.producttracker.controller;

import com.producttracker.persistence.ProductDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * A servlet to get products.
 * @author amatheia
 */

@WebServlet(
        urlPatterns = {"/searchProduct"}
)

public class SearchProduct extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("In the doGet()");

        ProductDao productData = new ProductDao();
        req.setAttribute("products", productData.getAllProducts());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/inventory.jsp");
        dispatcher.forward(req, resp);

    }


}
