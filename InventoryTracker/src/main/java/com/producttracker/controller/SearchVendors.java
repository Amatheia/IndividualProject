package com.producttracker.controller;

import com.producttracker.persistence.VendorDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * A servlet to get vendors.
 * @author amatheia
 */

@WebServlet(
        urlPatterns = {"/searchVendors"}
)

public class SearchVendors extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("In the doGet()");

        VendorDao vendorData = new VendorDao();
        req.setAttribute("vendors", vendorData.getAllVendors());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/addvendor.jsp");
        dispatcher.forward(req, resp);

    }


}

