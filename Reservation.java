
public abstract class Reservation {

	protected String reservationId; // it will be R + nextId +  guest name + guest room number
	private static int nextId = 1;
	protected String checkInDate; // dates are in this form dd/mm/yyyy
	protected String checkOutDate;
	protected int nights;
	protected Guest guest;
	protected Room room;

	public Reservation(String checkInDate, String checkOutDate, int nights, Guest guest,
			Room room) {
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.nights = nights;
		this.guest = guest;
		this.room = room;
		setReservationId();
	}
	
	// generating a custom ID
	protected void setReservationId() {
		reservationId = "R" + nextId++ + "_" + guest.getName() + room.getRoomNumber();
	}

	public abstract double calculateCost();

	public String getSummary() {
		return "Reservation ID: " + reservationId + "\nGuest: " + guest.getName() + "\nRoom: " + room.getRoomNumber()
				+ "\nCheck-in: " + checkInDate + "\nCheck-out: " + checkOutDate + "\nNights: " + nights + "\nCost: "
				+ calculateCost();
	}
	public String getReservationId () {
		return reservationId;
	}

}


