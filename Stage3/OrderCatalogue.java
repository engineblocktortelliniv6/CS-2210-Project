import java.util.ArrayList;

/**
 * Manages a catalogue of orders
 * 
 * @author Tamara Galstian
 * Created on October 14, 2026
 */
public class OrderCatalogue {
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
     * Searches for an order by its number
     * 
     * @param orderNumber the number of the order to find
     * @return the order if found, or null if no such order exists
     */
    public Order searchForOrderByNumber(int orderNumber) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == (orderNumber)) {
                return orders.get(i);
            }
        }
        return null;
    }
}