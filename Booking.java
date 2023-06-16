import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
* Program finds a number using insertion sort.
*
* @author Titwech Wal
* @version 1.0
* @since   2023-06-09
*/

public class Booking {
    private Flight flight;
    private Passenger passenger;

    public Booking(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
    }

    public void displayBookingDetails() {
        System.out.println("Booking details:");
        System.out.println("Flight: " + flight.getFlightNumber());
        System.out.println("From: " + flight.getOrigin());
        System.out.println("To: " + flight.getDestination());
        System.out.println("Passenger: " + passenger.getName());
        System.out.println("Email: " + passenger.getEmail());
        System.out.println("Phone: " + passenger.getPhone());
    }
}