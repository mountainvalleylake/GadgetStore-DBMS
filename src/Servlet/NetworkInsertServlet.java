package Servlet;

import Database.DBManager;
import Database.Networks;
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
//@WebServlet(name = "NetworkInsertServlet",urlPatterns = "/NetworkInsert")
public class NetworkInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String product_name =  request.getParameter("pname");
        System.out.println(product_name);
        String mnon =  request.getParameter("mno");
        int model_no = Integer.parseInt(mnon);
        System.out.println(model_no);
        String brand_name =  request.getParameter("bname");
        System.out.println(brand_name);
        String category =  request.getParameter("cat");
        System.out.println(category);
        String prices =  request.getParameter("price");
        float price = Float.parseFloat(prices);
        System.out.println(price);
        String wars =  request.getParameter("war");
        int warranty = Integer.parseInt(wars);
        System.out.println(warranty);
        String quants =  request.getParameter("quant");
        int quantity = Integer.parseInt(quants);
        System.out.println(quantity);
        //Insert Products
        DBManager dbm = new DBManager();
        Connection conn = dbm.getConnection();
        Products products = new Products(product_name,model_no,brand_name,category,price,warranty,quantity);
        products.SetConnection(conn);
        //Insert into networks
        int id = products.ProductsInsertDB(products);
        float trate = Float.parseFloat(request.getParameter("trate"));
        System.out.println(trate);
        String antena = request.getParameter("ant");
        System.out.println(antena);
        String range = request.getParameter("rang");
        System.out.println(range);
        //finally insert
        Networks networks = new Networks(id,trate,antena,range);
        networks.SetConnection(conn);
        int validate = networks.NetInsertDB(networks);
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
