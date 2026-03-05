package Team;

public class Guest implements Searchable {
	private String guestId;
	private String name;
	private String phone;
	private String email;
	
	
	public Guest(String guestId, String name, String phone, String email) {
		this.guestId = guestId;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}


	@Override
	public boolean matchesKeyword(String keyword) {
		if ( guestId.equalsIgnoreCase(keyword) ||  name.equalsIgnoreCase(keyword) || phone.equalsIgnoreCase(keyword) || email.equalsIgnoreCase(keyword) ) {
			return true;
		}
		
		return false;
	}

	// Hamed added because i need in Reservation class -- getSummary()
	public String getName() {
		return name;
	}
	public String getGuestId(){
		return guestId;
	}

}



