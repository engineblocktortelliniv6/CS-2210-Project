/**
 * Represents an outbound order for delivering
 * products to a customer
 * 
 * @author Tamara Galstian
 * October 21, 2026
 */
public class OutboundOrder extends Order {
    private String address;
    private Customer orderer;

    /**
     * Creates an outbound order with the delivery address
     * and the orderer
     * 
     * @param address the delivery address
     * @param orderer the customer receiving the order
     */

    public OutboundOrder(String address, Customer orderer) {
        super(0, null, orderer, null, "");
        this.address = address;
        this.orderer = orderer;
    }

    /**
     * Gets the delivery address
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the customer receiving the order
     * 
     * @return the customer receiving the order
     */
    public Customer getOrderer() {
        return orderer;
    }

    /**
     * Sets delivery address
     * 
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the customer receiving the order
     * 
     * @param orderer the new customer
     */
    public void setOrderer(Customer orderer) {
        this.orderer = orderer;
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
}
