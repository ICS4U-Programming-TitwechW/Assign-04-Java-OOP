import java.util.ArrayList;
import java.util.List;

/**
 * The BookingSystem class represents a flight booking system.
 * It allows users to search for flights,
 * book seats, and manage passenger information.
 * The system maintains lists of flights, passengers, and bookings.
 */
public class BookingSystem {

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */

    // List of available flights
    private List<Flight> flights;

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */

    // List of registered passengers
    private List<Passenger> passengers;

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */

    // List of booked flights
    private List<Booking> bookings;

    /**
     * Constructs a new BookingSystem object.
     * Initializes the lists for flights, passengers, and bookings.
     */
    public BookingSystem() {
        flights = new ArrayList<>();
        passengers = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    /**
     * Adds a flight to the list of available flights.
     *
     * @param flight The flight to be added.
     */
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    /**
     * Adds a passenger to the list of registered passengers.
     *
     * @param passenger The passenger to be added.
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    /**
     * Books a seat for a passenger on a specific flight.
     *
     * @param flightNumber  The flight number of the desired flight.
     * @param passengerName The name of the passenger.
     */

    public void bookSeat(String flightNumber, String passengerName) {

        final Flight flight = findFlight(flightNumber);
        final Passenger passenger = findPassenger(passengerName);

        if (flight == null) {
            System.out.println("Flight not found.");
            return;
        }

        if (passenger == null) {
            System.out.println("Passenger not found.");
            return;
        }

        if (flight.getAvailableSeats() == 0) {
            System.out.println("No seats available for the selected flight.");
            return;
        }

        final Booking booking = new Booking(flight, passenger);
        bookings.add(booking);

        flight.bookSeats(1);
        System.out.println("Booking successful!");
    }

    /**
     * Searches for flights based on the origin location.
     *
     * @param origin The origin location to search for flights.
     * @return A list of flights matching the specified origin.
     */

    public List<Flight> searchFlights(String origin) {
        final List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOrigin().equalsIgnoreCase(origin)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }

    /**
     * Finds a flight based on the flight number.
     *
     * @param flightNumber The flight number to search for.
     * @return The Flight object if found, or null if not found.
     */
    private Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    /**
     * Finds a passenger based on the passenger name.
     *
     * @param passengerName The passenger name to search for.
     * @return The Passenger object if found, or null if not found.
     */
    private Passenger findPassenger(String passengerName) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(passengerName)) {
                return passenger;
            }
        }
        return null;
    }
}
