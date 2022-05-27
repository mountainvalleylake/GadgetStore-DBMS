package Servlet;

import Database.Customer;
import Database.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by graphics on 12/14/2016.
 */
//@WebServlet(name = "SignUpServlet",urlPatterns = "/SignUp")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println("Hello can you hear me!");
        PrintWriter writer = response.getWriter();
        String first_name = request.getParameter("fname");//request.getParameter(string) helps us get data from the webpage
        String last_name = request.getParameter("lname");
        String user_name = request.getParameter("uname");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String address = request.getParameter("address");
        String date_of_birth = request.getParameter("dob");
        DBManager dbm = new DBManager();
        Connection conn = dbm.getConnection();
        Customer c = new Customer();
        c.SetConnection(conn);
        c.SetThings(first_name,last_name,user_name,email,password,address,date_of_birth);
        int count = c.CustomerInsertDB();
        if(count==1){
            writer.println("Insertion Successful");
            System.out.println("Yes");
            RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
            rd.forward(request, response);
        }
        else{
            writer.println("Couldn't Insert");
            System.out.println("No");
            RequestDispatcher rd = request.getRequestDispatcher("UserSignUp.jsp");
            rd.forward(request,response);
        }
        try {
            if(conn != null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
