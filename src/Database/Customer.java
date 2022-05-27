package Database;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by graphics on 12/12/2016.
 */
//corresponds to a table in DB with non FK
public class Customer {
    String first_name, last_name, user_name , password, email, address,date_of_birth;
    int id;
    Date dob;
    Connection connection = null;


    public Customer(){

    }
    public void SetThings(String first_name, String last_name,String user_name, String email, String password, String address, String date_of_birth){
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.date_of_birth = date_of_birth;

    }
    public void SetConnection(Connection connection){
        this.connection = connection;

    }
    public int CustomerInsertDB() {
        int x = 0;
        try {
            String find = "SELECT MAX(\"CUSTOMER_ID\") maxid from CUSTOMER";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(find);
            while(rs.next()){
                id = rs.getInt("maxid");
            }
            System.out.println("This is the highest "+id);
            String query = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, user_name);
            preparedStatement.setString(5, password);
            id++;
            preparedStatement.setInt(6, id);
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
            java.util.Date date = null;
            date = sdf1.parse(date_of_birth);
            dob = new java.sql.Date(date.getTime());
            preparedStatement.setDate(7, dob);
            preparedStatement.setString(8, address);
            x = preparedStatement.executeUpdate();
            if(statement != null) statement.close();
            if(preparedStatement != null) preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return x;
    }
    public String getAddress(int id){
        String addr = "";
        String query = "SELECT ADDRESS ADDR FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                addr = rs.getString("ADDR");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addr;
    }
    public int LoginCustomer(String user_name,String email, String password){
        int valid = 0;
        String test_uname = user_name;
        String test_mail = email;
        String test_pass = password;
        String proc = "CALL USERCHECK(?,?,?,?)";
        try {
            CallableStatement callableStatement = connection.prepareCall(proc);
            callableStatement.setString(1,test_uname);
            callableStatement.setString(2,test_mail);
            callableStatement.setString(3,test_pass);
            callableStatement.registerOutParameter(4,Types.INTEGER);
            callableStatement.executeQuery();
            valid = callableStatement.getInt(4);
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }
}

