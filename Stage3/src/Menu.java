import java.util.Scanner;

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
    public static boolean totallyNessicaryBoolean = false;

    /*----------------------------------------------------------*/
    // THESE are THE VARIABLES and THE METHODS for THE MENU SYSTEM
    /*----------------------------------------------------------*/

    public static final String SAVE_EVERYTHING = "Save Everything";
    public static final String[] MENU_STRINGS = {"Deliery Menu", "Warehouse Menu", "Person Menu", SAVE_EVERYTHING};
    public static final String[] ORDER_MENU_STRINGS = {"Print Orders", "Add Order", "Update Order Status", SAVE_EVERYTHING};
    public static final String[] WAREHOUSE_MENU_STRINGS = {"Find Product", "Add Product to Location", "Remove Product from Location", SAVE_EVERYTHING};
    public static final String[] PERSON_MENU_STRINGS = {"Display Supplier's Products", "Display a Person's Info", "Add Person", "Remove Person", "Change a Person's Information", "Change a Supplier's Information", "Change a Customer's Information", "Change a Staff's Information", SAVE_EVERYTHING};
    public static final String[] SET_ORDER_STATUS_STRINGS = {"delivered", "is being delivered"};
    public static final Runnable[] MENU_RUNNABLES = {Menu::orderMenu, Menu::warehouseMenu, Menu::personMenu, FileManager::saveEverything};
    public static final Runnable[] ORDER_MENU_RUNNABLES = {Menu::printOrders, Menu::addOrder, Menu::updateOrderStatus, FileManager::saveEverything};
    public static final Runnable[] WAREHOUSE_MENU_RUNNABLES = {Menu::findProduct, Menu::addProduct, Menu::removeProducts, FileManager::saveEverything};
    public static final Runnable[] PERSON_MENU_RUNNABLES = {Menu::printProductsOffered, Menu::printPerson, Menu::addPerson, Menu::removePerson, Menu::changePersonInfo, Menu::changeSupplierInfo, Menu::changeCustomerInfo, Menu::changeStaffInfo, FileManager::saveEverything};
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
    public static void addOrder() {
        System.out.println("In order to add a new order, we need to know some information.");
        System.out.print("What is the order ID? ");
        int ID = in.nextInt();
        in.nextLine(); // consume leftover newline

        System.out.print("What is the name of the person/orderer? ");
        String personName = in.nextLine();
        Person orderer = personCatalogue.searchForPersonByName(personName);
        if (orderer == null) {
            System.out.println("Person not found in catalogue. Order aborted.");
            return;
        }

        System.out.print("What is the name of the product to order? ");
        String prodName = in.nextLine();
        Product product = warehouse.searchForProductByName(prodName);
        if (product == null) {
            System.out.println("Product not found in warehouse inventory. Order aborted.");
            return;
        }

        ProductCatalogue catalogue = new ProductCatalogue();
        catalogue.addProduct(product);

        System.out.print("What is the order date (YYYY-MM-DD)? ");
        String date = in.nextLine();

        Order newOrder = new Order(ID, catalogue, orderer, menuUser, date);
        orderCatalogue.addOrder(newOrder);
        System.out.println("Order " + ID + " has been placed successfully.");
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
            Product prodByName = warehouse.searchForProductByName(name);
            if (prodByName != null) {
                reporter.printProduct(prodByName);
            } else {
                System.out.println("No such product exists in the warehouse with the name: " + name);
            }
            break;
        case "id":
            System.out.println("What is the ID of the product that you wish to search for?");
            int ID = in.nextInt();
            in.nextLine(); // consume the leftover newline
            Product prodByID = warehouse.searchForProductByID(ID);
            if (prodByID != null) {
                reporter.printProduct(prodByID);
            } else {
                System.out.println("No such product exists in the warehouse with the ID: " + ID);
            }
            break;
        default:
            if (totallyNessicaryBoolean) {
                System.out.println("We can't search by whatever attribute '" + mode + "' is, broski...");
            } else {
                System.out.println("We can't search by whatever attribute '" + mode + "' is.");
            }
            
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
            if (totallyNessicaryBoolean) {
                System.out.println("The name " + supplierName + " is not of a supplier, bro cha-cho.");
            } else {
                System.out.println("The name " + supplierName + " is not of a supplier.");
            }
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
        reporter.printProductsOffered(personCatalogue);
    }

    /**
     * Asks the user for the name of a Person,
     * and if they exist, the prints the information,
     * else returns an error.
     */
        public static void printPerson() {
        System.out.println("Please enter the ID of the person you would like to print:");
        int ID = in.nextInt();
        in.nextLine();
        Person person = personCatalogue.searchForPersonByID(ID);
        if (person == null) {
            System.out.println("Person not found.");
        } else {
            reporter.printPerson(person);
        }
    }

    /**Prompts the user for generic information related to every type of person.
     * Then asks the user which Person object they want to add, and for the correlarly information.
     * Finally, the function adds the object to the PersonCatalogue. */
    public static void addPerson() {
        // header prompt
        System.out.println("To add a person into the catalogue, please provide the following information:");
        
        // get generic information for a person
        System.out.println("What is the name of the person?");
        String name = in.nextLine();
        name = capitaliseName(name);
        System.out.println("What is the ID of the person?");
        int ID = in.nextInt();
        in.nextLine(); // consume the leftover newline
        System.out.println("What is the phone number of the person?");
        String phoneNumber = in.nextLine();

        // get object-specific information for a person
        do {
            System.out.println("Is this person a staff, supplier, or a customer?");
            String addPersonType = in.nextLine().toLowerCase();
            switch (addPersonType) {
                case "staff":
                    System.out.println("What is the staff's job title?");
                    String jobTitle = in.nextLine();
                    System.out.println("Is the staff an admin? Please type 'true' or 'false'.");
                    boolean isAdmin = getBoolean();
                    System.out.println("What is the staff's password?"); // totally secure ;)
                    String password = in.nextLine();
                    Staff addStaff = new Staff(name, ID, phoneNumber, jobTitle, isAdmin, password);
                    personCatalogue.addPerson(addStaff);
                    System.out.println(name + " added successfully.");
                return;
                case "supplier":
                    System.out.println("Each supplier has a number of products that they offer. Now you will list every product.");
                    System.out.println("Type 'done' when finished.");
                    ProductCatalogue products = getProductCatalogue();
                    System.out.println("What is the address of the supplier?");
                    String supplierAddress = in.nextLine();
                    Supplier supplier = new Supplier(name, ID, phoneNumber, supplierAddress, products);
                    personCatalogue.addPerson(supplier);
                    System.out.println(name + " added successfully.");
                return;
                case "customer":
                    System.out.println("What is the address of the customer?");
                    String customerAddress = in.nextLine();
                    Customer addCustomer = new Customer(name, ID, phoneNumber, customerAddress);
                    personCatalogue.addPerson(addCustomer);
                    System.out.println(name + " added successfully.");
                return;
                default:
                    System.out.println(addPersonType + " is not a 'staff', 'supplier', or a 'customer', so I can't add the person.");
                break;
            }
        } while (true);
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

    /*---------------------------------------------------------------------------*/
    // BEWARE OBJECT-ORIENTED PROGRAMMER for THIS is THE LAND of THE HELPER METHODS
    /*---------------------------------------------------------------------------*/

    /**
     * Capitalises each first letter of each token using the delimeter " "
     * @param name the name that we're capitalising.
     * @return a String where each token is capitalised.
     */
    private static String capitaliseName(String name) {
        String[] names = name.split(" ");
        String capitalisedName = "";
        for (int i = 0; i < names.length; i++ ) {
            capitalisedName += names[i].substring(0, 1).toUpperCase() + names[i].substring(1).toLowerCase() + " ";
        }
        return capitalisedName;
    }

    /**
     * Gets a boolean from the user.
     * @returns whatever the user types, bro.
     */
    private static boolean getBoolean() {
        do {
            String booleanString = in.nextLine().toLowerCase();
            switch (booleanString) {
                case "true": return true;
                case "false": return false;
                default: System.out.println("Invalid input: " + booleanString + ". Please type 'true' or 'false'.");
            }
        } while (true);
    }

    /**
     * Constructs a new Product from information given by the user.
     * @return a new Product object.
     */
    private static Product getProduct() {
        System.out.println("What is the name of the product?");
        String name = in.nextLine();
        System.out.println("What is the price of the product?");
        double price = in.nextDouble();
        in.nextLine(); // consume leftover newline
        System.out.println("What is the ID of the product?");
        int ID = in.nextInt();
        in.nextLine(); // consume leftover newline
        return new Product(name, price, ID);
    }

    /**
     * Constructs a new ProductCatalogue from information given by the user.
     * @return a new ProductCatalogue object.
     */
    private static ProductCatalogue getProductCatalogue() {
        ProductCatalogue products = new ProductCatalogue();
        String userInput = "";
        do {
            Product product = getProduct();
            products.addProduct(product);
            System.out.println("Continue? 'y'/'n'.");
            userInput = in.nextLine();
        } while (userInput != "n" || userInput != "done");
        return products;
    }

    /**
     * This is a helper function that is meant to facilitate the creation of menus.
     * We will have many menus, and so this method is nessicary not to duplicate code.
     * This method assumes the existance of that one variable of type Scanner named "in".
     * @param menuName , the title of the menu
     * @param menuArguments , each option to display to the user
     * @param menuMethods , each method that we may want to call
     */
    private static void genericMenu(String menuName, String[] menuArguments, Runnable[] menuMethods) {
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
