package Database;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by graphics on 12/13/2016.
 */
//corresponds to a table in DB with non FK
public class Cart {//Cart serves the purpose of Cart,Cart_Item,Order & Purchase History Table alone.
    Connection connection = null;
    int order_id,serial_no;
    float total_cost;
    int customer_id;
    String user_name, email, payment_type;
    ArrayList product_id_list = new ArrayList<>();
    public List<StuffsBought> stuffList = new ArrayList<>();

    public Cart(){

    }
    public void SetConnection(Connection connection){ this.connection = connection; }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public int getOrder_id(){ return order_id;}
    public float getTotal_cost(){ return total_cost; }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPayment_type(String payment_type){ this.payment_type = payment_type;}
    public int AddCartOrdertoDB (Cart cart,String user_name, String email, String address, int customer_id){
        order_id = 0;
        serial_no = 0;
        String search = "SELECT MAX(ORDER_ID) MID FROM CART";
        try {
            PreparedStatement p = connection.prepareStatement(search);
            ResultSet rs = p.executeQuery();
            while (rs.next()){
                order_id = rs.getInt("MID");
            }
            cart.setOrder_id(order_id);
            p.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        order_id++;
        String query = "INSERT INTO CART VALUES(?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(query);
            p.setInt(1,order_id);
            p.setFloat(2,0);//Initially set the total cost to 0.
            p.setInt(3,customer_id);
            p.setString(4,user_name);
            p.setString(5,email);
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Now we will insert into Order Table
        String qu = "INSERT INTO ORDERS VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(qu);
            pstmt.setInt(1,order_id);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            Date localDate = Date.valueOf(LocalDate.now());
            pstmt.setDate(2,localDate);
            pstmt.setInt(3,customer_id);
            pstmt.setString(4,user_name);
            pstmt.setString(5,email);
            pstmt.setString(6,"Bkash");
            pstmt.setString(7,address);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //now we insert into Purchase History Table
        String que = "SELECT MAX(SERIAL_NO) MNO FROM PURCHASE_HISTORY";
        try {
            PreparedStatement prestmt = connection.prepareStatement(que);
            ResultSet rset = prestmt.executeQuery();
            while (rset.next()){
                serial_no = rset.getInt("MNO");
            }
            prestmt.close();
            rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String ins = "INSERT INTO PURCHASE_HISTORY VALUES (?,?,?,?)";
        serial_no++;
        try {
            PreparedStatement prepstmt = connection.prepareStatement(ins);
            prepstmt.setInt(1,serial_no);
            prepstmt.setInt(2,customer_id);
            prepstmt.setString(3,user_name);
            prepstmt.setString(4,email);
            prepstmt.executeUpdate();
            prepstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order_id;
    }
    public String getProductName(int product_id){
        String nameofp = "";
        String query = "SELECT PRODUCT_NAME PNAME FROM PRODUCTS WHERE PRODUCT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,product_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                nameofp = resultSet.getString("PNAME");
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nameofp;
    }
    public void addProduct_ID(int product_id,int order_id,int quantity){
        String brand = " ",category = " ";
        int model_no = 0;
        float price = 0;
        product_id_list.add(product_id);
        //Also Insert that into Cart_Item Table
        String gets = "SELECT PRODUCT_BRAND brand, PRODUCT_CATEGORY cat, MODEL_NO model,PRODUCT_PRICE price FROM PRODUCTS WHERE PRODUCT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(gets);
            preparedStatement.setInt(1,product_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                brand = resultSet.getString("brand");
                category = resultSet.getString("cat");
                model_no = resultSet.getInt("model");
                price = resultSet.getFloat("price");
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String insert = "INSERT INTO CART_ITEM VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(insert);
            p.setInt(1,product_id);
            p.setString(2,brand);
            p.setInt(3,model_no);
            p.setString(4,category);
            p.setInt(5,quantity);
            p.setFloat(6,price);
            p.setInt(7,order_id);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public float UpdateTotalCost(int order_id, int product_id){
        float cost = 0;
        String query = "SELECT PRODUCT_PRICE PPRICE FROM PRODUCTS WHERE PRODUCT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,product_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cost = resultSet.getFloat("PPRICE");
                total_cost += cost;
            }
            preparedStatement.close();
            resultSet.close();
            //Update that Total Cost in Database
            String update = "UPDATE CART SET TOTAL_COST = ? WHERE ORDER_ID = ? ";
            PreparedStatement p = connection.prepareStatement(update);
            p.setFloat(1,total_cost);
            p.setInt(2,order_id);
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cost;
    }
    public void UpdateQuantity(int product_id, int quantity){
        int quant = 0;
        String query = "SELECT QUANTITY QUAN FROM PRODUCTS WHERE PRODUCT_ID = ?";
        try {
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1,product_id);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()){
              quant = resultSet.getInt("QUAN");
            }
            pStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        quant -= quantity;
        String update = "UPDATE PRODUCTS SET QUANTITY = ? WHERE PRODUCT_ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setInt(1,quant);
            preparedStatement.setInt(2,product_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
