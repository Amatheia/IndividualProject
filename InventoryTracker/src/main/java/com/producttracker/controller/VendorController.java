package com.producttracker.controller;

import com.producttracker.entity.Vendor;
import com.producttracker.persistence.VendorDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
 * A servlet to add vendors, perform delete action, and forward to update vendor form.
 *
 * @author amatheia
 * @version 1.0
 * @since 2017-05-10
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = "admin"))
public class VendorController extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private static String INSERT_OR_EDIT = "/vendors.jsp";
    private static String LIST_VENDOR = "/vendorlist.jsp";
    private VendorDao dao;

    public VendorController() {
        super();
        dao = new VendorDao();
    }

    /**
     *  Handles HTTP GET requests. Performs delete action. Forwards to update vendor form.
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

        if (action.equalsIgnoreCase("delete")){
            int vendorid = Integer.parseInt(request.getParameter("vendorId"));
            dao.deleteVendor(vendorid);
            forward = LIST_VENDOR;
            request.setAttribute("vendors", dao.getAllVendors());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int vendorid = Integer.parseInt(request.getParameter("vendorId"));
            Vendor vendor = dao.getVendor(vendorid);
            request.setAttribute("vendor", vendor);
        } else if (action.equalsIgnoreCase("vendorlist")){
            forward = LIST_VENDOR;
            request.setAttribute("categories", dao.getAllVendors());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     *  Handles HTTP POST requests. Gets vendors form parameters and adds vendor to database.
     *  Forwards to vendor list.
     *
     *@param  request               The request parameter
     *@param  response              The response parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In the doPost()");

        Vendor vendor = new Vendor();
        vendor.setVendorName(request.getParameter("vendorName"));
        vendor.setContactName(request.getParameter("contactName"));
        vendor.setAddress(request.getParameter("address"));
        vendor.setCity(request.getParameter("city"));
        vendor.setStateProvince(request.getParameter("stateProvince"));
        vendor.setPostalCode(request.getParameter("postalCode"));
        vendor.setPhone(request.getParameter("phone"));
        String vendorid = request.getParameter("vendorId");
        if(vendorid == null || vendorid.isEmpty())
        {
            dao.addVendor(vendor);
        }
        else
        {
            vendor.setVendorId(Integer.parseInt(vendorid));
            dao.updateVendor(vendor);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_VENDOR);
        request.setAttribute("vendors", dao.getAllVendors());
        view.forward(request, response);

        log.info("Added vendor: " + request.getParameter("vendorName"));

    }

}
