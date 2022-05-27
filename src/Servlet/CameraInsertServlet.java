package Servlet;

import Database.Camera;
import Database.DBManager;
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
//@WebServlet(name = "CameraInsertServlet",urlPatterns = "/CameraInsert")
public class CameraInsertServlet extends HttpServlet {
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
        //Create a Product Object and then Insert
        DBManager dbm = new DBManager();
        Connection conn = dbm.getConnection();
        Products products = new Products(product_name,model_no,brand_name,category,price,warranty,quantity);
        products.SetConnection(conn);
        int id = products.ProductsInsertDB(products);
        //get Camera Attributes
        String resolution = request.getParameter("res");
        float shutter_speed =  Float.parseFloat(request.getParameter("sspeed"));
        String display_type = request.getParameter("dtype");
        int battery = Integer.parseInt(request.getParameter("bat"));
        Camera camera = new Camera(id,resolution,shutter_speed,display_type,battery);
        camera.SetConnection(conn);
        int validate = camera.CameraInsertDB(camera);
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
