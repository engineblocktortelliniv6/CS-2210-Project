/**
 * This class represents a customer, extending the Person class.
 * @author Nicholas Snyder
 * Create on October 14, 2026
 */
public class Customer extends Person {
    private String deliveryAddress;

    /**
     * Constructs a new Customer object with the specified name, person ID, phone number, and delivery address.
     * @param name
     * @param personID
     * @param phoneNumber
     * @param deliveryAddress
     */
    public Customer(String name, String personID, String phoneNumber, String deliveryAddress) {
        super(name, personID, phoneNumber);
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Returns the delivery address of the customer.
     * @return
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Sets the delivery address of the customer.
     * @param deliveryAddress
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}