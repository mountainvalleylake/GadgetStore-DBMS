package Database;

import java.sql.Connection;
import java.sql.Date;

/**
 * Created by graphics on 12/19/2016.
 */
public class PurchaseHistory {
    Connection connection;
    //Purchase_History Table
    int purchase_serial;
    //Order Table & Cart Table
    int order_id,customer_id;//Order_ID and Date can be multiple under same Customer_ID
    String user_name,email,payment_type,address;
    Date date;
    float total_cost; //by joining Order Table and Cart Table
    //Cart_ID Table
    int productid,model,quantity;//Whole Thing can be multiple under same Order_ID
    float cost;
    String product_name,brand,categorys;
    //We will join all 4 tables. And give the whole package to both Admin and Customer.
    // JSP Has to be updated to according to show demand.
    public PurchaseHistory(int purchase_serial,int order_id, int customer_id, String user_name, String email, String payment_type, String address,
                           Date date, float total_cost, int productid, int model, int quantity, float cost, String product_name,String brand, String categorys){
        this.purchase_serial = purchase_serial;
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.user_name = user_name;
        this.email = email;
        this.payment_type = payment_type;
        this.address = address;
        this.date = date;
        this.total_cost = total_cost;
        this.productid = productid;
        this.model = model;
        this.quantity = quantity;
        this.cost = cost;
        this.product_name = product_name;
        this.brand = brand;
        this.categorys = categorys;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getSlno() {
        return purchase_serial;
    }

    public int getCid() {
        return customer_id;
    }

    public String getUname() {
        return user_name;
    }

    public String getMail() {
        return email;
    }

    public String getPtype() {
        return payment_type;
    }

    public String getSaddr() {
        return address;
    }

    public Date getDates() {
        return date;
    }

    public int getPid() {
        return productid;
    }

    public String getBrand() {
        return brand;
    }

    public int getModel() {
        return model;
    }

    public String getCat() {
        return categorys;
    }

    public int getQuant() {
        return quantity;
    }

    public float getUpr() {
        return cost;
    }

    public float getFpr() {
        return total_cost;
    }

    public String getName() { return product_name; }
}
