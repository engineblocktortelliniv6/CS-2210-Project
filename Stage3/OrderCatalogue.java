import java.util.ArrayList;

public class OrderCatalogue {
    private ArrayList<Order> orders;

    public OrderCatalogue() {
        orders = new ArrayList<>();
    }

    public ArrayList<Order> getCatalogue() {
        return orders;
    }

    public void addOrder (Order order) {
        orders.add(order);
    }
}
