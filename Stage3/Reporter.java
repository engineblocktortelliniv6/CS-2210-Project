/**
 * This class is used to print out information about orders, people, and products.
 * @author Nicholas Snyder
 * Created on October 28, 2026
 */

public class Reporter {

    /**
     * This method prints an order
     * @param order
     */
    public void printOrder(Order order) {
       System.out.println("Order Number: " + order.getOrderNumber());
       if (order.getOrderStatus() == true) {
        //Order status is a boolean variable. Printing based on if it is false(pending) true(complete)
        System.out.println("Order Status: Completed");
       } else {
        System.out.println("Order Status: Pending");
       }
       System.out.println("Products: " + order.getProducts());
       System.out.println("Orderer: " + order.getOrderer());
       System.out.println("Staff Name: " + order.getStaffName());
       System.out.println("Order Status: " + order.getOrderStatus());
       System.out.println("Order Type: " + order.getOrderType());
    }

    /**
     * This method prints a product
     * @param product
     */
    public void printProduct(Product product) {
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product ID: " + product.getProductID());
        System.out.println("Product Price: " + product.getPrice());
    }

    /**
     * This method prints a person
     * @param person
     */
    public void printPerson(Person person) {
        System.out.println("Person Name: " + person.getName());
        System.out.println("Person ID: " + person.getPersonId());
        System.out.println("Phone Number: " + person.getPhoneNumber());
    }

    /**
     * This method prints all of the orders inside of the order catalogue
     * @param orderCatalogue
     */
    public void printOrders(OrderCatalogue orderCatalogue) {
        for (Order order : orderCatalogue.getCatalogue()) {
            printOrder(order);
        }
    }

    /**
     * This method prints all of the people inside of the person catalogue
     * @param personCatalogue
     */
    public void printPeople(PersonCatalogue personCatalogue) {
        for (Person person : personCatalogue.getCatalogue()) {
            printPerson(person);
        }
    }

    /**
     * This method prints all of the products inside of the warehouse
     * @param warehouse
     */
    public void printWarehouseContents(Warehouse warehouse) {
        for (Product product : warehouse.getProducts()) {
            printProduct(product);
        }
    }
}
