/**
 * The Passenger class represents a
 * passenger with their name, email,
 * and phone number.
 */
public class Passenger {

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private String name;

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private String email;

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private String phoneNumber;
FUN
    /**
     * Constructs a Passenger object with the
     * specified name, email, and phone number.
     *
     * @param name         the name of the passenger
     * @param email        the email of the passenger
     * @param phoneNumber  the phone number of the passenger
     */
    public Passenger(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the name of the passenger.
     *
     * @return the name of the passenger
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the email of the passenger.
     *
     * @return the email of the passenger
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the phone number of the passenger.
     *
     * @return the phone number of the passenger
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
