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

    public Order searchForOrderByNumber(int orderNumber) {
      for (int i = 0; i < orders.size(); i++) {
        if(orders.get(i).getOrderNumber() == (orderNumber)){
            return orders.get(i);
            }    
        }
        return null;
    }
}