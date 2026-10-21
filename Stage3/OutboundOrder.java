
public class OutboundOrder extends Order {
    private String address;
    private Customer orderer;
    public OutboundOrder(String address, Customer orderer) {
        super(0, null, false, orderer, null, "");
        this.address = address;
        this.orderer = orderer;
    }
    public String getAddress() {
        return address;
    }
    public Customer getOrderer() {
        return orderer;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setOrderer(Customer orderer) {
        this.orderer = orderer;
    }
}
