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

			Date now = new Date();

			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: dates for updates must be future dates: ");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out must be after Ckeck-In date: ");
			} else {
				reservation.updateDates(checkIn, checkOut);

				System.out.println("Reservetion: " + reservation);
			}

		}
		sc.close();

	}

}
