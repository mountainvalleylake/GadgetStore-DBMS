package Database;

/**
 * Created by graphics on 12/15/2016.
 */
public class ProCamera {
    //Attributes of Products
    int product_id;
    int model_no;
    int quantity;
    int warrenty;
    String name;
    String brand;
    String category;
    float price;

    int battery;
    String resolution;
    String display_type;
    float shutterspeed;

    public ProCamera(int product_id,String name,int model_no,String brand,String category,float price,int warrenty,int quantity, String resolution, float shutterspeed, String display_type, int battery){
        this.product_id = product_id;
        this.name = name;
        this.model_no = model_no;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.warrenty = warrenty;
        this.quantity = quantity;
        this.battery = battery;
        this.resolution = resolution;
        this.display_type = display_type;
        this.shutterspeed = shutterspeed;
    }

    public String getBrand() { return brand; }

    public int getModel() { return model_no; }

    public int getBattery() {
        return battery;
    }

    public String getResolution() {
        return resolution;
    }

    public String getDisplay_type() {
        return display_type;
    }

    public float getShutterspeed() {
        return shutterspeed;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() { return quantity; }

    public int getWarrenty() {
        return warrenty;
    }

    public String getCategory() {
        return category;
    }

    public int getProduct_id() {
        return product_id;
    }
}
