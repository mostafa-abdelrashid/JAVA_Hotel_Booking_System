package model.users;
import exception.InvalidEmailException;
import exception.InvalidPasswordException;

public class Admin extends User {
    public Admin(String name, String email, String password)
            throws InvalidEmailException, InvalidPasswordException {
        super(name, email, password);
    }

    @Override
    public boolean login(String enteredPassword) {
        // In real system, might have stronger admin password requirements
        boolean success = enteredPassword != null && enteredPassword.equals(getPassword());
        System.out.println(getName() + " (Admin) " + (success ? "successfully" : "failed to") + " log in.");
        return success;
    }

    @Override
    public void logout() {
        System.out.println(getName() + " (Admin) logged out.");
    }


}