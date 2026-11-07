import java.io.Serializable;

/**
 * Represents an order and manages its information
 * and products
 * 
 * @author Tamara Galstian
 * Created on October 21, 2026
 */
public class Order implements Serializable {
    private int orderID;
    private ProductCatalogue products;
    private DeliveryStatus orderStatus;
    private Person orderer;
    private Staff staff;
    private String date;

    /**
     * Creates an order with its ID, products, status,
     * orderer, staff member's name associated with it, and date
     * 
     * @param orderID     the order ID
     * @param products    the products included in the order
     * @param orderStatus the status of the order
     * @param orderer     the person who placed an order
     * @param staff       the staff member that created the order
     * @param date        the date of the order
     */
    public Order(int orderID, ProductCatalogue products,
            Person orderer, Staff staff, String date) {
        this.orderID = orderID;
        this.products = products;
        this.orderStatus = DeliveryStatus.NULL;
        this.orderer = orderer;
        this.staff = staff;
        this.date = date;
    }

    /**
     * Gets order ID
     * 
     * @return order ID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Gets the products included in the order
     * 
     * @return the products in the order
     */
    public ProductCatalogue getProducts() {
        return products;
    }

    /**
     * Gets the person who placed the order
     * 
     * @return the orderer
     */
    public Person getOrderer() {
        return orderer;
    }

    /**
     * Gets the staff member assigned to the order
     * 
     * @return the staff member that created the order
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     * Gets the status of the order
     * 
     * @return the delivery status of the order
     */
    public DeliveryStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Gets the type of the order
     * 
     * @return the type of the order, such as Inbound
     * or Outbound
     */
    public String getOrderType() {
        return this.getClass().getSimpleName();
    }

    public String getOrderDate() {
        return date;
    }

    /**
     * Sets the order ID
     * 
     * @param orderID the new order ID
     */
    public void setOrder(int orderID) {
        this.orderID = orderID;
    }

    /**
     * Sets the status of the order
     * 
     * @param orderStatus the new order status
     */
    public void setOrderStatus(DeliveryStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Sets the staff member assigned to the order
     * 
     * @param staff the staff member
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     * Sets the date of the order
     * 
     * @param date the date string
     */
    public void setOrderDate(String date) {
        this.date = date;
    }

    /**
     * Sets the products catalogue for the order
     * 
     * @param products the catalogue of products
     */
    public void setProducts(ProductCatalogue products) {
        this.products = products;
    }

    /**
     * Overloaded method to allow setting a single product,
     * wrapping it into a ProductCatalogue automatically.
     * 
     * @param product the single product to add to the order
     */
    public void setProducts(Product product) {
        this.products = new ProductCatalogue();
        if (product != null) {
            this.products.addProduct(product);
        }
    }

    /**
     * Sets the person who placed the order
     * 
     * @param orderer the person placing the order
     */
    public void setOrderer(Person orderer) {
        this.orderer = orderer;
    }
}