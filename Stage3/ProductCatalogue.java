import java.util.ArrayList;

/**
 * Manages a collection/catalogue of Product objects.
 * Provides lookup, addition, removal, and listing capabilities.
 * 
 * @author Nicholas Snyder
 * Created on November 2, 2026
 */
public class ProductCatalogue {
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
     * Searches for a product by their ID.
     * @param productID the ID of the product to search for
     * @return the product if found, otherwise null
     */
    public Product searchForProductByID(int productID){
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getProductID() == productID){
                return products.get(i);
            }
        }
        return null;
    }

        /**
     * Searches for a product by their Name.
     * @param name the name of the product to search for
     * @return the product if found, otherwise null
     */
    public Product searchForProductByName(String name){
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getName().equalsIgnoreCase(name)){
                return products.get(i);
            }
        }
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
        } else {
            System.out.println("Product with ID " + productID + " not found.");
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
        } else {
            System.out.println("Product with name " + name + " not found.");
        }
    }
}