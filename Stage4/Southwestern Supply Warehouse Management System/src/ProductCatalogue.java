import java.io.Serializable;
import java.util.ArrayList;

/**
 * Manages a collection/catalogue of Product objects.
 * Provides lookup, addition, removal, and listing capabilities.
 * 
 * @author Nicholas Snyder
 * Created on November 2, 2026
 */
public class ProductCatalogue implements Serializable {
    private ArrayList<Product> products;

    /**
     * Constructs a new ProductCatalogue object, initializing the list of products.
     */
    public ProductCatalogue() {
        products = new ArrayList<>();
    }

    /**
     * Returns the list of products in the catalogue.
     * @return the list of persons
     */
    public ArrayList<Product> getCatalogue() {
        return products;
    }

    /**
     * Adds a product to the catalogue.
     * @param product the product to add
     */
    public void addProduct(Product product){
        products.add(product);
    }

    /**
     * Removes a product from the catalogue
     * @param product the product to remove
     */

    public void removeProduct(Product product) {
       products.remove(product); 
    }

    /**Tells the user that a given product was not found.
     * @param name the name of the product not found. */
    private void alertProductNotFound(String name) {
        System.out.println("The product '" + name + "' does not exist.");
    }
    
    /**Tells the user that a given product was not found.
     * @param productID the ID of the product not found. */
    private void alertProductNotFound(int productID) {
        System.out.println("The product '" + productID + "' does not exist.");
    }

    /**
     * Searches for a product by their ID.
     * @param productID the ID of the product to search for
     * @return the product if found, otherwise null
     */
    public Product searchForProductByID(int productID) {
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getProductID() == productID) {
                return products.get(i);
            }
        }

        alertProductNotFound(productID);
        return null;
    }

        /**
     * Searches for a product by their Name.
     * @param name the name of the product to search for
     * @return the product if found, otherwise null
     */
    public Product searchForProductByName(String name) {
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getName().equalsIgnoreCase(name)) {
                return products.get(i);
            }
        }
	    alertProductNotFound(name);
        return null;
    }

    /**
     * Prints the details of a product with the specified ID.
     * @param productID the ID of the product to print
     */
    public void printProductByID(int productID) {
        Product product = searchForProductByID(productID);
        if (product != null) {
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product ID: " + product.getProductID());
            System.out.println("Product Price: $" + product.getPrice());
        }
    }

    /**
     * Prints the details of a product with the specified name.
     * @param name the name of the product to print
     */
    public void printProductByName(String name) {
        Product product = searchForProductByName(name);
        if (product != null) {
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product ID: " + product.getProductID());
            System.out.println("Product Price: $" + product.getPrice());
        }
    }
    
    /**
     * Removes a product from the catalogue by its name.
     * @param name the name of the product to remove
     */
        public void removeProductByName(String name) {
            Product product = searchForProductByName(name);
            if (product != null) {
                products.remove(product);
            }
        }

    /**
     * Removes a product from the catalogue by its ID.
     * @param productID the ID of the product to remove
     */
    public void removeProductByID(int productID) {
        Product product = searchForProductByID(productID);
        if (product != null) {
            products.remove(product);
        }
    }

    /**
     * Retrieves a product from the catalogue by its index.
     * @param index the index of the product to retrieve
     * @return the product if found, otherwise null
     */
    public Product getProductByIndex(int index) {
        if (index >= 0 && index < products.size()) {
            return products.get(index);
        }
        return null;
    }

    /**
     * Returns the number of products in the catalogue.
     * @return the number of products in the catalogue.
     */
    public int size() {
        return products.size();
    }

    /**
     * Returns a product at an index.
     * @param index the index at which we are retrieving a product.
     * @return the product from the ArrayList that we are retreieving.
     */
    public Product get(int index) {
        return products.get(index);
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
