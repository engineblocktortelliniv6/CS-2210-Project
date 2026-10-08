/**
 * Author Xavier Cheney
 * Date: October 7, 2026
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Runnable;

public class Main {
    //public static Warehouse warehouse;
    //public static OrderCatalogue orderCatalogue;
    //public static PersonCatalogue PersonCatalogue;

    public static String userName;
    public static int userID;

    public static Scanner in;

    /**
     * this method is the entrypoint to the entire program
     * @param args , command line arguments
     */
    public static void main(String[] args) {
        // instanciate scanner
        in = new Scanner(System.in);

        // search to see if the big data variables have .txt files,
        // if the .txt files exist, then load the information
        // if they do not exist, then make new variables
        //warehouse = new Warehouse();
        //orderCatalogue = new orderCatalogue();
        //PersonCatalogue = new PersonCatalogue();

        // sign in the user
        //signIn();

        String menuName = "My Menu";
        String[] options = {"Option 1", "Option 2"};
        Runnable[] methods = {Main::option1, Main::option2};

        genericMenu(menuName, options, methods);
    }

    public static void option1() { System.out.println("You have selected option 1."); }
    public static void option2() { System.out.println("You have selected option 2."); }

    /**
     * asks the user for their name and ID,
     * and saves those to userName and userID
     */
    public static void signIn() {
        System.out.println("Sign In.");
        System.out.println("What is your name?");
        userName = in.nextLine();
        userID = in.nextInt();
        in.nextLine(); // consume the leftover newline
    }

    /**
     * this is a helper function that is meant to facilitate the creation of menus
     * we will have many menus, and so this method is nessicary not to duplicate code
     * assumes the existance of scanner in
     * @param menuName , the title of the menu
     * @param menuArguments , each option to display to the user
     * @param menuMethods , each method that we may want to call
     */
    public static void genericMenu(String menuName, String[] menuArguments, Runnable[] menuMethods) {
        int userChoice;
        int menuLength = menuArguments.length;
        int i;
        boolean didSelectInvalidOption;
        in = new Scanner(System.in);

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

