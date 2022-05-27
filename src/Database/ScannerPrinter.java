package Database;

import java.sql.*;

/**
 * Created by graphics on 12/13/2016.
 */
public class ScannerPrinter {
    int product_id;
    int y;
    String interfaces,resolution,paper;
    float speed;
    Connection connection = null;
    Statement statement = null;
    public ScannerPrinter(int product_id,String interfaces, String resolution,float speed, String paper){
        this.product_id = product_id;
        this.interfaces = interfaces;
        this.resolution = resolution;
        this.paper = paper;
        this.speed = speed;
    }
    public void SetConnection(Connection connection) {
        this.connection = connection;

    }
    public int SPInsertDB(ScannerPrinter sp){
        try {
            System.out.println("inside");
                String query = "INSERT INTO SCANNER_PRINTER VALUES (?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,sp.product_id);
            System.out.println("1");
                preparedStatement.setString(2,sp.interfaces);
            System.out.println("2");
                preparedStatement.setString(3,sp.resolution);
            System.out.println("3");
                preparedStatement.setFloat(4,sp.speed);
            System.out.println("4");
                preparedStatement.setString(5 ,sp.paper);
            System.out.println("5");
                preparedStatement.executeUpdate();
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return y;
    }
}
