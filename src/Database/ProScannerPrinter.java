package Database;

/**
 * Created by graphics on 12/15/2016.
 */
public class ProScannerPrinter {
    //Attributes of Products
    int product_id,model_no,quantity,warrenty;
    String name,brand,category;
    float price;
    //Attributes of ScannerPrinter
    String interfaces,resolution,paper;
    float speed;


    public ProScannerPrinter(int product_id,String name,int model_no,String brand,String category,float price,int warrenty,int quantity,String interfaces, String resolution,float speed, String paper){
        this.product_id = product_id;
        this.name = name;
        this.model_no = model_no;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.warrenty = warrenty;
        this.quantity = quantity;
        this.interfaces = interfaces;
        this.resolution = resolution;
        this.paper = paper;
        this.speed = speed;

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

    public String getResolution() {
        return resolution;
    }

    public float getSpeed() {
        return speed;
    }

    public String getPaper() {
        return paper;
    }

    public String getInterfaces() {
        return interfaces;
    }

    public int getQuantity() { return quantity; }

    public int getWarrenty() {
        return warrenty;
    }

    public String getCategory() { return category; }

    public int getProduct_id() {
        return product_id;
    }
}
