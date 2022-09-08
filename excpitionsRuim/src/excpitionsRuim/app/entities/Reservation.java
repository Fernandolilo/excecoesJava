package excpitionsRuim.app.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		// pegando mili-segundo para tranformar em data!
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	// update dates
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: dates for updates must be future dates: ";
		}
		if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out must be after Ckeck-In date: ";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-In: " + sdf.format(checkIn) + ", check-Out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights!";

	}

}
