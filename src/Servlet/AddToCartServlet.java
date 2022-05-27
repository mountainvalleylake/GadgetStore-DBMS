package Servlet;

import Database.Cart;
import Database.DBManager;
import Database.StuffsBought;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by graphics on 12/16/2016.
 */
//@WebServlet(name = "AddToCartServlet",urlPatterns = "/AddToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("before httpsession");
        HttpSession session = request.getSession();
        System.out.println("after httpsession");
        int customer_id = -1;
        customer_id = (int) session.getAttribute("User_ID");
        if(customer_id == -1){
            System.out.println(customer_id+" hahahaha");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }
        else {
            Cart cart = (Cart) session.getAttribute("Cart");
            System.out.println("before dbmanager");
            DBManager dbManager = new DBManager();
            System.out.println("after dbmanager");
            //dbManager.SetConnection();
            Connection connection = dbManager.getConnection();
            System.out.println("after connection");
            cart.SetConnection(connection);
            System.out.println("after setconnection");
            //cart.AddCartOrdertoDB(cart);
            String pid =  request.getParameter("prid");
            System.out.println(pid);
            String quant = request.getParameter("qty");
            System.out.println(quant);
            int quantity = Integer.parseInt(quant);
            System.out.println(quantity);
            int product_id = Integer.parseInt(pid);
//            System.out.println(product_id);
//            System.out.println("before added");
            cart.addProduct_ID(product_id,cart.getOrder_id(),quantity);//add this product to cart_item table
            String pname = cart.getProductName(product_id);//get the product Name.
            System.out.println("after added");
            float cost = cart.UpdateTotalCost(cart.getOrder_id(),product_id);//Update Total Cost in Cart table
            float totalcost = cart.getTotal_cost();
            cart.UpdateQuantity(product_id,quantity);//decrease the amount taken
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index1.jsp");
            requestDispatcher.forward(request,response);
            StuffsBought stuffsBought = new StuffsBought(pname,quantity,cost);
            cart.stuffList.add(stuffsBought);
            session.setAttribute("Stuff",cart.stuffList);
            //session.setAttribute("TotalCost",totalcost);
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
