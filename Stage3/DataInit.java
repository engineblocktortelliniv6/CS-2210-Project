import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *Class to seed initial data into data.dat.
 * Run once to generate the baseline save file.
 * 
 * @author Nicholas Snyder
 * Date: November 6, 2026
 */
public class DataInit {

    /**
     * Seeds the initial data into data.dat.
     * This method should be run once to generate the baseline save file.
     * It initializes the warehouse, order catalogue, and person catalogue with default dummy data.
     * The data is then serialized to data.dat.
     * If an error occurs during serialization, an error message is displayed.
     * @throws IOException if an error occurs while writing to data.dat
     * @throws RuntimeException if an unexpected error occurs during initialization
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Initialize warehouse, order catalogue, and person catalogue with dummy values.
        Warehouse warehouse = new Warehouse();
        OrderCatalogue orderCatalogue = new OrderCatalogue();
        PersonCatalogue personCatalogue = new PersonCatalogue();

        // Populate catalogues using default dummy data
        SeedInformation.seed(warehouse, orderCatalogue, personCatalogue);

        /**
         * Serialize catalogues to data.dat
         * @throws IOException if an error occurs while writing to data.dat
         * @throws RuntimeException if an unexpected error occurs during serialization
         */
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FileManager.FILE_NAME))) {
            out.writeObject(warehouse);
            out.writeObject(orderCatalogue);
            out.writeObject(personCatalogue);
            System.out.println("data.dat created and seeded successfully.");
        } catch (IOException e) {
            System.out.println("Error generating data.dat: " + e.getMessage());
        }
    }
}