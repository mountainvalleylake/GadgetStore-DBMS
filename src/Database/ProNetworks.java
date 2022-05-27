package Database;

/**
 * Created by graphics on 12/15/2016.
 */
public class ProNetworks {
    //Attributes of Products
    int product_id,model_no,quantity,warranty;
    String name,brand,category;
    float price;
    //Attributes of Networks
    String antena, range;
    float transferrate;


    public ProNetworks(int product_id,String name,int model_no,String brand,String category,float price,int warranty,int quantity ,float transferrate, String antena, String range){
        this.product_id = product_id;
        this.name = name;
        this.model_no = model_no;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.warranty = warranty;
        this.quantity = quantity;
        this.antena = antena;
        this.range = range;
        this.transferrate = transferrate;
    }

    public String getBrand() {
        return brand;
    }

    public int getModel() {
        return model_no;
    }

    public float getPrice() {
        return price;
    }

    public float getTransferrate() {
        return transferrate;
    }

    public String getAntena() {
        return antena;
    }

    public String getRange() {
        return range;
    }

    public int getQuantity() { return quantity; }

    public int getProduct_id() {
        return product_id;
    }

    public String getCategory() {
        return category;
    }

    public int getWarrenty() {
        return warranty;
    }
}
