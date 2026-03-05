
public abstract class Reservation {

	protected String reservationId;
	protected String checkInDate; // dates are in this form dd/mm/yyyy
	protected String checkOutDate;
	protected int nights;
	protected Guest guest;
	protected Room room;

	public Reservation(String reservationId, String checkInDate, String checkOutDate, int nights, Guest guest,
			Room room) {
		this.reservationId = reservationId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.nights = nights;
		this.guest = guest;
		this.room = room;
	}

	public abstract double calculateCost();

	public String getSummary() {
		return "Reservation ID: " + reservationId + "\nGuest: " + guest.getName() + "\nRoom: " + room.getRoomNumber()
				+ "\nCheck-in: " + checkInDate + "\nCheck-out: " + checkOutDate + "\nNights: " + nights + "\nCost: "
				+ calculateCost();
	}

}
