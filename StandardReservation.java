
public class StandardReservation extends Reservation {

	private boolean breakfastIncluded;

	public StandardReservation(String reservationId, String checkInDate, String checkOutDate, int nights, Guest guest,
			Room room, boolean breakfastIncluded) {
		super(reservationId, checkInDate, checkOutDate, nights, guest, room);
		this.breakfastIncluded = breakfastIncluded;
	}

	// used in the getsummary
	public String getBreakfastIncluded() {
		if (breakfastIncluded)
			return "Yes";
		else
			return "No";
	}

	@Override
	public double calculateCost() {
		if (breakfastIncluded)
			return (room.getPricePerNight() * nights) + 100;
		else
			return (room.getPricePerNight() * nights);
	}

	@Override
	public String getSummary() {
		return "Reservation ID: " + reservationId + "\nReservation type: Standard" + "\nGuest: " + guest.getName()
				+ "\nRoom: " + room.getRoomNumber() + "\nCheck-in: " + checkInDate + "\nCheck-out: " + checkOutDate
				+ "\nNights: " + nights + "\nBreakfast included: " + getBreakfastIncluded() + "\nCost: "
				+ calculateCost();
	}

}
