package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by graphics on 12/15/2016.
 */
//@WebServlet(name = "AdminLoginServlet",urlPatterns = "/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PrintWriter writer = response.getWriter();
        PrintWriter writer = new PrintWriter("C:\\Users\\Ahmed\\IdeaProjects\\Gadget Store 3\\test.txt");
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
        writer.write(username + "      " + password);
        writer.flush();
        if(username.equals("Admin") && password.equals("gadget_store")){
            writer.println(" Login Successful");
            writer.flush();
            System.out.println("mew");
            RequestDispatcher rd = request.getRequestDispatcher("insertProduct.jsp");
            rd.forward(request,response);
        }
        else {
            System.out.println("could not login");
            writer.println("Could not Login");
            writer.flush();
            RequestDispatcher rd = request.getRequestDispatcher("adminlogin.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
