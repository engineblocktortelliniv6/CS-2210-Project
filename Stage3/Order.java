
public class Order {
    private int orderNumber;
    private Product products;
    private boolean orderStatus;
    private Person orderer;
    private Person staffName;
    private String date;
    public Order(int orderNumber, Product products, boolean orderStatus,
            Person orderer, Person staffName, String date) {
    this.orderNumber = orderNumber;
    this.products = products;
        // order is pending - false or order is done - true
    this.orderStatus = false;
    this.orderer = orderer; 
    this.staffName = staffName;
    this.date = date;
}
    public int getOrder() {
        return orderNumber;
    }
    public Product getProducts() {
        return products;
    }
    public Person getOrderer() {
        return orderer;
    }
    public String getOrderStatus; 
    public Person getStaffName() {
        return staffName;
    }
    public boolean getOrderStatus(){
        if (orderStatus == false) {
            System.out.println("Order is pending"); }
        else { System.out.println("Order is done");}
        return orderStatus;   
    }
    //see if it works later
    public String getOrderType() {
        return this.getClass().getSimpleName();  
    }
    public void setOrder(int orderNumber) {
       this.orderNumber = orderNumber; 
    }
    public void setProducts(Product products) {
        this.products = products;
    }
    public void setOrderer(Person orderer) {
        this.orderer = orderer;
    }
    public void setStaffName(Person staffName) {
        this.staffName = staffName;
    }
    
    public sendOrderedProductsFromProductLocation() {
        if (getOrderType().equals("OutboundOrder")) {
            warehouse.removeProduct(products);
        }
        
    public addDeliveryToProductLocation(Warehouse warehouse) {
        if (getOrderType().equals("InboundOrder")) {
            warehouse.addProduct(products);
    }
}
}


