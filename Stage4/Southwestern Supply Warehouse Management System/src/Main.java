/**
 * Author Xavier Cheney
 * Date: November 25, 2026
 */
public class Main {

    public static Warehouse warehouse;
    public static OrderCatalogue orderCatalogue;
    public static PersonCatalogue personCatalogue;

    /**
     * this method is the entry point to the entire program
     * @param args for command line arguments (of which, if you add any, you will be ruthlessly mocked)
     */
    public static void main(String[] args) {
        
        // do said promised mockery
        if (args.length > 1) {
            System.out.println("YOU THOUGHT THAT A COMMAND LINE ARGUMENT WOULD DO ANYTHING !!! HAHAHAHAHHAHAHAHHA");
            System.out.println("Ah, well... anyways, let's continue to the main execution of the program.");
        }
        
        // Load serialized data from data.dat
        Object[] loadedData = FileManager.loadEverything();
        if (loadedData == null) {
            DataInit.initializeData();
            loadedData = FileManager.loadEverything();
        }
        warehouse = (Warehouse) loadedData[0];
        orderCatalogue = (OrderCatalogue) loadedData[1];
        personCatalogue = (PersonCatalogue) loadedData[2];
        FileManager.warehouse = warehouse;
        FileManager.orderCatalogue = orderCatalogue;
        FileManager.personCatalogue = personCatalogue;

        // open the signin menu
        // beyond this point, the control of the program jumps around from menu to menu
        // this means that the main method doesn't actually organise the execution control
        System.out.println("We don't want to use the old terminal-system.");
        System.out.println("So, here we need to put the methods for the new menu and signin system.");

    }

}
