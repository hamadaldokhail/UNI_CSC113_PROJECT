
public class Hotel {

	private String hotelName;
	private String address;
	private Room[] rooms;
	private Guest[] guests;
	private Reservation[] reservations;
	private int roomCount;
	private int guestCount;
	private int reservationCount;

	public Hotel() {
		this.rooms = new Room[100];
		this.guests = new Guest[100];
		this.reservations = new Reservation[100];
		roomCount = 0;
		guestCount = 0;
		reservationCount = 0;
	}

	public int getRoomCount() {

		return roomCount;
	}

	// adding room
	public boolean addRoom(Room room) {
		if (roomCount < rooms.length) {
			rooms[roomCount] = room;
			roomCount++;
			System.out.println("Room has been added successfully!");
			return true;
		}

		System.out.println("No rooms available currently!");
		return false;

	}

	// removing room
	public boolean removeRoom(int roomNumber) {
		for (int i = 0; i < roomCount; i++) {
			if (rooms[i].getRoomNumber() == roomNumber) {
				for (int j = i; j < roomCount - 1; j++) {
					rooms[j] = rooms[j + 1];
				}
				rooms[roomCount - 1] = null;
				roomCount--;
				System.out.println("Room has been removed successfully!");
				return true;
			}
		}
		System.out.println("Room not found!");
		return false;

	}

	// searching for a room
	public Room searchRoom(int roomNumber) {
		for (int i = 0; i < roomCount; i++) {
			if (rooms[i] != null && rooms[i].getRoomNumber() == roomNumber) {
				return rooms[i];
			}
		}
		return null;
	}

	// adding guest
	public boolean addGuest(Guest guest) {

		if (guestCount < guests.length) {
			guests[guestCount] = guest;
			guestCount++;
			System.out.println("Guest has been added successfully!");
			return true;
		} else
			System.out.println("Sorry we do not have enough spaces!");

		return false;

	}

	// removing guests
	public boolean removeGuest(String guestId) {
		for (int i = 0; i < guestCount; i++) {
			if (guests[i].getGuestId().equalsIgnoreCase(guestId)) {
				for (int j = i; j < guestCount - 1; j++) {
					guests[j] = guests[j + 1];
				}
				guests[guestCount - 1] = null;
				guestCount--;
				System.out.println("Guest has been removed successfully!");
				return true;
			}
		}
		System.out.println("Guest not found!");
		return false;
	}

	// searching for a guest
	public Guest searchGuest(String guestId) {
		for (int i = 0; i < guestCount; i++) {
			if (guests[i].matchesKeyword(guestId)) {
				System.out.println("Guest found!");
				return guests[i];
			}
		}
		System.out.println("Guest is not found!");
		return null;
	}

	// Adding a reservation
	public boolean addReservation(Reservation reservation) {
		// check if there is available capacity
		if (reservationCount == reservations.length) {
			System.out.println("No reservations available currently!");
			return false;
		}
		// check if the reservation is already there
		for (int i = 0; i < reservationCount; i++) {
			if (reservations[i].reservationId.equals(reservation.reservationId)) {
				System.out.println("Its already reserved!");
				return false;
			}
		}
		// then add the reservation in the first null value
		reservations[reservationCount] = reservation;
		System.out.println("Reservation has been added successfully!");
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
			System.out.println("Reservation not found!");
			return false;
		}

		// cancelling by shifting
		for (int i = index; i < reservationCount - 1; i++) {
			reservations[i] = reservations[i + 1];
		}
		reservations[reservationCount - 1] = null;
		System.out.println("Reservation has been cancelled successfully!");
		reservationCount--;

		return true;
	}

	// searching reservations
	public Reservation searchReservation(String reservationId) {
		for (int i = 0; i < reservationCount; i++) {
			if (reservations[i].reservationId.equals(reservationId)) {
				return reservations[i];
			}
		}
		System.out.println("Reservation not found!");
		return null;
	}

	// count available rooms
	public int countAvailableRoomRecuresive(int index) {
		
		if (index >= reservations.length) {

			return 0;
		}

		if (reservations[index] == null) {
			return 1 + countAvailableRoomRecuresive(index + 1);
		}

		else {
			return countAvailableRoomRecuresive(index + 1);
		}

	}

	// showing all reservations if there is any
	public void displayAllReservations() {
		if (reservationCount == 0) {
			System.out.println("There is no reservations yet!");
			return;
		}
		for (int i = 0; i < reservationCount; i++) {
			System.out.println(reservations[i].getSummary());
			if (reservationCount > 1 && i < reservationCount - 1)
				System.out.println();
		}
	}
}
