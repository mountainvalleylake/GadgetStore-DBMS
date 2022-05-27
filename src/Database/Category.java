package Database;

import java.sql.Connection;

/**
 * Created by graphics on 12/13/2016.
 */
public class Category {
    Connection connection = null;
    public Category(){}
    public void SetConnection(Connection connection){
        this.connection = connection;

    }
    public int CategoryInsertDB(){
        int x = 0;
        return x;
    }
}
