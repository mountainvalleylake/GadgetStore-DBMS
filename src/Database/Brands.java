package Database;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by graphics on 12/13/2016.
 */
//corresponds to a table in DB with non FK
public class Brands {
    Connection connection = null;
    int id;
    String brandname;
    public Brands(ResultSet resultSet){
    }
    public int BrandsInsertDB(){
        int x = 0;
        return x;
    }
    public void SetConnection(Connection connection){
        this.connection = connection;

    }
}
