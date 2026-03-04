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
			System.out.println("Guest is here <> ");
			return true;
		}
		else
			System.out.println("Guset is not here >< ");
		return false;
	}

	// Hamed added because i need in Reservation class -- getSummary()
	public String getName() {
		return name;
	}
	

}

