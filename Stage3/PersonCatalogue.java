import java.util.ArrayList;

/**
 * This class represents a catalogue of persons, allowing for the addition, searching, and printing of person details.
 * @author Nicholas Snyder
 * Created on October 14, 2026
 */
public class PersonCatalogue {
    private ArrayList<Person> persons;

    /**
     * Constructs a new PersonCatalogue object, initializing the list of persons.
     */
    public PersonCatalogue() {
        persons = new ArrayList<>();
    }
    /**
     * Returns the list of persons in the catalogue.
     * @return the list of persons
     */
    public ArrayList<Person> getCatalogue() {
        return persons;
    }

    /**
     * Adds a person to the catalogue.
     * @param person the person to add
     */
    public void addPerson(Person person) {
        persons.add(person);
    }

    /**
     * Searches for a person by their ID.
     * @param personID the ID of the person to search for
     * @return the person if found, otherwise null
     */
    public Person searchForPerson(String personID) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getPersonId().equals(personID)) {
                return persons.get(i);
            }
        }
        return null;
    }
    /**
     * Prints the details of a person with the specified ID.
     * @param personID the ID of the person to print
     */
    public void printPerson(String personID) {
        Person person = searchForPerson(personID);
        if (person != null) {
            System.out.println("Name: " + person.getName());
            System.out.println("Person ID: " + person.getPersonId());
            System.out.println("Phone Number: " + person.getPhoneNumber());
        } else {
            System.out.println("Person with ID " + personID + " not found.");
        }
    }
}