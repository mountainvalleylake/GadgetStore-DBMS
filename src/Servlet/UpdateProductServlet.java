package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by graphics on 12/15/2016.
 */
//@WebServlet(name = "UpdateProductServlet",urlPatterns = "/UpdateProduct")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //in order to know which product we are updating we need to get its name, brand, category and model no
        // Please create such a way in JSP that we can get these four item parameters.
        //give the variable names according to the code written below
//        String product_name = request.getParameter("pname");
//        String brand = request.getParameter("brand");
//        String category = request.getParameter("cat");
//        String modelstr = request.getParameter("model");
//        int model_no = Integer.parseInt(modelstr);
        String pricestr = request.getParameter("price");
        float price = Float.parseFloat(pricestr);
        String quantitystr = request.getParameter("quantity");
        int quantity = Integer.parseInt(quantitystr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
