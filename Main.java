import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a Flight Booking
 * System that allows users to search for flights,
 * book seats, and manage passenger information.
 * The system is implemented using classes
 * for flights, passengers, and bookings.
 * It provides an interactive menu for
 * users to interact with the system.
 *
 * @author Titwech Wal
 * @version 1.0
 * @since 2023-06-09
 */

public final class Main {

    /**
     * This is a private constructor used to satisfy the.
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */

    private Main() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(String[] args) {

        final BookingSystem bookingSystem = new BookingSystem();
        final Scanner scanner = new Scanner(System.in);

        // Load flights from a file
        try {
            final File file = new File("flights.txt");
            final Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                // While there is a next line
                // Split and add to array
                final String line = fileScanner.nextLine();
                final String[] flightData = line.split(", ");

                // If the array has four elements
                // Trim any excess whitespace
                if (flightData.length == 4) {
                    final String flightNumber = flightData[0].trim();
                    final String origin = flightData[1].trim();
                    final String destination = flightData[2].trim();
                    final int availableSeats =
                            Integer.parseInt(flightData[3].trim());

                    final Flight flight = new Flight(flightNumber,
                                                origin, destination,
                                                availableSeats);
                    bookingSystem.addFlight(flight);
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("File not found. Flights could not be loaded.");
        }

        // Print intro
        System.out.println("Welcome to Spark Airways, ");
        System.out.print("let's book your flight.");
        System.out.print("We only fly from New York, Montreal, ");
        System.out.print("Toronto, and Vancouver.");
        System.out.println();

        // New scanner to read from input
        final Scanner inputScanner = new Scanner(System.in);

        // Create a list for passengers
        final List<Passenger> passengers = new ArrayList<>();

        // Collect passenger information
        while (true) {
            System.out.print("\nWhat's your name (or 'stop' to finish): ");
            final String name = inputScanner.nextLine();

            if ("stop".equalsIgnoreCase(name)) {
                break;
            }

            System.out.print("What's your email? : ");
            final String email = inputScanner.nextLine();
            System.out.print("What's your phone number? : ");
            final String phoneNumber = inputScanner.nextLine();

            final Passenger passenger = new Passenger(name, email, phoneNumber);
            bookingSystem.addPassenger(passenger);
            passengers.add(passenger);
        }

        final Random random = new Random();

        // Display menu and process user choices
        while (true) {
            // Prints menu
            System.out.println("\nMenu:");
            System.out.println("1. Search for flights");
            System.out.println("2. Book a seat");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            final int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter origin: ");
                final String origin = scanner.nextLine();

                final List<Flight> matchingFlights =
                        bookingSystem.searchFlights(origin);

                // If user types a place not listed
                if (matchingFlights.isEmpty()) {
                    System.out.println("Sorry, we have no flights from here");

                } else {
                    // If they type a listed origin
                    System.out.println("Available flights:");
                    for (Flight flight : matchingFlights) {
                        System.out.println(flight.getFlightNumber() + " - "
                                            + flight.getOrigin() + " to "
                                                + flight.getDestination());
                    }
                }
            } else if (choice == 2) {

                System.out.print("Enter flight number (Ex. F001): ");
                final String flightNumber = scanner.nextLine();

                System.out.print("Enter passenger name: ");
                final String passengerName = scanner.nextLine();

                bookingSystem.bookSeat(flightNumber, passengerName);

            } else if (choice == 3) {
                System.out.println("Thanks for booking ");
                System.out.print("with Spark Airways. Goodbye!");

                // Save passenger information to a file
                // This will act as a receipt
                try {
                    final FileWriter writer = new FileWriter("passengers.txt");
                    final PrintWriter printWriter = new PrintWriter(writer);

                    for (Passenger passenger : passengers) {
                        printWriter.println("Name: " + passenger.getName());
                        printWriter.println("Email: " + passenger.getEmail());
                        printWriter.println("Phone Number: "
                                                + passenger.getPhoneNumber());
                        printWriter.println();
                    }

                    printWriter.close();

                } catch (IOException error) {
                    System.out.println("Passenger data could not be saved.");
                }

                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
