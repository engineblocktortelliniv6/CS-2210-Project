
public class OutboundOrder {
    private String address;
    private Customer orderer;
    public OutboundOrder(String address, Customer orderer) {
        //call super
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
