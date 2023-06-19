/**
 * Stores Booking information.
 * This class represents a booking
 * with flight and passenger details.
 * It provides methods to retrieve the
 * flight and passenger associated with the booking.
 *
 * @author Titwech Wal
 *
 * @version 1.0
 * @since 2023-06-09
 */

public class Booking {

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */

    // Stores the flight associated with the booking
    private Flight flight;

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */

    // Stores the passenger associated with the booking
    private Passenger passenger;

    /**
     * Constructs a new Booking instance.
     *
     * @param flight The flight associated with the booking.
     * @param passenger The passenger associated with the booking.
     *
     */

    public Booking(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
    }

    /**
     * Gets the flight associated with the booking.
     *
     * @return The flight.
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Gets the passenger associated with the booking.
     *
     * @return The passenger.
     */

    public Passenger getPassenger() {
        return passenger;
    }
}
