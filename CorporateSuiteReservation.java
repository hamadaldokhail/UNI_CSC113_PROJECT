
public class CorporateSuiteReservation extends SuiteReservation {

	private String companyName;
	private double corporateDiscount;

	public CorporateSuiteReservation(String reservationId, String checkInDate, String checkOutDate, int nights,
			Guest guest, Room room, boolean vipService, String companyName, double corporateDiscount) {
		super(reservationId, checkInDate, checkOutDate, nights, guest, room, vipService);
		this.companyName = companyName;
		this.corporateDiscount = corporateDiscount;
	}

	@Override
	public double calculateCost() {
		if (vipService)
			return ((room.getPricePerNight() * nights) + 500) * ((100 - corporateDiscount) / 100);
		else
			return (room.getPricePerNight() * nights) * ((100 - corporateDiscount) / 100);
	}

	@Override
	public String getSummary() {
		return "Reservation ID: " + reservationId + "\nReservation type: Corporate Suite" + "\nGuest: " + guest.getName()
				+ "\nRoom: " + room.getRoomNumber() + "\nCheck-in: " + checkInDate + "\nCheck-out: " + checkOutDate
				+ "\nNights: " + nights + "\nVIP service: " + getVipService() + "\ncompanyName: " + companyName
				+ "\nCorporate discount: " + corporateDiscount + "\nCost: " + calculateCost();
	}

}
