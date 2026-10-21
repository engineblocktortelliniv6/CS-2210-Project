
public class InboundOrder extends Order{
   private Supplier orderer; 
   public InboundOrder(Supplier orderer) {
      super(0, null, false, orderer, null, "");
       this.orderer = orderer;
   }
   
   public Supplier getSupplier() {
       return orderer;
   }
   public void setSupplier(Supplier orderer) {
       this.orderer = orderer;
   }
}
