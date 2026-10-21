/**
 * @author Xavier Cheney
 * Date: October 21, 2026
 * This is a separate class for managing all of the files because Dr. Eduardo requesteth so.
 */
public class FileManager {
    
    /*-----------------------------------------------------------*/
    // THESE are THE METHODS for THE SAVING and THE LOADING of DATA
    /*-----------------------------------------------------------*/

    public static void loadEverything(Warehouse w, OrderCatalogue o, PersonCatalogue p) { w.loadFromTxt(); o.loadFromTxt(); p.loadFromTxt(); }
    public static void saveEverything(Warehouse w, OrderCatalogue o, PersonCatalogue p) { w.saveToTxt(); o.saveToTxt(); p.saveToTxt(); }

}
