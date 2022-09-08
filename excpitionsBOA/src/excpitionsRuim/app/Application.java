package excpitionsRuim.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import excpitionsRuim.app.entities.DomainException;
import excpitionsRuim.app.entities.Reservation;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();

			System.out.print("Date check-In (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());

			System.out.print("Date check-Out (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservetion: " + reservation);
			System.out.println("Entre date to update the reservation: ");
			System.out.print("Date check-In (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Date check-Out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);

			System.out.println("Reservetion: " + reservation);
		} catch (ParseException e) {
			System.out.println("invalid date formate");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();

	}

}
