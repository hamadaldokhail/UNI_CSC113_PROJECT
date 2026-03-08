package Team;


public class Room implements Searchable {
	private int roomNumber;
	private String type;
	private double pricePerNight;
	private boolean available;
	Reservation reservation;
	
	public Room(int roomNumber, String type, double pricePerNight) {
		setRoomNumber(roomNumber); 
		this.type = type;
		setPricePerNight(pricePerNight);
		available = true;
	}
	
	
	public int getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(int roomNumber) {
			if (roomNumber > 0) 
				this.roomNumber = roomNumber;
			else
				System.out.println("Number can not be negative, try again ");
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getPricePerNight() {
		return pricePerNight;
	}


	public void setPricePerNight(double pricePerNight) {
		if (pricePerNight > 0)
		this.pricePerNight = pricePerNight;
		
		else
			System.out.println("price can not be negative, try again ");
	}


	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	public String reserve() {
	available = false;
		return "Room" + roomNumber + "is now reserved <> ";
	}
	public String release() {
		available = true;
		return "Room" + roomNumber + "is now release >< ";
	}
	@Override
	public boolean matchesKeyword(String keyword) {
			if (type.equalsIgnoreCase(keyword) ) {
				return true;
			}
		return false;
	}
	
	

}
