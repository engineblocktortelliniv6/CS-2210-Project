import java.util.ArrayList;

/**
 * This class represents a supplier, extending the Person class.
 * @author Nicholas Snyder
 * Created on October 14, 2026
 */
public class Supplier extends Person {
    private String address;
    private ArrayList<Product> products;

    /**
     * Constructs a new Supplier with the specified name, person ID, phone number, address, and list of products.
     * @param name
     * @param personID
     * @param phoneNumber
     * @param address
     * @param products
     */
    public Supplier(String name, String personID, String phoneNumber, String address,ArrayList<Product> products) {
        super(name, personID, phoneNumber);
        this.address = address;
        this.products = products;
    }

    /**
     * Returns the address of the supplier.
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the supplier.
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Returns the list of products supplied by the supplier.
     * @return
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Adds a product to the list of products supplied by the supplier.
     * @param product
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Removes a product from the list of products supplied by the supplier.
     * @param product
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }
}