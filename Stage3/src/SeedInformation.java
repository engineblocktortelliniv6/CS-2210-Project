/**
 * This class adds any saved or initial dummy information into the system.
 * This class is designed to be called by Main.java following
 * the creation of instances of our manager classes.
 * Created on 2 November 2026
 * @author Nicholas Snyder
 */
public class SeedInformation {

    /**
     * Seeds initial dummy data into the provided catalogues.
     * 
     * @param warehouse the Warehouse instance to populate
     * @param orderCatalogue the OrderCatalogue instance to populate
     * @param personCatalogue the PersonCatalogue instance to populate
     */
    public static void seed(Warehouse warehouse, OrderCatalogue orderCatalogue, PersonCatalogue personCatalogue) {
        
        // -------------------------------------------------------------
        // 1. CREATE STAFF MEMBERS
        // -------------------------------------------------------------
        Staff manager = new Staff("Alice Walker", 101, "555-564-0111", "Warehouse Manager", true, "ThisPasswordIsIncorrect");
        Staff defaultStaff = new Staff("Default", 100, "555-555-5555", "Default", true, "Default");
        Staff clerk = new Staff("Bob Martinez", 102, "555-756-0112", "Inventory Clerk", false, "Password");
        
        personCatalogue.addPerson(manager);
        personCatalogue.addPerson(clerk);
        personCatalogue.addPerson(defaultStaff);

        // -------------------------------------------------------------
        // 2. CREATE CUSTOMERS
        // -------------------------------------------------------------
        Customer cust1 = new Customer("John Miller", 201, "555-695-2851", "123 University Ave, Portales, NM");
        Customer cust2 = new Customer("Sarah Connor", 202, "555-785-0222", "456 Industrial Rd, Clovis, NM");

        personCatalogue.addPerson(cust1);
        personCatalogue.addPerson(cust2);

        // -------------------------------------------------------------
        // 3. CREATE PRODUCTS & SUPPLIERS
        // -------------------------------------------------------------
        Product p1 = new Product("Heavy Duty Wrench", 19.99, 1001);
        Product p2 = new Product("Cordless Power Drill", 89.50, 1002);
        
        ProductCatalogue toolCatalogue = new ProductCatalogue();
        toolCatalogue.addProduct(p1);
        toolCatalogue.addProduct(p2);

        Supplier sup1 = new Supplier("Apex Industrial Tools", 301, "555-0331", "789 Supply Ln, Albuquerque, NM", toolCatalogue);
        personCatalogue.addPerson(sup1);

        Product p3 = new Product("Safety Goggles", 12.00, 1003);
        Product p4 = new Product("High-Visibility Vest", 15.75, 1004);
        
        ProductCatalogue safetyCatalogue = new ProductCatalogue();
        safetyCatalogue.addProduct(p3);
        safetyCatalogue.addProduct(p4);

        Supplier sup2 = new Supplier("Shield Safety Supplies", 302, "555-0332", "101 Protection Way, Lubbock, TX", safetyCatalogue);
        personCatalogue.addPerson(sup2);

        // -------------------------------------------------------------
        // 4. WAREHOUSE INVENTORY
        // -------------------------------------------------------------
        warehouse.addProduct(p1);
        warehouse.addProduct(p2);
        warehouse.addProduct(p3);
        warehouse.addProduct(p4);

        // -------------------------------------------------------------
        // 5. TRANSACTIONS / ORDERS
        // -------------------------------------------------------------
        InboundOrder inOrder = new InboundOrder(sup1);
        inOrder.setOrder(4001);
        inOrder.setProducts(p1);
        inOrder.setProducts(p2);
        inOrder.setStaff(manager);
        inOrder.setOrderDate("2026-10-25");
        inOrder.setOrderStatus(DeliveryStatus.DELIVERED); // Completed delivery
        orderCatalogue.addOrder(inOrder);

        OutboundOrder outOrder = new OutboundOrder(cust1.getAddress(), cust1);
        outOrder.setOrder(4002);
        outOrder.setProducts(p3);
        outOrder.setProducts(p4);
        outOrder.setStaff(clerk);
        outOrder.setOrderDate("2026-11-01");
        outOrder.setOrderStatus(DeliveryStatus.IS_BEING_DELIVERED); // Pending delivery
        orderCatalogue.addOrder(outOrder);
    }
}
