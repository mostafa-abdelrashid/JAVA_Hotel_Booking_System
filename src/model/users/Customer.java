package model.users;
import exception.InvalidEmailException;
import exception.InvalidPasswordException;
import model.booking.Booking;
import model.payment.PaymentMethod;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private final List<Booking> bookings;
    private final List<PaymentMethod> paymentMethods;

    public Customer(String name, String email, String password)
            throws InvalidEmailException, InvalidPasswordException {
                super(name, email, password);
                this.bookings = new ArrayList<>();
                this.paymentMethods = new ArrayList<>();
    }

    // Return defensive copies instead of direct references
    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public List<PaymentMethod> getPaymentMethods() {
        return new ArrayList<>(paymentMethods);
    }

    public void addBooking(Booking booking) {
        if (booking != null) {
            bookings.add(booking);
        }
    }

    public void addPaymentMethod(PaymentMethod method) {
        if (method != null) {
            paymentMethods.add(method);
        }
    }

    @Override
    public boolean login(String enteredPassword) {
        boolean success = enteredPassword != null && enteredPassword.equals(getPassword());
        System.out.println(getName() + " (Customer) " + (success ? "successfully" : "failed to") + " log in.");
        return success;
    }

    @Override
    public void logout() {
        System.out.println(getName() + " (Customer) logged out.");
    }
}