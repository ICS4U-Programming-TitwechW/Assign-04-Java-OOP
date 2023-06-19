/**
 * The Flight class represents a flight with its associated information.
 * It includes the flight number, origin, destination, and available seats.
 */

public class Flights {

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */

    private String flightNumber;

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */

    private String origin;

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */

    private String destination;

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */

    private int availableSeats;

    /**
     * Constructs a new Flight object with the specified information.
     *
     * @param flightNumber   The flight number.
     * @param origin         The origin location.
     * @param destination    The destination location.
     * @param availableSeats The number of available seats.
     *
     */

    public Flight(String flightNumber, String origin,
                    String destination, int availableSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    /**
     * Retrieves the flight number.
     *
     * @return The flight number.
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Retrieves the origin location.
     *
     * @return The origin location.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Retrieves the destination location.
     *
     * @return The destination location.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Retrieves the number of available seats.
     *
     * @return The number of available seats.
     */
    public int getAvailableSeats() {
        return availableSeats;
    }

    /**
     * Books a specified number of seats on the flight.
     *
     * @param seats The number of seats to be booked.
     */
    public void bookSeats(int seats) {
        availableSeats -= seats;
    }
}
