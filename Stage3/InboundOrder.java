
public class InboundOrder extends Order{
   private Supplier orderer; 
   public InboundOrder(Supplier orderer) { 
       this.orderer = orderer;
       //call super
   }
   
   public Supplier getSupplier() {
       return orderer;
   }
   public void setSupplier(Supplier orderer) {
       this.orderer = orderer;
   }
}
