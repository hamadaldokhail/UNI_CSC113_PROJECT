
public class HotelHamed {

	private Reservation[] reservations;
	private int reservationCount;

	public HotelHamed() {
		reservations = new Reservation[50];
		reservationCount = 0;
	}

	// Adding a reservation
	public boolean addReservation(Reservation reservation) {
		// check if there is available capacity
		if (reservationCount == reservations.length) {
			System.out.println("No reservations available currently");
			return false;
		}
		// check if the reservation is already there
		for (int i = 0; i < reservationCount; i++) {
			if (reservations[i].reservationId.equals(reservation.reservationId)) {
				System.out.println("Its already reserved");
				return false;
			}
		}
		// then add the reservation in the first null value
		reservations[reservationCount] = reservation;
		System.out.println("Reservation added successfully!");
		// reserves the room
		reservations[reservationCount].room.reserve();
		reservationCount++;
		return true;
	}

	// Cancelling reservation
	public boolean cancelReservation(String reservationId) {
		int index = -1; // finding the index of the cancelled reservation
		for (int i = 0; i < reservationCount; i++) {
			if (reservations[i].reservationId.equals(reservationId)) {
				index = i;
			}
		}
		// if not found
		if (index == -1) {
			System.out.println("Reservation not found");
			return false;
		}
		// releases the room
		reservations[index].room.release();
		// cancelling by shifting
		for (int i = index; i < reservationCount - 1; i++) {
			reservations[i] = reservations[i + 1];
		}
		reservations[reservationCount - 1] = null;
		System.out.println("Reservation cancelled successfully!");
		reservationCount--;
		return true;
	}

	// searching reservations
	public Reservation searchReservation(String reservationId) {
		for (int i = 0; i < reservationCount; i++) {
			if (reservations[i].reservationId.equals(reservationId)) {
				System.out.println("Reservation found!");
				return reservations[i];
			}
		}
		System.out.println("Reservation not found!");
		return null;
	}

	// showing all reservations if there is any
	public void displayAllReservations() {
		if (reservationCount == 0) {
			System.out.println("there is no reservations yet!");
			return;
		}
		for (int i = 0; i < reservationCount; i++) {
			System.out.println(reservations[i].getSummary());
		}
	}

}
