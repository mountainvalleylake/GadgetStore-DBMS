package Servlet;

import Database.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * Created by graphics on 12/13/2016.
 */
//@WebServlet(name = "ScannerPrinterServlet",urlPatterns = "/ScannerPrinter")
public class ScannerPrinterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager dbm = new DBManager();
        Connection connection = dbm.getConnection();
        RequestDispatcher rd = request.getRequestDispatcher("scannerpage.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
