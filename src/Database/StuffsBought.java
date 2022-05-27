package Database;

/**
 * Created by graphics on 12/19/2016.
 */
public class StuffsBought {
    String pname,brand,category;
    int quantity,model_no;
    float cost;
    float unitTotal;
    public StuffsBought(String pname, int quantity, float cost){
        this.pname = pname;
        this.quantity = quantity;
        this.cost = cost;
        unitTotal = quantity*cost;
    }

    public String getName() { return pname; }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() { return cost; }

    public float getUnitTotal() { return unitTotal; }
}
