import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Xavier Cheney
 * Date: October 21, 2026
 * This is a separate class for managing all menus because Dr. Eduardo requesteth so.
 */
public class Menu {

    public static Scanner in;
    public static Reporter reporter;
    public static Warehouse warehouse;
    public static OrderCatalogue orderCatalogue;
    public static PersonCatalogue personCatalogue;
    public static Order holdOrder;
    public static Staff menuUser;

    /*----------------------------------------------------------*/
    // THESE are THE VARIABLES and THE METHODS for THE MENU SYSTEM
    /*----------------------------------------------------------*/

    public static final String SAVE_EVERYTHING = "Save Everything";
    public static final String[] MENU_STRINGS = {"Deliery Menu", "Warehouse Menu", "Person Menu", SAVE_EVERYTHING};
    public static final String[] ORDER_MENU_STRINGS = {"Print Orders", "Add Order", "Update Order Status", SAVE_EVERYTHING};
    public static final String[] WAREHOUSE_MENU_STRINGS = {"Display Locations", "Display a Location's Products", "Find Product", "Add Product to Location", "Remove Product from Location", SAVE_EVERYTHING};
    public static final String[] PERSON_MENU_STRINGS = {"Display Supplier's Products", "Display a Person's Info", "Add Person", "Remove Person", "Change a Person's Information", "Change a Supplier's Information", "Change a Customer's Information", "Change a Staff's Information", SAVE_EVERYTHING};
    public static final String[] ADD_PERSON_MENU_STRINGS = {"Add Staff", "Add Supplier", "Add Customer"};
    public static final String[] SET_ORDER_STATUS_STRINGS = {"delivered", "is being delivered"};
    public static final Runnable[] MENU_RUNNABLES = {Menu::orderMenu, Menu::warehouseMenu, Menu::personMenu, FileManager::saveEverything};
    public static final Runnable[] ORDER_MENU_RUNNABLES = {Menu::printOrders, Menu::addOrder, Menu::updateOrderStatus, FileManager::saveEverything};
    public static final Runnable[] WAREHOUSE_MENU_RUNNABLES = {Menu::findProduct, Menu::addProduct, Menu::removeProducts, FileManager::saveEverything};
    public static final Runnable[] PERSON_MENU_RUNNABLES = {Menu::printProductsOffered, Menu::printPerson, Menu::addPerson, Menu::removePerson, Menu::changePersonInfo, Menu::changeSupplierInfo, Menu::changeCustomerInfo, Menu::changeStaffInfo, FileManager::saveEverything};
    public static final Runnable[] ADD_PERSON_MENU_RUNNABLES = {Menu::addStaff, Menu::addSupplier, Menu::addCustomer};
    public static final Runnable[] SET_ORDER_STATUS_RUNNABLES = {Menu::setOrderToDelivered, Menu::setOrderToBeingDelivered};
    public static void menu() { genericMenu("Main Menu", MENU_STRINGS, MENU_RUNNABLES); }
    public static void orderMenu() { genericMenu("Order Menu", ORDER_MENU_STRINGS, ORDER_MENU_RUNNABLES); }
    public static void warehouseMenu() { genericMenu("Warehouse Menu", WAREHOUSE_MENU_STRINGS, WAREHOUSE_MENU_RUNNABLES); }
    public static void personMenu() { genericMenu("Person Menu", PERSON_MENU_STRINGS, PERSON_MENU_RUNNABLES); }
    
    /*---------------------------------------*/
    // THESE are THE METHODS for THE ORDER MENU
    /*---------------------------------------*/

    /**
     * Prints the information related to each inbound order.
     * This is the FIRST REPORT.
     */
    public static void printOrders() {
        reporter.printOrders(orderCatalogue);
    }

    /**Asks the user for information related to a new order, and adds it.
     * Displays a message indicating to the user that the order has been placed successfully. */
    // THIS IS NOT FINISHED, FINISH IT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static void addOrder() {
        System.out.println("In order to add a new order, we need to know some information.");
        int ID;
        while (true) {
            System.out.println("What is the ID?");
            ID = in.nextInt();
            in.nextLine(); // consume the leftover newline
            break;
        }
        
        System.out.println("What are the products?");
        ProductCatalogue catalogue = new ProductCatalogue();
        System.out.println("Who needs the products for the order");
        Person orderer = new Person("", 30, "3030");
        System.out.println("What is the date?");
        String date = in.nextLine();

        Order newOrder = new Order(ID, catalogue, orderer, menuUser, date);
        orderCatalogue.addOrder(newOrder);
    }

    /**First, we display the information about all orders.
     * Then we ask the user for the orderNumber of an order,
     * and then displays its status.
     * Next, the method asks the user whether or not the order should be set to
     * 1. "delivered" or 2. "is being delivered". */
    public static void updateOrderStatus() {
        // displays all orders
        System.out.println("These are all of the orders that we have in the order catalogue:");        
        reporter.printOrders(orderCatalogue);
        System.out.println();
        // get the specific order we're talkin' about
        System.out.println("In order to set the delivery status, please input the order's ID:");
        int ID = in.nextInt();
        in.nextLine(); // consume the leftover newline
        // detect the user actually gave a valid order
        Order order = orderCatalogue.searchForOrderByID(ID);
        holdOrder = order;
        if (order == null) {
            System.out.println("No such order exists in the catalogue with the ID: " + ID);
            return;
        }
        // change the order's status
        genericMenu("What is the new status of the order? Quit when finished.", SET_ORDER_STATUS_STRINGS, SET_ORDER_STATUS_RUNNABLES);
    }

    public static void setOrderToDelivered() { holdOrder.setOrderStatus(DeliveryStatus.DELIVERED); }
    public static void setOrderToBeingDelivered() { holdOrder.setOrderStatus(DeliveryStatus.IS_BEING_DELIVERED); }

    /*-------------------------------------------*/
    // THESE are THE METHODS for THE WAREHOUSE MENU
    /*-------------------------------------------*/

    /**
     * Asks user for a product,
     * then prints the product.
     */
    public static void findProduct() {
        // get user search mode
        System.out.println("If you wish to search for a product, then do you want to search by name or by ID?");
        System.out.println("Write 'ID' or 'name'.");
        String mode = in.nextLine().toLowerCase();

        // print info based on the mode
        switch (mode) {
        case "name":
            System.out.println("What is the name of the product that you wish to search for?");
            String name = in.nextLine();
            warehouse.removeProductByName(name);
            break;
        case "id":
            System.out.println("What is the name of the product that you wish to search for?");
            int ID = in.nextInt();
            in.nextLine(); // consume the leftover newline
            warehouse.removeProductByID(ID);
            break;
        default:
            System.out.println("We can't search by whatever attribute '" + mode + "' is, broski...");
            break;
        }
    }

    /**
     * Asks the user for the name of a Supplier,
     * and then display the products offered by that supplier,
     * and then ask the user which product they want to add.
     * Displays a message indicating that the item has been added successfully.
     */
    public static void addProduct() {
        System.out.println("To add a product, we need to know from which supplier the product that you want to add comes from.");
        System.out.println("What is the name of the supplier?");
        String supplierName = in.nextLine();
        Person personSupplier = personCatalogue.searchForPersonByName(supplierName);
        if (personSupplier instanceof Supplier) {} else {
            System.out.println("The name " + supplierName + " is not of a supplier bro cha-cho.");
            return;
        }
        Supplier supplier = (Supplier)personSupplier;
        if (supplier == null) {
            System.out.println("That supplier does not exist in the system, so we can't add the product.");
            return;
        }

        // get the arraylist of products that the supplier offers
        ProductCatalogue products = supplier.getProducts();
        if (products.size() == 0) {
            System.out.println("That supplier does not offer any products, so you can't choose which one to add.");
            return;
        }
        for (int i = 0; i < products.size(); i++ ) {
            reporter.printProduct(products.get(i));
        }

        System.out.println("What is the name of the product that you want to add?");
        String productString = in.nextLine();
        Product product = null;
        for (int i = 0; i < products.size(); i++ ) {
            if (products.get(i).getName().equals(productString)) {
                product = products.get(i);
            }
        }
        if (product == null) {
            System.out.println("That supplier does not have any " + productString + ", so we can't add it.");
        }

        System.out.println(productString + " added successfully.");
    }

    /**
     * Asks the user for the names related to some Product(s),
     * and removes those Product(s) from the Warehouse.
     * Displays a message indicating that the item has been removed successfully.
     */
    public static void removeProducts() {
        System.out.println("What are the names of the products that you would like to remove?");
        System.out.println("Please write each name on a seperate line, and write 'done' when finished.");
        
        do {
            String name = in.nextLine().toLowerCase();
            if (name.equals("done")) {
                break;
            } else {
                warehouse.removeProductByName(name);
                System.out.println(name + " removed successfully.");
            }
        } while (true);
    }

    /*-------------------------------------------*/
    // THESE are THE METHODS for THE PERSON MENU(s)
    /*-------------------------------------------*/

    /**
     * Prints all of the products offered by each Supplier.
     * This is the SECOND REPORT.
     */
    public static void printProductsOffered() {

    }

    /**
     * Asks the user for the name of a Person,
     * and if they exist, the prints the information,
     * else returns an error.
     */
    public static void printPerson() {

    }

    /**
     * Asks the user which Person object they want to add,
     * and then prompts the generic information related to that person,
     * and then calls a function to get the more specific non-inherited information,
     * and then adds the object to the PersonCatalogue.
     */
    public static void addPerson() {
        genericMenu("Add Person Menu", ADD_PERSON_MENU_STRINGS, ADD_PERSON_MENU_RUNNABLES);
    }

    public static void addStaff() {

    }

    public static void addSupplier() {
        
    }

    public static void addCustomer() {
        
    }

    /**
     * Asks the user for the name of a Person object,
     * and then removes it from the PersonCatalogue.
     */
    public static void removePerson() {
        
    }

    /**
     * Asks the user for the name of a Person,
     * then asks the user whether or not they would like to change the Person's name or phone number,
     * and then changes it.
     */
    public static void changePersonInfo() {

    }

    /**
     * Asks the user for the name of a Supplier,
     * then asks the user what the new address of Supplier should be,
     * and then changes it.
     */
    public static void changeSupplierInfo() {

    }

    /**
     * Asks the user for the name of a Customer,
     * then asks the user what the new address of Customer should be,
     * and then changes it.
     */
    public static void changeCustomerInfo() {

    }

    /**
     * Asks the user for the name of a Staff,
     * then asks the user what the new  of the user should be,
     * and then changes it.
     */
    public static void changeStaffInfo() {
        
    }

    /*--------------------------------------------------------------------------*/
    // BEWARE OBJECT-ORIENTED PROGRAMMER for THIS is THE LAND of THE HELPER METHOD
    /*--------------------------------------------------------------------------*/

    /**
     * This is a helper function that is meant to facilitate the creation of menus.
     * We will have many menus, and so this method is nessicary not to duplicate code.
     * This method assumes the existance of that one variable of type Scanner named "in".
     * @param menuName , the title of the menu
     * @param menuArguments , each option to display to the user
     * @param menuMethods , each method that we may want to call
     */
    public static void genericMenu(String menuName, String[] menuArguments, Runnable[] menuMethods) {
        int userChoice;
        int menuLength = menuArguments.length;
        int i;
        boolean didSelectInvalidOption;

        do {
            // display the menu
            System.out.println("---" + menuName + "---");
            for (i = 0; i < menuLength; i++ ) {
                System.out.println(i + ". " + menuArguments[i]);
            }
            System.out.println(menuLength + ". Quit");
            System.out.println("~~~~~~~~");
            System.out.print("Option: ");

            // get user input
            userChoice = in.nextInt();
            in.nextLine(); // consume the leftover newline

            // decide what to do based on the user input
            didSelectInvalidOption = true;
            for (i = 0; i < menuLength; i++ ) {
                if (userChoice == i) {
                    didSelectInvalidOption = false;
                    menuMethods[i].run();
                }
            }
            if (didSelectInvalidOption && userChoice != menuLength) {
                System.out.println("You selected an invalid option.");
            }

        } while (userChoice != menuLength);
    }

}
