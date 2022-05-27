package Servlet;

import Database.Cart;
import Database.Customer;
import Database.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by graphics on 12/14/2016.
 */
//@WebServlet(name = "LoginServlet",urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login servlet e asi mama");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        String username = request.getParameter("uname");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        DBManager dbm = new DBManager();
        Connection connection = dbm.getConnection();
        Customer c = new Customer();
        c.SetConnection(connection);
        int validation = c.LoginCustomer(username,email,password);
        if(validation == 1){
            //writer.println("Login Successful");
            System.out.println("logged in");
            int id = dbm.getCustomerID(username,email);
            System.out.println("id is "+ id);
            session.setAttribute("UserName",username);
            session.setAttribute("Email",email);
            session.setAttribute("User_ID",id);
            String address = c.getAddress(id);
            Cart cart = new Cart();
            cart.setCustomer_id(id);
            cart.setUser_name(username);
            cart.setEmail(email);
            cart.SetConnection(connection);
            int added_order = cart.AddCartOrdertoDB(cart,username,email,address,id);//create a new cart for the customer after login
            session.setAttribute("order_id",added_order);
            session.setAttribute("Cart",cart);
            RequestDispatcher rd = request.getRequestDispatcher("index1.jsp");
            rd.forward(request,response);

        }
        else {
            writer.println("Try again");
            RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
            rd.forward(request,response);
        }
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
