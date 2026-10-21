/**
 * This is a class which we can use to test the functionality of our classes. Please edit as needed to test any code you need to test :)
 */
public class Test {
    public static void main(String[] args) {
     //Test here! :)

    Warehouse warehouse = new Warehouse();

    Product test = new Product("Test", 19.99, 102);
    warehouse.addProduct(test);

    warehouse.findProductById(102);
    System.out.println(warehouse.getProducts());

    System.out.println(test.getName());
    System.out.println(test.getPrice());
    System.out.println(test.getProductID());
}
    }