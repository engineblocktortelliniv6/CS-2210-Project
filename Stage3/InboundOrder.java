/**
 * Represents an inbound order for receiving
 * products from a supplier 
 * @author Tamara Galstian
 * Created on October 21, 2026
 */
public class InboundOrder extends Order {
   private Supplier orderer; 
/**
 * Creates an inbound order from a supplier
 * @param orderer the supplier providing the products 
 */
   public InboundOrder(Supplier orderer) {
      super(0, null, false, 
      orderer, null, "");
      this.orderer = orderer;
   }
/**
 * Gets the supplier for the inbound order
 * @return the supplier
 */   
   public Supplier getSupplier() {
       return orderer;
   }
/**
 * Sets the supplier for the inbound order
 * @param orderer
 */
   public void setSupplier(Supplier orderer) {
       this.orderer = orderer;
   }
}
