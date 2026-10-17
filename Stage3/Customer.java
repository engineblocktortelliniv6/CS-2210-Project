/**
 * This class represents a customer, extending the Person class.
 * @author Nicholas Snyder
 * Created on October 14, 2026
 */
public class Customer extends Person {
    private String address;

    /**
     * Constructs a new Customer object with the specified name, person ID, phone number, and address.
     * @param name
     * @param personID
     * @param phoneNumber
     * @param address
     */
    public Customer(String name, String personID, String phoneNumber, String address) {
        super(name, personID, phoneNumber);
        this.address = address;
    }

    /**
     * Returns the address of the customer.
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the customer.
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}