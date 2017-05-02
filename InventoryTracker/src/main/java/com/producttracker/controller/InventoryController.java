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
