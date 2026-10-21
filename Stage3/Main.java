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

    public static Scanner in;

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

        // initalize the scanner
        in = new Scanner(System.in);

        // search to see if the big data variables have .txt files,
        // if the .txt files exist, then load the information
        // if they do not exist, then make new variables
        warehouse = new Warehouse();
        orderCatalogue = new OrderCatalogue();
        PersonCatalogue = new PersonCatalogue();

        // sign in the user
        signIn();

        // start THE MENU
        Menu.in = in;
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

}
