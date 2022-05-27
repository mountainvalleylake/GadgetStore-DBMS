package Database;

/**
 * Created by graphics on 12/15/2016.
 */
public class ProPC {
    //Attributes of Products
    int product_id,model_no,quantity,warrenty;
    String name,brand,category;
    float price;
    //Attributes of PC
    int hdd;
    String core,graphics;
    float ram;


    public ProPC(int product_id,String name,int model_no,String brand,String category,float price,int warrenty,int quantity,int hdd, String core,String graphics,float ram){
        this.product_id = product_id;
        this.name = name;
        this.model_no = model_no;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.warrenty = warrenty;
        this.quantity = quantity;
        this.hdd = hdd;
        this.core = core;
        this.graphics = graphics;
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public int getModel() {
        return model_no;
    }

    public float getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getCore() {
        return core;
    }

    public float getPrice() { return price; }

    public String getGraphics() {
        return graphics;
    }

    public int getQuantity() { return quantity; }

    public int getWarrenty() {
        return warrenty;
    }

    public String getCategory() {
        return category;
    }

    public int getProduct_id() { return product_id; }
}

