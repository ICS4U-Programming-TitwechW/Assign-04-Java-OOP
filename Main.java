import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents a Flight Booking System that allows users to search for flights,
 * book seats, and manage passenger information.
 * The system is implemented using classes for flights, passengers, and bookings.
 * It provides an interactive menu for users to interact with the system.
 * 
 * @author Titwech Wal
 * @version 1.0
 * @since 2023-06-09
 */

public class Main {
    private List<Flight> flights;      // List to store flights
    private List<Passenger> passengers;      // List to store passengers
    private List<Booking> bookings;      // List to store bookings

    public Main() {
        flights = new ArrayList<>();      // Initialize the flights list
        passengers = new ArrayList<>();      // Initialize the passengers list
        bookings = new ArrayList<>();      // Initialize the bookings list
    }

    public void addFlight(Flight flight) {
        flights.add(flight);      // Add a flight to the flights list
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);      // Add a passenger to the passengers list
    }

    public void bookSeat(String flightNumber, String passengerName) {
        Flight flight = findFlight(flightNumber);      // Find the flight with the given flight number
        Passenger passenger = findPassenger(passengerName);      // Find the passenger with the given name

        if (flight == null) {
            System.out.println("Flight not found.");      // Display an error message if flight not found
            return;
        }

        if (passenger == null) {
            System.out.println("Passenger not found.");      // Display an error message if passenger not found
            return;
        }

        if (flight.getAvailableSeats() == 0) {
            System.out.println("No seats available for the selected flight.");      // Display an error message if no seats available
            return;
        }

        Booking booking = new Booking(flight, passenger);      // Create a new booking with the flight and passenger
        bookings.add(booking);      // Add the booking to the bookings list
        flight.bookSeats(1);      // Book a seat on the flight
        System.out.println("Booking successful!");      // Display a success message
    }

    private Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;      // Return the flight if the flight number matches
            }
        }
        return null;      // Return null if flight not found
    }

    private Passenger findPassenger(String passengerName) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(passengerName)) {
                return passenger;      // Return the passenger if the passenger name matches
            }
        }
        return null;      // Return null if passenger not found
    }

    public static void main(String[] args) {
        Main bookingSystem = new Main();      // Create an instance of the FlightBookingSystem
        Scanner scanner = new Scanner(System.in);      // Create a Scanner object to read user input


        // Read flights from file and add them to the system
        try {
            File file = new File("flights.txt");// Replace "flights.txt" with the actual file name and path
            Scanner fileScanner = new Scanner(file);
            

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] flightData = line.split(",");

                if (flightData.length == 4) {
                    String flightNumber = flightData[0].trim();
                    String origin = flightData[1].trim();
                    String destination = flightData[2].trim();
                    int availableSeats = Integer.parseInt(flightData[3].trim());

                    Flight flight = new Flight(flightNumber, origin, destination, availableSeats);
                    bookingSystem.addFlight(flight);
                }
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Flights could not be loaded.");
            //return; // Exit the program if the flights cannot be loaded
        }


        // Interaction with the user
        System.out.println("Welcome to the Flight Booking System!");

        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter passenger name (or 'stop' to finish): ");
            String name = inputScanner.nextLine();

            if (name.equalsIgnoreCase("stop")) {
                break;
            }

            System.out.print("Enter email: ");
            String email = inputScanner.nextLine();
            System.out.print("Enter phone number: ");
            String phoneNumber = inputScanner.nextLine();

            // Create a Passenger object with the entered information
            Passenger passenger = new Passenger(name, email, phoneNumber);
            // Add the passenger to the booking system
            bookingSystem.addPassenger(passenger);

        }
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Search for flights");
            System.out.println("2. Book a seat");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                System.out.print("Enter origin: ");
                String origin = scanner.nextLine();
                System.out.print("Enter destination: ");
                String destination = scanner.nextLine();

                // Perform flight search based on origin and destination
                // Display the available flights to the user
                // Implement the search logic according to your requirements

            } else if (choice == 2) {
                System.out.print("Enter flight number: ");
                String flightNumber = scanner.nextLine();
                System.out.print("Enter passenger name: ");
                String passengerName = scanner.nextLine();

                bookingSystem.bookSeat(flightNumber, passengerName);

            } else if (choice == 3) {
                System.out.println("Thank you for using the Flight Booking System. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        inputScanner.close();
        scanner.close();
    }
}