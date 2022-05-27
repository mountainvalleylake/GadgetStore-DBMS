package Database;

import java.sql.*;

/**
 * Created by graphics on 12/13/2016.
 */
//corresponds to a table in DB with non FK
public class Products {
    Connection connection = null;
    Statement statement = null;
    int id,model_no,quantity,warrenty;
    String name,brand,category;
    float price;
    int y;
    public Products(String name,int model_no,String brand,String category,float price,int warrenty,int quantity){
        this.name = name;
        this.model_no = model_no;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.warrenty = warrenty;
        this.quantity = quantity;

    }
    public void SetConnection(Connection connection){
        this.connection = connection;

    }
    public int ProductsInsertDB(Products product){

        try {
            String q = "SELECT \"PRODUCT_ID\" PID FROM PRODUCTS WHERE \"PRODUCT_NAME\" = ?  AND \"MODEL_NO\" = ?  AND \"PRODUCT_BRAND\" = ? AND \"PRODUCT_CATEGORY\" = ? AND \"QUANTITY\" > 0";
            PreparedStatement pstatement = connection.prepareStatement(q);
            pstatement.setString(1,product.name);
            pstatement.setInt(2,product.model_no);
            pstatement.setString(3,product.brand);
            pstatement.setString(4,product.category);
            ResultSet resultSet = pstatement.executeQuery();
            while (resultSet.next()){
                y = resultSet.getInt("PID");
            }
            pstatement.close();
            if(y == 0) {//new insert
                String find = "SELECT MAX(\"PRODUCT_ID\") maxid from PRODUCTS";
                statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(find);
                while(rs.next()){
                    y = rs.getInt("maxid");
                }
                product.id = y+1;
                String query = "INSERT INTO PRODUCTS VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, product.id);
                preparedStatement.setString(2, product.name);
                preparedStatement.setInt(3, product.model_no);
                preparedStatement.setString(4, product.brand);
                preparedStatement.setString(5, product.category);
                preparedStatement.setFloat(6, product.price);
                preparedStatement.setInt(7, product.warrenty);
                preparedStatement.setInt(8, product.quantity);
                preparedStatement.executeUpdate();

                preparedStatement.close();
            }
            else {
                //Update Price and Quantity
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product.id;
    }
}
