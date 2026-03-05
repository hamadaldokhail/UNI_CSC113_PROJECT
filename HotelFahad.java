package Team;

public class HotelFahad {
	
	private Room[] rooms;
	private Guest[] guests;
	private int roomCount;
	private int guestCount;
	
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
			if (rooms[i].matchesKeyword(String.valueOf(roomNumber))) {
				System.out.println("The room is found ");
				return rooms[i];
			}
		}
		System.out.println("Sorry room is not found ");
		return null;
	}
	
}



