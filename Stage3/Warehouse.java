import java.util.ArrayList;
/**
 * This class represents a warehouse that manages a collection of products. It allows for adding, removing, and searching for products by ID or name.
 * @author Nicholas Snyder
 * Created on October 21, 2026
 * Warehouse
 */
public class Warehouse {
    private ArrayList<Product> products;

    /**
     * Constructs a new Warehouse object, initializing the list of products.
     */
    public Warehouse() {
        this.products = new ArrayList<>();
    }

    /**
     * Adds a product to the warehouse.
     * @param product
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Removes a product from the warehouse.
     * @param product
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }

    /**
     * Returns the list of products in the warehouse.
     * @return
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Searches for a product by its ID.
     * @param id
     * @return product if found, otherwise null
     */
    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getProductID() == id) {
                return product;
            }
        }
        return null;
    }

    /**
     * Searches for a product by its name.
     * @param name
     * @return product if found, otherwise null
     */
    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}