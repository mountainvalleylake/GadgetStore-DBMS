package Database;

import java.sql.*;

/**
 * Created by graphics on 12/13/2016.
 */
public class PC {
    int product_id,hdd;
    int y=0;
    String core,graphics;
    float ram;
    Connection connection = null;
    Statement statement = null;
    public PC(int product_id,int hdd, String core,String graphics,float ram){
        this.product_id = product_id;
        this.hdd = hdd;
        this.core = core;
        this.graphics = graphics;
        this.ram = ram;
    }
    public void SetConnection(Connection connection){
        this.connection = connection;
    }
    public int PCInsertDB(PC pc){


        try {
                System.out.println("before");
                String query = "INSERT INTO PC VALUES(?,?,?,?,?)";
                System.out.println("inside "+y);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,pc.product_id);
                System.out.println(pc.product_id);
                preparedStatement.setFloat(2,pc.ram);
                System.out.println(pc.ram);
                preparedStatement.setInt(3,pc.hdd);
                System.out.println(pc.hdd);
                preparedStatement.setString(4,pc.core);
                System.out.println(pc.core);
                preparedStatement.setString(5,pc.graphics);
                System.out.println(pc.graphics);
                preparedStatement.executeUpdate();
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return y;
    }
}
