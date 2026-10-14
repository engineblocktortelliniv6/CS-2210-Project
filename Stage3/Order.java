
public class Order {
    private int orderNumber;
    private Product products;
    private boolean orderStatus;
    private Person orderer;
    private Person staffName;
    private String date;
    public Order(int orderNumber, Product products, String orderStatus,
            Person orderer, Person staffName, String date) {
    this.orderNumber = orderNumber;
    this.products = products;
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
        return orderStatus;   
    }
    //finish this one
    public String getOrderType() {
        return  
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
    //finish 
    public void setOrderType(String orderType) {
        
    }
    //finish
    public sendOrderedProductsFromProductLocation() {
        
    }
    public addDeliveryToProductLocation() {
}
}


