import java.util.Scanner;

/**
 * Author Xavier Cheney
 * Date: October 21, 2026
 * This is a separate class for managing all menus because Dr. Eduardo requesteth so.
 */
public class Menu {

    public static Scanner in;

    /*----------------------------------------------------------*/
    // THESE are THE VARIABLES and THE METHODS for THE MENU SYSTEM
    /*----------------------------------------------------------*/

    public static final String SAVE_EVERYTHING = "Save Everything";
    public static final String[] MENU_STRINGS = {"Deliery Menu", "Warehouse Menu", "Person Menu", SAVE_EVERYTHING};
    public static final String[] ORDER_MENU_STRINGS = {"Print Orders", "Add Order", "Update Order Status", SAVE_EVERYTHING};
    public static final String[] WAREHOUSE_MENU_STRINGS = {"Display Locations", "Display a Location's Products", "Find Product", "Add Product to Location", "Remove Product from Location", SAVE_EVERYTHING};
    public static final String[] PERSON_MENU_STRINGS = {"Display Supplier's Products", "Display a Person's Info", "Add Person", "Remove Person", "Change a Person's Information", "Change a Supplier's Information", "Change a Customer's Information", "Change a Staff's Information", SAVE_EVERYTHING};
    public static final String[] ADD_PERSON_MENU_STRINGS = {"Add Staff", "Add Supplier", "Add Customer"};
    public static final Runnable[] MENU_RUNNABLES = {Menu::orderMenu, Menu::warehouseMenu, Menu::personMenu, Main::saveEverything};
    public static final Runnable[] ORDER_MENU_RUNNABLES = {Main::printOrders, Main::addOrder, Main::updateOrderStatus, Main::saveEverything};
    public static final Runnable[] WAREHOUSE_MENU_RUNNABLES = {Main::printLocations, Main::printProducts, Main::findProduct, Main::addProduct, Main::removeProducts, Main::saveEverything};
    public static final Runnable[] PERSON_MENU_RUNNABLES = {Main::printProductsOffered, Main::printPerson, Main::addPerson, Main::removePerson, Main::changePersonInfo, Main::changeSupplierInfo, Main::changeCustomerInfo, Main::changeStaffInfo, Main::saveEverything};
    public static final Runnable[] ADD_PERSON_MENU_RUNNABLES = {Main::addStaff, Main::addSupplier, Main::addCustomer};
    public static void menu() { genericMenu("Main Menu", MENU_STRINGS, MENU_RUNNABLES); }
    public static void orderMenu() { genericMenu("Order Menu", ORDER_MENU_STRINGS, ORDER_MENU_RUNNABLES); }
    public static void warehouseMenu() { genericMenu("Warehouse Menu", WAREHOUSE_MENU_STRINGS, WAREHOUSE_MENU_RUNNABLES); }
    public static void personMenu() { genericMenu("Person Menu", PERSON_MENU_STRINGS, PERSON_MENU_RUNNABLES); }
    
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