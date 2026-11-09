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

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        OrderCatalogue orderCatalogue = new OrderCatalogue();
        PersonCatalogue personCatalogue = new PersonCatalogue();

        // Populate catalogues using default dummy data
        SeedInformation.seed(warehouse, orderCatalogue, personCatalogue);

        // Serialize catalogues to data.dat
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