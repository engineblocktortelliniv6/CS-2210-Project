/** This class represents a product in the inventory system 
* @author Nicholas Snyder
* Created on October 17, 2026
*/
public class Product {
    String name;
    double price;
    int productID;

    /**
     * Constructs a new Product object with the specified name, price, and product ID.
     * @param name
     * @param price
     * @param productID
     */
    public Product(String name, double price, int productID) {
        this.name = name;
        this.price = price;
        this.productID = productID;
    }

    /**
     * Returns the name of the product.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the product.
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the product ID of the product.
     * @return productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Sets the name of the product.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the price of the product.
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the product ID of the product.
     * @param productID
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }
}