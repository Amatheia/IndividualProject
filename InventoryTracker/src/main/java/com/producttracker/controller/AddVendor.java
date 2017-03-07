package com.producttracker.controller;

import com.producttracker.entity.Vendor;
import com.producttracker.persistence.VendorDao;
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
 * A servlet to add vendors.
 * @author amatheia
 */

@WebServlet(
        urlPatterns = {"/addVendor"}
)
public class AddVendor extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        response.setContentType("text/plain");

        String vendorName = request.getParameter("vendorName");
        String contactName = request.getParameter("contactName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String stateProvince = request.getParameter("stateProvince");
        String postalCode = request.getParameter("postalCode");
        String phone = request.getParameter("phone");

        Vendor vendor = new Vendor();
        vendor.setVendorName(vendorName);
        vendor.setContactName(contactName);
        vendor.setAddress(address);
        vendor.setCity(city);
        vendor.setStateProvince(stateProvince);
        vendor.setPostalCode(postalCode);
        vendor.setPhone(phone);

        VendorDao dao = new VendorDao();

        dao.addVendor(vendor);

    }

}

