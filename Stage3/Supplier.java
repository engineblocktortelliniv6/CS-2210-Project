/**
 * This class represents a supplier, extending the Person class.
 * @author Nicholas Snyder
 * Created on October 14, 2026
 */
public class Supplier extends Person {
    private String address;
    private ProductCatalogue products;

    /**
     * Constructs a new Supplier with the specified name, person ID, phone number, address, and product catalogue.
     * @param name the name of the supplier
     * @param personID the unique identifier of the supplier
     * @param phoneNumber the contact number of the supplier
     * @param address the physical or mailing address
     * @param products the ProductCatalogue of items offered by this supplier
     */
    public Supplier(String name, int personID, String phoneNumber, String address, ProductCatalogue products) {
        super(name, personID, phoneNumber);
        this.address = address;
        this.products = new ProductCatalogue();
    }

    /**
     * Returns the address of the supplier.
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the supplier.
     * @param address new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the product catalogue of items supplied by the supplier.
     * @return products catalogue
     */
    public ProductCatalogue getProducts() {
        return products;
    }

    /**
     * Sets the product catalogue of the supplier.
     * @param products new product catalogue
     */
    public void setProducts(ProductCatalogue products) {
        this.products = new ProductCatalogue();
    }

    /**
     * Adds a product to the supplier's product catalogue.
     * @param product the product to add
     */
    public void addProduct(Product product) {
        products.addProduct(product);
    }

    /**
     * Returns a string representation of the supplier.
     * @return a string representation of the supplier
     */
    @Override 
    public String toString() {
        return "Supplier{" +
                "name: '" + getName() + '\'' +
                ", personID: '" + getPersonId() + '\'' +
                ", phoneNumber: '" + getPhoneNumber() + '\'' +
                ", address: '" + address + '\'' +
                ", products: " + products.getCatalogue() +
                '}';
    }
}