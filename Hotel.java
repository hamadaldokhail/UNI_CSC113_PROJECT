
public class Hotel {

	
	private String hotelName;
	private String address;
	private Reservation[] reservations;
	private int reservationCount;
	private Room[] rooms;
	private Guest[] guests;
	private int roomCount;
	private int guestCount;

	
	public Hotel() {
		this.rooms = new Room[100];
		this.guests= new Guest[100];
		this.reservations = new Reservation[100];
		reservationCount = 0;
		guestCount = 0;
	}
	public int getRoomCount() {
		
		return roomCount;
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

	public boolean addGuest(Guest guest)  {
		
		if (guestCount < guests.length) {
			guests[guestCount] = guest;
			guestCount++;
			System.out.println("Guest add successfully ");
			return true;
		}
		else
			System.out.println("Sorry we do not have enough spaces ");
			
		return false;
		
	}
	
	public boolean removeGuest(String guestId){
		for (int i = 0; i < guestCount; i++) {
			if (guests[i].getGuestId().equalsIgnoreCase(guestId)) {
				for (int j = i; j < guestCount - 1; j++) {
					guests[j] = guests[j + 1];
				}
				guests[guestCount - 1] = null;
				guestCount--;
				return true;
			}
		}

		return false;
	}
	
	
	public Guest searchGuest(String guestId) {
		for (int i = 0; i < guestCount; i++) {
			if (guests[i].matchesKeyword(guestId)) {
				System.out.println("The guest is found ");
				return guests[i];
			}
		}
		System.out.println("Sorry not found ");
		return null;
	}
	public boolean addRoom(Room room) {
		if (roomCount < rooms.length) {
			rooms[roomCount] = room;
			roomCount++;
			System.out.println("Room add successfully ");
			return true;
		}

		System.out.println("Sorry Rooms are full ");
		return false;

	}
	public boolean removeRoom(int roomNumber){
		for (int i = 0; i < roomCount; i++) {
			if (rooms[i].getRoomNumber() == roomNumber) {
				for (int j = i; j < roomCount - 1; j++) {
					rooms[j] = rooms[j + 1];
				}
				rooms[roomCount - 1] = null;
				roomCount--;
				return true;
			}
		}

		return false;

	}
	public Room searchRoom(int roomNumber){
		for (int i = 0; i < roomCount; i++) {
			if (rooms[i]!=null && rooms[i].getRoomNumber()==roomNumber) {
				return rooms[i];
			}
		}
		return null;
	}
	
	
	
	public int countAvailableRoomRecuresive(int index) {
		
		if(index>=roomCount ) {
			
		return index;
		}
		
		if(rooms[index]==null ) {
          return 1 + countAvailableRoomRecuresive(index+1);	}
	
		else {
			return countAvailableRoomRecuresive(index+1);}
		
		
	}
	
	
	
	
	
	
	
	
}
