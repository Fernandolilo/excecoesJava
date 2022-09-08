package excpitionsRuim.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import excpitionsRuim.app.entities.Reservation;

public class Application {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		int number = sc.nextInt();

		System.out.print("Date check-In (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Date check-Out (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		// o method after testa datas,
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out must be after Ckeck-In date: ");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservetion: " + reservation);
			System.out.println("Entre date to update the reservation: ");
			System.out.print("Date check-In (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Date check-Out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {

				System.out.println("Reservetion: " + reservation);
			}
		}
		sc.close();

	}

}
