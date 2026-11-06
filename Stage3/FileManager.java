import java.io.*;

/**
 * @author Nicholas Snyder
 * Date: November 6, 2026
 * This is a separate class for managing all of the files through saving and loading.
 */
public class FileManager {
    public static final String FILE_NAME = "data.dat";

    /**
     * Saves the current state of the warehouse.
     * If the file is saved successfully, a message will be displayed.
     * If there is an error, a message will be displayed.
     * @param w the warehouse to save
     * @param o the order catalogue to save
     * @param p the person catalogue to save
     */
    public static void saveEverything(Warehouse w, OrderCatalogue o, PersonCatalogue p) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(w);
            out.writeObject(o);
            out.writeObject(p);
            System.out.println("All data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    /**
     * Checks if data.dat exists. If so, restores the serialized catalogues.
     * @return Object array [Warehouse, OrderCatalogue, PersonCatalogue], or null if file does not exist.
     */
    public static Object[] loadEverything() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return null; // Signals that no save file exists
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Warehouse w = (Warehouse) in.readObject();
            OrderCatalogue o = (OrderCatalogue) in.readObject();
            PersonCatalogue p = (PersonCatalogue) in.readObject();
            System.out.println("Data loaded successfully from " + FILE_NAME);
            return new Object[]{w, o, p};
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file: " + e.getMessage());
            return null;
        }
    }
}
