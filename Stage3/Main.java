/**
 * Author Xavier Cheney
 * Date: October 14, 2026
 * And if you're curious what proportion of it I have written, you can know that the answer is ALL of IT!!!
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Runnable;

public class Main {
    public static Warehouse warehouse;
    public static OrderCatalogue orderCatalogue;
    public static PersonCatalogue PersonCatalogue;

    /**
     * this method is the entrypoint to the entire program
     * @param args for command line arguments (of which, if you add any, you will be ruthlessly mocked)
     */
    public static void main(String[] args) {
        
        // do said promised mockery
        if (args.length > 1) {
            System.out.println("YOU THOUGHT THAT A COMMAND LINE ARGUMENT WOULD DO ANYTHING !!! HAHAHAHAHHAHAHAHHA");
            System.out.println("Ah, well... anyways, let's continue to the main execution of the program.");
        }

        // search to see if the big data variables have .txt files,
        // if the .txt files exist, then load the information
        // if they do not exist, then make new variables
        warehouse = new Warehouse();
        orderCatalogue = new orderCatalogue();
        PersonCatalogue = new PersonCatalogue();

        // sign in the user
        signIn();

        // start THE MENU
        Menu.in = new Scanner(System.in);
        Menu.menu();

        // close the scanner
        in.close();
    }

    /*------------------------------------------------------------*/
    // THESE are THE VARIABLES and THE METHODS for THE SIGNIN SYSTEM
    /*------------------------------------------------------------*/

    /**
     * Stores the user's name.
     * The value is established in the signIn() method.
     */
    public static String userName;
    
    /**
     * Stores the user's ID.
     * The value is established in the signIn() method.
     */
    public static int userID;
    
    /**
     * Asks the user for their name and ID,
     * and saves those to userName and userID
     */
    public static void signIn() {
        System.out.println("Sign In.");
        System.out.println("What is your name?");
        userName = in.nextLine();
        userID = in.nextInt();
        in.nextLine(); // consume the leftover newline
    }

    /*-----------------------------------------------------------*/
    // THESE are THE METHODS for THE SAVING and THE LOADING of DATA
    /*-----------------------------------------------------------*/

    public static void loadEverything() { warehouse.loadFromTxt(); orderCatalogue.loadFromTxt(); personCatalogue.loadFromTxt(); }
    public static void saveEverything() { warehouse.saveToTxt(); orderCatalogue.saveToTxt(); personCatalogue.saveToTxt(); }

    /*---------------------------------------*/
    // THESE are THE METHODS for THE ORDER MENU
    /*---------------------------------------*/

    /**
     * Prints the information related to each inbound order.
     * This is the FIRST REPORT.
     */
    public static void printOrders() {
        System.out.println("I am printing the orders ;)");
    }

    /**
     * Asks the user for information related to a new order, and adds it.
     * Displays a message indicating to the user that the order has been placed successfully.
     */
    public static void addOrder() {
        System.out.println("What is the information");
    }

    /**
     * Asks the user for the orderNumber of an order,
     * and then displays its status.
     * Next, the method asks the user whether or not the order should be set to
     * 1. "delivered" or 2. "is being delivered".
     */
    public static void updateOrderStatus() {

    }

    /*-------------------------------------------*/
    // THESE are THE METHODS for THE WAREHOUSE MENU
    /*-------------------------------------------*/

    /**
     * Prints the ProductLocation array in the warehouse.
     */
    public static void printLocations() {

    }

    /**
     * Asks user for the name of a ProductLocation, then prints its products.
     */
    public static void printProducts() {

    }

    /**
     * Asks user for product, then prints the quantity and locations of that product.
     */
    public static void findProduct() {

    }

    /**
     * Asks the user for the name of a Supplier,
     * and then display the products offered by that supplier,
     * and then ask the user which product they want to add.
     * Then ask the user which ProductLocation they want to add it to,
     * and then append it to the ProductLocation.
     * Displays a message indicating that the item has been added successfully.
     */
    public static void addProduct() {

    }

    /**
     * Asks the user for the name of a ProductLocation,
     * and then for the names related to some Product(s),
     * and removes those Product(s) from that ProductLocation.
     * Displays a message indicating that the item has been removed successfully.
     */
    public static void removeProducts() {

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

}
