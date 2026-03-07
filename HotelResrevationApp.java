import java.util.Scanner;


public class HotelResrevationApp {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	int choose1,choose2,choose3;
	 int roomNumber;
	String checkInDate;
	String checkOutDate;
	int nights;
	Guest guest;
	boolean isbreakfastIncluded;
	boolean vipService;
	Hotel hotel = new Hotel();
    StandardReservation sr = null;
	SuiteReservation sur = null;

	do {
		System.out.println("Welcome to Hotel:\nPlease Choose sign in or exit: \n1- sign as guest \n2- exit");
		choose1 = input.nextInt();
		
		switch(choose1) {
		
		case 1 :
			System.out.println("What is your name: ");
			String name = input.next();
			System.out.println("what is your id: ");
			String guestId = input.next();
			System.out.println("what is your phone number : ");
			String phone = input.next();
			System.out.println("what is your email : ");
			String email = input.next();

		    guest = new Guest( guestId,  name,  phone,  email);
		    hotel.addGuest(guest);

			do {
				System.out.println("choose one of these services: \n1-Reservation a room \n2-Cancel reservation \n3-search reservation \n4- disaplay reservation\n5- count all free room \n6-exit");

			choose2 = input.nextInt();
			switch(choose2) {
			case 1 :
				System.out.println("Choose a level you want: \n 1-Standard \n 2- Suite");
				choose3 = input.nextInt();
				System.out.println("choose a day for checkin: ");
				  checkInDate = input.next();
					System.out.println("choose a day for checkout: ");
					 checkOutDate = input.next();
					System.out.println("Enter number of nights: ");
					 nights = input.nextInt();
					 while(true) {
						 
						System.out.println("Enter room number: ");
						 roomNumber = input.nextInt();
						if(hotel.searchRoom(roomNumber) != null) {
							System.out.println("the is room already taken please choose another room");
						continue;}
							break;
					 }
						
			if(choose3 == 1) {

				
					System.out.println("do you want breakfast? ");
					String breakfast = input.next();   isbreakfastIncluded=breakfast.equalsIgnoreCase("yes") ;
					
						Room room = new Room(roomNumber , "Standard " , 200 );
						room.reserve();
					   sr = new StandardReservation(checkInDate, checkOutDate, nights, guest, room, isbreakfastIncluded); 
					   hotel.addReservation(sr);
					   hotel.addRoom(room);
						

				System.out.println("you reservation a standard room succseffuly. \n" + sr.getSummary());
			}
			else if (choose3 == 2) {
				
					System.out.println("do you want VIP Service ");
					String VIP = input.next(); 	vipService = VIP.equalsIgnoreCase("yes");

					Room room = new Room(roomNumber , "Suite " , 500 );
					room.reserve();
				    sur = new SuiteReservation( checkInDate,checkOutDate, nights, guest, room, vipService);
				    hotel.addReservation(sur);
					hotel.addRoom(room);

					
					System.out.println("you reservation a Suite room succseffuly \n the summary: \n " + sur.getSummary()) ;
			}
			else
				System.out.println("Choose a correct number");

			break; 
			
				case 2 : 
					
					if(sur != null) {
					hotel.cancelReservation(sur.getReservationId());
				    sur = null;
				    
					}
				    else if (sr!=null) {
				    	hotel.cancelReservation(sr.getReservationId());
				    	sr = null;
				    }
				    else
				    	System.out.println("Reserve a room first! ");
					break;
					
					
				case 3 : 
					System.out.println("Enter your reservation ID: ");
					String idsearch = input.next();
					hotel.searchReservation(idsearch);
					
					break;
					
				case 4 :
					
					hotel.displayAllReservations();
					
					break;
					
				case 5:
				
					System.out.println(100 - hotel.countAvailableRoomRecuresive(0));
					break;
				
				case 6 :
					System.out.println("good bye");
					break;
					
				default: 
					System.out.println("Choose a correct number");

			}// default for switch num2
		} while(choose2 != 6);
		
		case 2 :
			
			System.out.println("good bye");
			
			break;
		
		default :
			System.out.println("Choose a correct number");
		} 
} while(choose1 != 2);
	
}
}
