/**
 * Handles the sign-in process for staff members.
 * @author Nicholas Snyder
 * Created on 4 November 2026
 */
public class SignIn {
    public static boolean signIn(Staff staff, String username, String password) {
        if (staff.verifyName(username) && staff.verifyPassword(password)) {
            return true;
        }
        return false;
    }
}
