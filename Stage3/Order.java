/** 
 * Represents an order and manages its information
 * and products
 * @author Tamara Galstian
 * Created on October 21, 2026
 * 
 */
public class Order {
    private int orderNumber;
    private Product products;
    private boolean orderStatus;
    private Person orderer;
    private Person staffName;
    private String date;

    /**
     * Creates an order with its number, products, status,
     * orderer, staff member's name associated with it, and date
     * 
     * @param orderNumber the order number
     * @param products    the products included in the order
     * @param orderStatus the status of the order
     * @param orderer     the person who placed an order
     * @param staffName   the name of a staff member assigned
     *                    to the order
     * @param date        the date of the order
     */

    public Order(int orderNumber, Product products, boolean orderStatus,
            Person orderer, Person staffName, String date) {
        this.orderNumber = orderNumber;
        this.products = products;
        this.orderStatus = false;
        this.orderer = orderer;
        this.staffName = staffName;
        this.date = date;
    }

    /**
     * Gets order number
     * 
     * @return order number
     */
    public int getOrderNumber() {
        return orderNumber;
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
     * @return the staff member's name
     */
    public Person getStaffName() {
        return staffName;
    }

    // setter needed
    /**
     * Gets the status of the order and prints whether it is
     * pending or finished
     * 
     * @return true if the order is done, false otherwise
     */
    public boolean getOrderStatus() {
        if (orderStatus == false) {
            System.out.println("Order is pending");
        } else {
            System.out.println("Order is done");
        }
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

    /**
     * Sets the order number
     * 
     * @param orderNumber the new order number
     */
    public void setOrder(int orderNumber) {
        this.orderNumber = orderNumber;
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
     * @param staffName the new staff member's name
     * associated with the order
     */
    public void setStaffName(Person staffName) {
        this.staffName = staffName;
    }

    /**
     * Sets the status of the order
     * @param orderStatus the new order status
     */
    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Removes the products from the warehouse if
     * the order is an outbound order
     * 
     * @param warehouse the warehouse from which the
     * products are removed
     */
    public void removeProductsFromWarehouse(Warehouse warehouse) {
        if (getOrderType().equals("OutboundOrder")) {
            warehouse.removeProduct(products);
        }
    }

    /**
     * Adds the products to the warehouse if the
     * order is an inbound order
     * 
     * @param warehouse the warehouse to which the
     * products are added
     */
    public void addProductsToWarehouse(Warehouse warehouse) {
        if (getOrderType().equals("InboundOrder")) {
            warehouse.addProduct(products);
        }
    }
}
