public class Staff extends Person {
    private String jobTitle;
    private boolean isAdmin;
    private String password;

    public Staff(String name, String personID, int phoneNumber, String jobTitle, boolean isAdmin, String password) {
        super(name, personID, phoneNumber);
        this.jobTitle = jobTitle;
        this.isAdmin = isAdmin;
        this.password = password;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void addAdminStatus(boolean admin) {
        isAdmin = true;
    }

    public void removeAdminStatus() {
        isAdmin = false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean verifyPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
}
