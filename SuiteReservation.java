
public class SuiteReservation extends Reservation {

	protected boolean vipService;

	public SuiteReservation( String checkInDate, String checkOutDate, int nights, Guest guest,
			Room room, boolean vipService) {
		super(checkInDate, checkOutDate, nights, guest, room);
		this.vipService = vipService;
	}

	// used in the getSummary
	public String getVipService() {
		if (vipService)
			return "Yes";
		else
			return "No";
	}

	// the cost of vip service is 500
	@Override
	public double calculateCost() {
		if (vipService)
			return (room.getPricePerNight() * nights) + 500;
		else
			return (room.getPricePerNight() * nights);
	}

	@Override
	public String getSummary() {
		return "Reservation ID: " + reservationId + "\nReservation type: Suite" + "\nGuest: " + guest.getName()
				+ "\nRoom: " + room.getRoomNumber() + "\nCheck-in: " + checkInDate + "\nCheck-out: " + checkOutDate
				+ "\nNights: " + nights + "\nVIP service: " + getVipService() + "\nCost: " + calculateCost();
	}

}
