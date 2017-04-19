package com.producttracker.controller;

import com.producttracker.entity.Category;
import com.producttracker.persistence.CategoryDao;
import com.producttracker.entity.Product;
import com.producttracker.persistence.ProductDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

/**
 * Created by amatheia on 3/24/17.
 */
/*
public class InventoryCount extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    void ProcessorRequest(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        //String operation = request.getParameter("op");
        //System.out.println("Operation: "+operation);
        String categoryName = request.getParameter("categoryName");
        if (categoryName == null) {
            //System.out.println(request.getRequestURI());
            //TblCountryDAO dao = new TblCountryDAO();
            //List<?> countryList = dao.findAll();
            //request.setAttribute("countryList", countryList);
            RequestDispatcher reqDispatcher = request.getRequestDispatcher("main.jsp");
            reqDispatcher.forward(request, response);
        }
        else
        {
            //System.out.println("in elseif");

            ProductDao pdao = new Product();
            //List<?> provinceList = dao.findByProperty("tblCountry.countryId", Integer.parseInt(cID));
            //request.setAttribute("provinceList", provinceList);
            RequestDispatcher reqDispatcher = request.getRequestDispatcher("main.jsp");
            reqDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ProcessorRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ProcessorRequest(req, resp);
    }
}
*/