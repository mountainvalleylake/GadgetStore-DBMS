package Database;

import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.sql.Date;
import java.util.*;

//want to get anything? Its right here.
public class DBManager {
    Connection connection;
    Customer customer;
    Category category;
    Brands brands;
    Cart cart;
    Products products;
    public DBManager() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Connection found found");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "GADGET_STORE", "1234");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);

        }
    }
    public Connection getConnection(){
        return connection;
    }
    public int getCustomerID(String user_name, String email){
        int id_found = 0;
        String search_id = "SELECT \"CUSTOMER_ID\" cid FROM CUSTOMER WHERE EMAIL = ? AND USER_NAME = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(search_id);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,user_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id_found = resultSet.getInt("cid");
                System.out.println(id_found);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_found;
    }
    public int getProductID(Products products){
        int id_found = 0;
        String search_id = "SELECT \"PRODUCT_ID\" pid FROM PRODUCTS WHERE PRODUCT_NAME = ? AND MODEL_NO = ? AND PRODUCT_BRAND = ? AND PRODUCT_CATEGORY = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(search_id);
            preparedStatement.setString(1,products.name);
            preparedStatement.setInt(2,products.model_no);
            preparedStatement.setString(3,products.brand);
            preparedStatement.setString(4,products.category);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id_found = resultSet.getInt("pid");
                System.out.println(id_found);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_found;
    }
    public List<ProScannerPrinter> getProScanPrint(){
        List<ProScannerPrinter> psp = new ArrayList<>();
        String query = "SELECT PRODUCTS.PRODUCT_ID pid,PRODUCT_NAME pname,MODEL_NO mno,PRODUCT_BRAND brand,PRODUCT_CATEGORY cat,PRODUCT_PRICE price," +
                "warrenty war,QUANTITY quant,INTERFACES intef,RESOLUTION resol,SPEED speed,PAPER pap " +
                "FROM PRODUCTS,SCANNER_PRINTER WHERE PRODUCTS.PRODUCT_ID = SCANNER_PRINTER.PRODUCT_ID AND PRODUCTS.QUANTITY > 0";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                //Product
                int product_id = resultSet.getInt("pid");
                String product_name = resultSet.getString("pname");
                int model_no = resultSet.getInt("mno");
                String brand = resultSet.getString("brand");
                String category = resultSet.getString("cat");
                float price = resultSet.getFloat("price");
                int warrenty = resultSet.getInt("war");
                int quantity = resultSet.getInt("quant");
                //ScannerPrinter
                String interf = resultSet.getString("intef");
                String resolution = resultSet.getString("resol");
                float speed = resultSet.getFloat("speed");
                String paper = resultSet.getString("pap");
                ProScannerPrinter proScannerPrinter = new ProScannerPrinter(product_id,product_name,model_no,brand,category,price,warrenty,quantity,interf,resolution,speed,paper);
                psp.add(proScannerPrinter);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return psp;
    }
    public List<ProCamera> getProCam (){
        List<ProCamera> pcam = new ArrayList<>();
        String query = "SELECT PRODUCTS.PRODUCT_ID pid,PRODUCT_NAME pname,MODEL_NO mno,PRODUCT_BRAND brand,PRODUCT_CATEGORY cat,PRODUCT_PRICE price," +
                " WARRENTY war,QUANTITY quant,RESOLUTION resol,SHUTTER_SPEED ss,DISPLAY_TYPE dtype,BATTERY bat " +
                "FROM PRODUCTS,CAMERA WHERE PRODUCTS.PRODUCT_ID = CAMERA.PRODUCT_ID AND PRODUCTS.QUANTITY > 0";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Product
                int product_id = resultSet.getInt("pid");
                String product_name = resultSet.getString("pname");
                int model_no = resultSet.getInt("mno");
                String brand = resultSet.getString("brand");
                String category = resultSet.getString("cat");
                float price = resultSet.getFloat("price");
                int warrenty = resultSet.getInt("war");
                int quantity = resultSet.getInt("quant");
                //Camera
                String resolution = resultSet.getString("resol");
                float shutter_speed = resultSet.getFloat("ss");
                String display_type = resultSet.getString("dtype");
                int battery = resultSet.getInt("bat");
                ProCamera proCamera = new ProCamera(product_id,product_name,model_no,brand,category,price,warrenty,quantity,resolution,shutter_speed,display_type,battery);
                pcam.add(proCamera);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pcam;
    }
    public List<ProNetworks> getProNet (){
        List<ProNetworks> pnet = new ArrayList<>();
        String query = "SELECT PRODUCTS.PRODUCT_ID pid,PRODUCT_NAME pname,MODEL_NO mno,PRODUCT_BRAND brand,PRODUCT_CATEGORY cat,PRODUCT_PRICE price," +
                "WARRENTY war,QUANTITY quant,TRANSFER_RATE trate,ANTENA ant,RANGES ranges " +
                "FROM PRODUCTS,NETWORKS WHERE PRODUCTS.PRODUCT_ID = NETWORKS.PRODUCT_ID AND PRODUCTS.QUANTITY > 0";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Product
                int product_id = resultSet.getInt("pid");
                String product_name = resultSet.getString("pname");
                int model_no = resultSet.getInt("mno");
                String brand = resultSet.getString("brand");
                String category = resultSet.getString("cat");
                float price = resultSet.getFloat("price");
                int warrenty = resultSet.getInt("war");
                int quantity = resultSet.getInt("quant");
                //Network
                float trate = resultSet.getFloat("trate");
                String antena = resultSet.getString("ant");
                String range = resultSet.getString("ranges");
                ProNetworks proNetworks = new ProNetworks(product_id,product_name,model_no,brand,category,price,warrenty,quantity,trate,antena,range);
                pnet.add(proNetworks);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pnet;
    }
    public List<ProPC> getProPC (){
        List<ProPC> ppc = new ArrayList<>();
        String query = "SELECT PRODUCTS.PRODUCT_ID pid,PRODUCT_NAME pname,MODEL_NO mno,PRODUCT_BRAND brand,PRODUCT_CATEGORY cat,PRODUCT_PRICE price," +
                "warrenty war,QUANTITY quant,RAM ram,HDD hdd,CORE core,GRAPHICS graphics " +
                "FROM PRODUCTS,PC WHERE PRODUCTS.PRODUCT_ID = PC.PRODUCT_ID AND PRODUCTS.QUANTITY > 0";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Product
                int product_id = resultSet.getInt("pid");
                String product_name = resultSet.getString("pname");
                int model_no = resultSet.getInt("mno");
                String brand = resultSet.getString("brand");
                String category = resultSet.getString("cat");
                float price = resultSet.getFloat("price");
                int warrenty = resultSet.getInt("war");
                int quantity = resultSet.getInt("quant");
                //PC
                float ram = resultSet.getFloat("ram");
                int hdd = resultSet.getInt("hdd");
                String core = resultSet.getString("core");
                String graphics = resultSet.getString("graphics");
                ProPC proPC = new ProPC(product_id,product_name,model_no,brand,category,price,warrenty,quantity,hdd,core,graphics,ram);
                ppc.add(proPC);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ppc;
    }
    public List<PurchaseHistory> getHistory(){
        String product_names = "";
        List<PurchaseHistory> phistory = new ArrayList<>();
        String query = "SELECT PURCHASE_HISTORY.SERIAL_NO SLNO, ORDERS.ORDER_ID OID , ORDERS.CUSTOMER_ID CID, ORDERS.USER_NAME UNAME, ORDERS.EMAIL MAIL, ORDERS.PAYMENT_TYPE PTYPE , ORDERS.SHIPPING_ADDRESS ADDR, ORDERS.\"DATE\" DATES," +
                " CART_ITEM.PRODUCT_ID PID , CART_ITEM.BRAND BRANDS, CART_ITEM.\"MODEL\" MOD, CART_ITEM.\"CATEGORY\" CAT, CART_ITEM.QUANTITY QUANT, CART_ITEM.\"COST\" COSTS, CART.TOTAL_COST TCOST FROM PURCHASE_HISTORY,ORDERS,CART,CART_ITEM" +
                " WHERE PURCHASE_HISTORY.CUSTOMER_ID = ORDERS.CUSTOMER_ID AND ORDERS.ORDER_ID = CART.ORDER_ID AND ORDERS.ORDER_ID = CART_ITEM.ORDER_ID";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int serial_no = resultSet.getInt("SLNO");
                int order_id = resultSet.getInt("OID");
                int customer_id = resultSet.getInt("CID");
                String user_name = resultSet.getString("UNAME");
                String emails = resultSet.getString("MAIL");
                String payment_type = resultSet.getString("PTYPE");
                String addr = resultSet.getString("ADDR");
                Date d = resultSet.getDate("DATES");
                int prod_id = resultSet.getInt("PID");
                String brand = resultSet.getString("BRANDS");
                int models = resultSet.getInt("MOD");
                String category = resultSet.getString("CAT");
                int quantity = resultSet.getInt("QUANT");
                float cost = resultSet.getFloat("COSTS");
                float tcost = resultSet.getFloat("TCOST");

                String q = "SELECT PRODUCT_NAME PNAME FROM PRODUCTS WHERE PRODUCT_ID = ? ";
                PreparedStatement p = connection.prepareStatement(q);
                p.setInt(1,prod_id);
                ResultSet r = p.executeQuery();
                while(r.next()){
                    product_names = r.getString("PNAME");
                }
                p.close();
                r.close();
                PurchaseHistory ph = new PurchaseHistory(serial_no,order_id,customer_id,user_name,emails,payment_type,addr,d,tcost,prod_id,
                        models,quantity,cost,product_names,brand,category);
                phistory.add(ph);
            }
            preparedStatement.close();
            resultSet.close();
            //insertHistory(phistory);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phistory;
    }

    public void insertHistory(List <PurchaseHistory> purchaseHistoryList){
        for (PurchaseHistory aPurchaseHistoryList : purchaseHistoryList) {
            int valid = 0;
            String proc = "CALL INSERTHISTORY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                CallableStatement callableStatement = connection.prepareCall(proc);
                callableStatement.setInt(1, aPurchaseHistoryList.getSlno());
                callableStatement.setInt(2, aPurchaseHistoryList.order_id);
                callableStatement.setInt(3, aPurchaseHistoryList.customer_id);
                callableStatement.setString(4, aPurchaseHistoryList.user_name);
                callableStatement.setString(5, aPurchaseHistoryList.email);
                callableStatement.setString(6, aPurchaseHistoryList.payment_type);
                callableStatement.setString(7, aPurchaseHistoryList.address);
                callableStatement.setDate(8, aPurchaseHistoryList.date);
                callableStatement.setInt(9, aPurchaseHistoryList.productid);
                callableStatement.setString(10, aPurchaseHistoryList.product_name);
                callableStatement.setString(11, aPurchaseHistoryList.brand);
                callableStatement.setInt(12, aPurchaseHistoryList.model);
                callableStatement.setString(13, aPurchaseHistoryList.categorys);
                callableStatement.setInt(14, aPurchaseHistoryList.quantity);
                callableStatement.setFloat(15, aPurchaseHistoryList.cost);
                callableStatement.setFloat(16, aPurchaseHistoryList.total_cost);
                callableStatement.registerOutParameter(17, Types.INTEGER);
                callableStatement.executeQuery();
                valid = callableStatement.getInt(17);
                callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<PurchaseHistory> getbetHistory(Date d1, Date d2){
        List<PurchaseHistory> phistory = new ArrayList<>();

        String query = "SELECT SERIAL_NO SLNO, ORDER_ID OID , CUSTOMER_ID CID, USER_NAME UNAME, EMAIL MAIL, PAYMENT_TYPE PTYPE , ADDRESS ADDR, ORDERS.\"DATE\" DATES, " +
                "PRODUCT_ID PID , PRODUCT_NAME PNAME, BRAND BRANDS, \"MODEL\" MOD, \"CATEGORY\" CAT, QUANTITY QUANT, \"COST\" COSTS, TOTAL_COST TCOST FROM DETAILED_HISTORY WHERE \"DATE\" BETWEEN TO_DATE(? AND ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1,d1);
            preparedStatement.setDate(2,d2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int serial_no = resultSet.getInt("SLNO");
                int order_id = resultSet.getInt("OID");
                int customer_id = resultSet.getInt("CID");
                String user_name = resultSet.getString("UNAME");
                String emails = resultSet.getString("MAIL");
                String payment_type = resultSet.getString("PTYPE");
                String addr = resultSet.getString("ADDR");
                Date d = resultSet.getDate("DATES");
                int prod_id = resultSet.getInt("PID");
                String product_name = resultSet.getString("PNAME");
                String brand = resultSet.getString("BRANDS");
                int models = resultSet.getInt("MOD");
                String category = resultSet.getString("CAT");
                int quantity = resultSet.getInt("QUANT");
                float cost = resultSet.getFloat("COSTS");
                float tcost = resultSet.getFloat("TCOST");

                PurchaseHistory ph = new PurchaseHistory(serial_no,order_id,customer_id,user_name,emails,payment_type,addr,d,tcost,prod_id,
                        models,quantity,cost,product_name,brand,category);
                phistory.add(ph);
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phistory;
    }
    public List<UserHistory> getUserHistory(int user_id){
        String product_names = "";
        List<UserHistory> uhist = new ArrayList<>();
        String query = "SELECT ORDERS.ORDER_ID OID , ORDERS.CUSTOMER_ID CID , ORDERS.USER_NAME UNAME , ORDERS.EMAIL MAIL, ORDERS.PAYMENT_TYPE PTYPE , ORDERS.SHIPPING_ADDRESS ADDR, ORDERS.\"DATE\" DATES , " +
                " CART_ITEM.PRODUCT_ID PID , CART_ITEM.BRAND BRANDS , CART_ITEM.\"MODEL\" MOD , CART_ITEM.\"CATEGORY\" CAT , CART_ITEM.QUANTITY QUANT , CART_ITEM.\"COST\" COSTS , CART.TOTAL_COST TCOST " +
                " FROM ORDERS , CART_ITEM , CART " +
                " WHERE ORDERS.ORDER_ID = CART.ORDER_ID AND ORDERS.ORDER_ID = CART_ITEM.ORDER_ID AND ORDERS.CUSTOMER_ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int order_id = resultSet.getInt("OID");
                int customer_id = resultSet.getInt("CID");
                String user_name = resultSet.getString("UNAME");
                String emails = resultSet.getString("MAIL");
                String payment_type = resultSet.getString("PTYPE");
                String addr = resultSet.getString("ADDR");
                Date d = resultSet.getDate("DATES");
                int prod_id = resultSet.getInt("PID");
                String brand = resultSet.getString("BRANDS");
                int models = resultSet.getInt("MOD");
                String category = resultSet.getString("CAT");
                int quantity = resultSet.getInt("QUANT");
                float cost = resultSet.getFloat("COSTS");
                float tcost = resultSet.getFloat("TCOST");


                String q = "SELECT PRODUCT_NAME PNAME FROM PRODUCTS WHERE PRODUCT_ID = ? ";
                PreparedStatement p = connection.prepareStatement(q);
                p.setInt(1,prod_id);
                ResultSet r = p.executeQuery();
                while(r.next()){
                    product_names = r.getString("PNAME");
                }
                p.close();
                r.close();
                UserHistory userHistory = new UserHistory(order_id,customer_id,user_name,emails,payment_type,addr,d,tcost,prod_id,
                        models,quantity,cost,product_names,brand,category);
                uhist.add(userHistory);

            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uhist;
    }
//    public List<Products> getProducts(String product_name){
//        List<Products> productsList = new ArrayList<>();
//        String query = "SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = ?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1,product_name);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int product_id = resultSet.getInt(1);
//                String pname = resultSet.getString(2);
//                int model_no = resultSet.getInt(3);
//                String brand = resultSet.getString(4);
//                String category = resultSet.getString(5);
//                float price = resultSet.getFloat(6);
//                int warrenty = resultSet.getInt(7);
//                int quantity = resultSet.getInt(8);
//                Products products = new Products(pname,model_no,brand,category,price,warrenty,quantity);
//                System.out.println("Got the product");
//                productsList.add(products);
//            }
//            preparedStatement.close();
//            resultSet.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return productsList;
//    }
//    public List<Camera> getCameraData(){
//        List<Camera> cameraList = new ArrayList<>();
//        String query = "SELECT * FROM CAMERA";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int product_id = resultSet.getInt(1);
//                String resolution = resultSet.getString(2);
//                String display_type = resultSet.getString(3);
//                float shutterspeed = resultSet.getFloat(4);
//                int battery = resultSet.getInt(5);
//                Camera camera = new Camera(product_id,resolution,shutterspeed, display_type,battery);
//                System.out.println("All is set");
//                cameraList.add(camera);
//            }
//            preparedStatement.close();
//            resultSet.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return cameraList;
//    }
//    public List<PC> getPCData(){
//        List<PC> pcList = new ArrayList<>();
//        String query = "SELECT * FROM PC";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int product_id = resultSet.getInt(1);
//                float ram = resultSet.getFloat(2);
//                int hdd = resultSet.getInt(3);
//                String core = resultSet.getString(4);
//                String graphics = resultSet.getString(5);
//                PC pc = new PC(product_id,hdd,core,graphics,ram);
//                System.out.println("All is set");
//                pcList.add(pc);
//            }
//            preparedStatement.close();
//            resultSet.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return pcList;
//    }
//    public List<ScannerPrinter> getScannerPrinterData(){
//        List<ScannerPrinter> spList = new ArrayList<>();
//        String query = "SELECT * FROM SCANNER_PRINTER";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int product_id = resultSet.getInt(1);
//                String interfaces = resultSet.getString(2);
//                String resolutions = resultSet.getString(3);
//                float speed = resultSet.getFloat(4);
//                String paper = resultSet.getString(5);
//                ScannerPrinter sp = new ScannerPrinter(product_id,interfaces,resolutions,speed,paper);
//                System.out.println("All is set");
//                spList.add(sp);
//            }
//            preparedStatement.close();
//            resultSet.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return spList;
//    }
//    public List<Networks> getNetworksData(){
//        List<Networks> netList = new ArrayList<>();
//        String query = "SELECT * FROM NETWORK";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int product_id = resultSet.getInt(1);
//                float trate = resultSet.getFloat(2);
//                String antena = resultSet.getString(3);
//                String range = resultSet.getString(4);
//                Networks net = new Networks(product_id,trate, antena,range);
//                System.out.println("All is set");
//                netList.add(net);
//            }
//            preparedStatement.close();
//            resultSet.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return netList;
//    }
    public int UpdatePricedata(Products p){
        int update = 0;
        int x= getProductID(p);
        String update_query = "UPDATE PRODUCTS SET PRODUCT_PRICE = ? WHERE  PRODUCT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update_query);
            preparedStatement.setFloat(1,p.price);
            preparedStatement.setInt(2,x);
            update = preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return update;
    }
    public int UpdateQuantitydata(Products p){
        int update = 0;
        int x= getProductID(p);
        String update_query = "UPDATE PRODUCTS SET QUANTITY = ? WHERE  PRODUCT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update_query);

            preparedStatement.setInt(1,p.quantity);
            preparedStatement.setInt(2,x);
            update = preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return update;
    }

    public int UpdatePassword(Customer c){
        int update = 0;
        int c_id = getCustomerID(c.user_name,c.email);
        String update_query = "UPDATE CUSTOMER SET PASSWORD = ? WHERE CUSTOMER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update_query);
            preparedStatement.setString(1,c.password);
            preparedStatement.setInt(2,c.id);
            update = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
    public int UpdateAddress(Customer c){
        int update = 0;
        int c_id = getCustomerID(c.user_name,c.email);
        String update_query = "UPDATE CUSTOMER SET ADDRESS = ? WHERE CUSTOMER_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update_query);
            preparedStatement.setString(1,c.address);
            preparedStatement.setInt(2,c.id);
            update = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
