/**
 * <p>This class represents a warehouse that manages a collection of products.
 * It wraps the ProductCatalogue class to provide functionality.
 * @author Xavier Cheney
 * @version 2.0 on November 4, 2026
 */
public class Warehouse {
    private ProductCatalogue products;

    /**Constructs a new Warehouse object, initializing the list of products. */
    public Warehouse() {
        this.products = new ProductCatalogue();
    }
    
    /**Returns the products in the Warehouse.
     * @return the Warehouse's ProductCatalogue */
    public ProductCatalogue getProducts() {
        return this.products;
    }

    /**Adds a product to the warehouse.
     * @param product the product that we want to add. */
    public void addProduct(Product product) {
        products.addProduct(product);
    }

    /**
     * Adds a product to the warehouse
     * @param catalogue the catalogue containing products to add
     */

    public void addProducts(ProductCatalogue catalogue) {
        for (Product product : catalogue.getCatalogue()) {
            addProduct(product);
        }
    }

    /**Uses removeProductByID() from ProductCatalogue.
     * @param productID */
    public void removeProductByID(int productID) {
        products.removeProductByID(productID);
    }

    /**Uses removeProductByName() from ProductCatalogue.
     * @param name */
    public void removeProductByName(String name) {
        products.removeProductByName(name);
    }

    /**Uses searchForProductByID() from ProductCatalogue.
     * @param productID */
    public Product searchForProductByID(int productID) {
        return products.searchForProductByID(productID);
    }

    /**Uses searchForProductByName() from ProductCatalogue.
     * @param name */
    public Product searchForProductByName(String name) {
        return products.searchForProductByName(name);
    }

    /**Uses printProductByID() from ProductCatalogue.
     * @param productID */
    public void printProductByID(int productID) {
        products.printProductByID(productID);
    }

    /**Uses printProductByName() from ProductCatalogue.
     * @param name */
    public void printProductByName(String name) {
        products.printProductByName(name);
    }

}
