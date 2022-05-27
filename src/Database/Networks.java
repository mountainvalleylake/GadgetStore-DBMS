package Database;

import java.sql.*;

/**
 * Created by graphics on 12/13/2016.
 */
public class Networks {
    int product_id;
    String antena, range;
    float transferrate;
    int y=0;
    Connection connection = null;
    Statement statement = null;

    public Networks(int product_id, float transferrate, String antena, String range) {
        this.product_id = product_id;
        this.antena = antena;
        this.range = range;
        this.transferrate = transferrate;
    }

    public void SetConnection(Connection connection) {
        this.connection = connection;
    }

    public int NetInsertDB(Networks networks) {
        try {
                String query = "INSERT INTO NETWORKS VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,networks.product_id);
                preparedStatement.setFloat(2,networks.transferrate);
                preparedStatement.setString(3,networks.antena);
                preparedStatement.setString(4,networks.range);
                preparedStatement.executeUpdate();
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return y;
    }
}