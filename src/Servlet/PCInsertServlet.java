package Servlet;

import Database.DBManager;
import Database.PC;
import Database.Products;

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
//@WebServlet(name = "PCInsertServlet",urlPatterns = "/PCInsert")
public class PCInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String product_name =  request.getParameter("pname");
        String mnon = request.getParameter("mno");
        int model_no = Integer.parseInt(mnon);
        String brand_name =  request.getParameter("bname");
        String category =  request.getParameter("cat");
        String prices =  request.getParameter("price");
        float price = Float.parseFloat(prices);
        String wars =  request.getParameter("war");
        int warranty = Integer.parseInt(wars);
        System.out.println(warranty);
        String quants =  request.getParameter("quant");
        int quantity = Integer.parseInt(quants);
        //Insert PC
        DBManager dbm = new DBManager();
        Connection conn = dbm.getConnection();
        Products products = new Products(product_name,model_no,brand_name,category,price,warranty,quantity);
        products.SetConnection(conn);
        int id = products.ProductsInsertDB(products);
        float RAM = Float.parseFloat( request.getParameter("ram"));
        int hdd = Integer.parseInt( request.getParameter("hdd"));
        String core =  request.getParameter("core");
        String graphics =  request.getParameter("graph");
        //
        PC pc = new PC(id,hdd,core,graphics,RAM);
        pc.SetConnection(conn);
        System.out.println("before PC Insert call");
        int validate = pc.PCInsertDB(pc);
        System.out.println("validate "+validate);
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
