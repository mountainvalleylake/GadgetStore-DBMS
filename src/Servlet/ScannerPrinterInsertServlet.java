package Servlet;

import Database.DBManager;
import Database.Products;
import Database.ScannerPrinter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by graphics on 12/15/2016.
 */
//@WebServlet(name = "ScannerPrinterInsertServlet",urlPatterns = "/ScannerPrinterInsert")
public class ScannerPrinterInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String product_name =  request.getParameter("pname");
        String mnon = request.getParameter("mno");
        int model_no = Integer.parseInt(mnon);
        System.out.println(model_no);
        String brand_name =  request.getParameter("bname");
        String category =  request.getParameter("cat");
        String prices =  request.getParameter("price");
        float price = Float.parseFloat(prices);
        String wars =  request.getParameter("war");
        int warranty = Integer.parseInt(wars);
        System.out.println(warranty);
        String quants =  request.getParameter("quant");
        int quantity = Integer.parseInt(quants);
        //Insert Products
        DBManager dbm = new DBManager();
        Connection conn = dbm.getConnection();
        Products products = new Products(product_name,model_no,brand_name,category,price,warranty,quantity);
        products.SetConnection(conn);
        int id = products.ProductsInsertDB(products);
        String interfaces = request.getParameter("intef");
        String resolution = request.getParameter("resl");
        float speed = Float.parseFloat(request.getParameter("speed"));
        String paper = request.getParameter("pap");
        //
        ScannerPrinter sp = new ScannerPrinter(id,interfaces,resolution,speed,paper);
        sp.SetConnection(conn);
        int validate = sp.SPInsertDB(sp);
        RequestDispatcher rd = request.getRequestDispatcher("insertProduct.jsp");
        rd.forward(request,response);

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
