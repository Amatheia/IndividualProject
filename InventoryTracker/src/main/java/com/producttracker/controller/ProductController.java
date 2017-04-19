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
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A servlet to get products.
 * @author amatheia
 */

public class ProductController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private static String INSERT_OR_EDIT = "/products.jsp";
    private static String LIST_PRODUCT = "/inventory.jsp";
    private ProductDao dao;

    public ProductController() {
        super();
        dao = new ProductDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doGet()");

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int productid = Integer.parseInt(request.getParameter("productId"));
            dao.deleteProduct(productid);
            forward = LIST_PRODUCT;
            request.setAttribute("products", dao.getAllProducts());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int productid = Integer.parseInt(request.getParameter("productId"));
            Product product = dao.getProduct(productid);
            request.setAttribute("product", product);
        } else if (action.equalsIgnoreCase("productlist")){
            forward = LIST_PRODUCT;
            request.setAttribute("products", dao.getAllProducts());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doPost()");

        Product product = new Product();
        product.setCategoryName(request.getParameter("categoryName"));
        product.setVendorName(request.getParameter("vendorName"));
        product.setProductName(request.getParameter("productName"));
        product.setQuantityOrdered(Integer.parseInt(request.getParameter("quantityOrdered")));
        product.setWeight(Integer.parseInt(request.getParameter("weight")));
        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator(',');
            symbols.setDecimalSeparator('.');
            String pattern = "#,####.00";
            DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
            decimalFormat.setParseBigDecimal(true);
            // parse the string
            BigDecimal bigDecimal = (BigDecimal) decimalFormat.parse(request.getParameter("perUnitCost"));
            product.setPerUnitCost(bigDecimal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate orderDate = LocalDate.parse(request.getParameter("orderDate"), formatter);
            product.setOrderDate(orderDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateReceived = LocalDate.parse(request.getParameter("dateReceived"), formatter);
            product.setDateReceived(dateReceived);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            product.setQuantityReceived(Integer.parseInt(request.getParameter("quantityReceived")));
        } catch (NumberFormatException e) {
            product.setQuantityReceived(null);
        }

        try {
            product.setPaidNotReceived(Integer.parseInt(request.getParameter("paidNotReceived")));
        } catch (NumberFormatException e) {
            product.setPaidNotReceived(null);
        }

        try {
            product.setCurrentQuantity(Integer.parseInt(request.getParameter("currentQuantity")));
        } catch (NumberFormatException e) {
            product.setCurrentQuantity(null);
        }

        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator(',');
            symbols.setDecimalSeparator('.');
            String pattern = "#,####.00";
            DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
            decimalFormat.setParseBigDecimal(true);
            // parse the string
            BigDecimal bigDecimal = (BigDecimal) decimalFormat.parse(request.getParameter("currentValue"));
            product.setCurrentValue(bigDecimal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate expirationDate = LocalDate.parse(request.getParameter("expirationDate"), formatter);
            product.setExpirationDate(expirationDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setNotes(request.getParameter("notes"));
        String productid = request.getParameter("productId");
        if(productid == null || productid.isEmpty())
        {
            dao.addProduct(product);
        }
        else
        {
            product.setProductId(Integer.parseInt(productid));
            dao.updateProduct(product);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUCT);
        request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);

        log.info("Added product: " + request.getParameter("productName"));
    }
}
