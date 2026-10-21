/**
 * This class represents a staff member, extending the Person class.
 * @Author Nicholas Snyder
 * Date: October 14, 2026
 */
public class Staff extends Person {
    private String jobTitle;
    private boolean isAdmin;
    private String password;

    /**
     * Constructs a new Staff object with the specified name, person ID, phone number, job title, admin status, and password.
     * @param name
     * @param personID
     * @param phoneNumber
     * @param jobTitle
     * @param isAdmin
     * @param password
     */
    public Staff(String name, String personID, String phoneNumber, String jobTitle, boolean isAdmin, String password) {
        super(name, personID, phoneNumber);
        this.jobTitle = jobTitle;
        this.isAdmin = isAdmin;
        this.password = password;
    }

    /**
     * Returns the job title of the staff member.
     * @return
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Sets the job title of the staff member.
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Returns whether the staff member has admin privileges.
     * @return
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Sets the admin status of the staff member.
     * @param admin
     */
    public void addAdminStatus(boolean admin) {
        isAdmin = true;
    }

    /**
     * Removes admin status from the staff member.
     */
    public void removeAdminStatus() {
        isAdmin = false;
    }

    /**
     * Returns the password of the staff member.
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the staff member.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Verifies the password of the staff member.
     * @param Password
     * @return
     */
    public boolean verifyPassword(String Password) {
        return password.equals(Password);
    }

    /**
     * Verifies the name of the staff member.
     * @param name
     * @return
     */
    public boolean verifyName(String name) {
        return getName().equals(name);
    }

    /**
     * Returns a string representation of the staff member.
     * @return a string representation of the staff member
     */
    @Override 
    public String toString() {
        return "Staff{" +
                "name='" + getName() + '\'' +
                ", personID='" + getPersonId() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
