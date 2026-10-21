import java.util.ArrayList;
public class Warehouse {
    private ArrayList<Product> products;

    public Warehouse() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getProductID() == id) {
                return product;
            }
        }
        return null;
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}