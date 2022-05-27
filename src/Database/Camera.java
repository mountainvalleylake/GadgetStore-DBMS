package Database;

import java.sql.*;

/**
 * Created by graphics on 12/13/2016.
 */
public class Camera {
    int product_id,battery;
    String resolution,display_type;
    float shutterspeed;
    int y;
    Connection connection = null;
    Statement statement = null;
    public Camera(int product_id, String resolution, float shutterspeed, String display_type, int battery){
        this.product_id = product_id;
        this.battery = battery;
        this.resolution = resolution;
        this.display_type = display_type;
        this.shutterspeed = shutterspeed;
    }
    public void SetConnection(Connection connection) {
        this.connection = connection;

    }
    public int CameraInsertDB(Camera camera){
        try {
                String query = "INSERT INTO CAMERA VALUES (?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,camera.product_id);
                preparedStatement.setString(2,camera.resolution);
                preparedStatement.setFloat(3 ,camera.shutterspeed);
                preparedStatement.setString(4,camera.display_type);
                preparedStatement.setInt(5,camera.battery);
                preparedStatement.executeQuery();
                preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return y;
    }
}
