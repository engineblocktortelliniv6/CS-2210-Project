/**
 * This class represents a person with a name, person ID, and phone number.
 * @Author Nicholas Snyder
 * Date: October 14, 2026
 */

public class Person {

    private String name;
    private String personID;
    private String phoneNumber;

    /**
     * Constructs a new Person object with the specified name, person ID, and phone number.
     * @param name        the name of the person
     * @param personID    the identifier for the person
     * @param phoneNumber the phone number of the person
     */
    public Person(String name, String personID, String phoneNumber) {
        this.name = name;
        this.personID = personID;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the name of the person.
     * @return the name of the person
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the person ID of the person.
     * @return the person ID of the person
     */
    public String getPersonId() {
        return personID;
    }

    /**
     * Returns the phone number of the person.
     * @return the phone number of the person
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the name of the person.
     * @param name the new name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the person ID of the person.
     * @param personID the new person ID of the person
     */
    public void setPersonId(String personID) {
        this.personID = personID;
    }
    /**
     * Sets the phone number of the person.
     * @param phoneNumber the new phone number of the person
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}