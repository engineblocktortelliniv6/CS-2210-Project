import java.io.Serializable;

/**
 * Represents an order and manages its information
 * and products
 * @author Tamara Galstian
 * Created on October 21, 2026
 * 
 */
public class Order implements Serializable {
    private int orderID;
    private Product products;
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
     *                    to the order
     * @param date        the date of the order
     */
    public Order(int orderID, Product products, DeliveryStatus orderStatus,
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
    public Product getProducts() {
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

    // setter needed
    /**
     * Gets the status of the order and prints whether it is
     * pending or finished
     * 
     * @return true if the order is done, false otherwise
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
     * Sets the products included in the order
     * 
     * @param products the new products
     */
    public void setProducts(Product products) {
        this.products = products;
    }

    /**
     * Sets the person who placed the order
     * 
     * @param orderer the new orderer
     */
    public void setOrderer(Person orderer) {
        this.orderer = orderer;
    }

    /**
     * Sets the staff member assigned to the order
     * 
     * @param staff the staff member that created the order
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     * Sets the status of the order
     * @param orderStatus the new order status
     */
    public void setOrderStatus(DeliveryStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Sets the date of an order.
     * @param date the new date of this order.
     */
    public void setOrderDate(String date) {
        this.date = date;
    }

}
