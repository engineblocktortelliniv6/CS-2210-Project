import java.io.Serializable;
import java.util.ArrayList;

/**
 * Manages a catalogue of orders
 * 
 * @author Tamara Galstian
 * Created on October 14, 2026
 */
public class OrderCatalogue implements Serializable {
    private ArrayList<Order> orders;

    /**
     * Creates an empty order catalogue
     */
    public OrderCatalogue() {
        orders = new ArrayList<>();
    }

    /**
     * Gets the list of orders
     * 
     * @return the list of orders
     */
    public ArrayList<Order> getCatalogue() {
        return orders;
    }

    /**
     * Adds an order to the catalogue
     * 
     * @param order the order to add
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * Removes an order from the catalogue by its ID
     * 
     * @param orderID the ID of the order to remove
     */
    public void removeOrderByID(int orderID) {
        Order order = searchForOrderByID(orderID);
        if (order != null) {
            orders.remove(order);
        }
    }

    /**
     * Searches for an order by its ID
     * 
     * @param orderID the ID of the order to find
     * @return the order if found, or null if no such order exists
     */
    public Order searchForOrderByID(int orderID) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderID() == (orderID)) {
                return orders.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return orders.toString();
    }
}