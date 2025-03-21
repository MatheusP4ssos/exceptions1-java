package application;

import model.entities.Reservation;
import model.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Room Number: ");
            int roomNumber = sc.nextInt();

            System.out.println("Check-in date (dd/MM/yyyy)");
            Date checkIn = sdf.parse(sc.next());

            System.out.println("Check-out date (dd/MM/yyyy) ");
            Date checkout = sdf.parse(sc.next());


            Reservation reservation = new Reservation(roomNumber, checkIn, checkout);
            System.out.println("\nReservation details:");
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation");
            System.out.println("Check-in date (dd/MM/yyyy) ");
            checkIn = sdf.parse(sc.next());

            System.out.println("Check-out date (dd/MM/yyyy) ");
            checkout = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkout);
            System.out.println("Reservation: " + reservation);
            System.out.println();
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error: ");
        }
        sc.close();
    }
}