import java.util.Scanner;

public class HotelResrevationApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Hotel hotel = new Hotel();
		Room room1 = new Room(100,"Standard" , 200); hotel.addRoom(room1);
		Room room2 = new Room(101,"Standard" , 200); hotel.addRoom(room2);
		Room room3 = new Room(102,"Standard" , 200); hotel.addRoom(room3);
		Room room4 = new Room(103,"Standard" , 200); hotel.addRoom(room4);
		Room room5 = new Room(104,"Standard" , 200); hotel.addRoom(room5);
		Room room6 = new Room(100,"Suite" , 500); 	 hotel.addRoom(room6);
		Room room7 = new Room(101,"Suite" , 500);	 hotel.addRoom(room7);
		Room room8 = new Room(102,"Suite" , 500); 	 hotel.addRoom(room8);
		Room room9 = new Room(103,"Suite" , 500); 	 hotel.addRoom(room9);
		Room room10 = new Room(104,"Suite" , 500); 	 hotel.addRoom(room10);

		
		
		
		
		
		

		int choose1, choose2, choose3 , nights , roomNumber;
		String checkInDate , guestId , checkOutDate;
		Guest guest;
		boolean isbreakfastIncluded , vipService;
		StandardReservation sr = null;
		CorporateSuiteReservation csr = null;
		
		
		System.out.println("---------------------");
		System.out.println("Welcome to the Hotel");
		do {
			System.out.println("---------------------");
			System.out.println("Kindly sign in or exit (enter a number): \n1- sign in \n2- exit");
			choose1 = input.nextInt();

			switch (choose1) {

			case 1:
				do {
					System.out.println("---------------------");
					System.out.println(
							"choose one of these services (enter a number):\n \n1- Reserve a room \n2- Cancel a reservation \n3- Search a reservation \n4- Disaplay all reservations \n5- Display available rooms \n6- Sign Out");

					choose2 = input.nextInt();
					System.out.println("---------------------");
					switch (choose2) {
					case 1:
						System.out.println("---------------------");
						System.out.print("What is your name: ");
						String name = input.next();
						System.out.print("what is your phone number: ");
						String phone = input.next();
						System.out.print("what is your email: ");
						String email = input.next();
						while(true) {
						System.out.print("what is your id: ");
						 guestId = input.next();
							Guest existingGuest = hotel.searchGuest(guestId);

						if(existingGuest== null ) {
						    guest = new Guest(guestId , name , phone , email);
							hotel.addGuest(guest);
							
						}
						else {
							guest = existingGuest;
							
						}
						break;
						}
						
						System.out.println("---------------------");


						System.out.println("What would you like to reserve (enter a number): \n1- Standard \n2- Suite");
						choose3 = input.nextInt();
						System.out.println("---------------------");
						System.out.println("When would you like to check-in: ");
						checkInDate = input.next();
						System.out.println("---------------------");
						System.out.println("When would you like to check-out: ");
						checkOutDate = input.next();
						System.out.println("---------------------");
						System.out.println("So how many nights you would like to have: ");
						nights = input.nextInt();
						System.out.println("---------------------");
						
						if (choose3 == 1) {

							System.out.println("do you want breakfast? ");
							String breakfast = input.next();
							isbreakfastIncluded = breakfast.equalsIgnoreCase("yes");
							System.out.println("---------------------");
							
							
							if (room1.isAvailable()) {
								 sr = new StandardReservation( checkInDate,  checkOutDate,  nights,  guest,  room1,  isbreakfastIncluded);
								room1.reserve();
								hotel.addReservation(sr);
								System.out.println("Reservation details: \n \n" + sr.getSummary());

							}
							else if(room2.isAvailable()) {
								 sr = new StandardReservation( checkInDate,  checkOutDate,  nights,  guest,  room2,  isbreakfastIncluded);

								room2.reserve();
								hotel.addReservation(sr);

								System.out.println("Reservation details: \n \n" + sr.getSummary());

							}
							else if(room3.isAvailable()) {		
								 sr = new StandardReservation( checkInDate,  checkOutDate,  nights,  guest,  room3,  isbreakfastIncluded);

								room3.reserve();
								hotel.addReservation(sr);

								System.out.println("Reservation details: \n \n" + sr.getSummary());

							}
							else if(room4.isAvailable()) {	
								 sr = new StandardReservation( checkInDate,  checkOutDate,  nights,  guest,  room4,  isbreakfastIncluded);

								room4.reserve();
								hotel.addReservation(sr);

								System.out.println("Reservation details: \n \n" + sr.getSummary());

							}
							else if(room5.isAvailable()) {
								room5.reserve();

								 sr = new StandardReservation( checkInDate,  checkOutDate,  nights,  guest,  room5,  isbreakfastIncluded);
									hotel.addReservation(sr);

									System.out.println("Reservation details: \n \n" + sr.getSummary());

							}
							else {
								
								 sr = null;

								System.out.println("there is no standard room available ");
							}
							System.out.println("---------------------");

						} else if (choose3 == 2) {
							System.out.println("what is your company name: ");
							String companyName = input.next();
							System.out.println("do you want VIP Service ");
							String VIP = input.next();
							vipService = VIP.equalsIgnoreCase("yes");
							System.out.println("---------------------");

							
							
							if(room6.isAvailable()) {
								 csr = new CorporateSuiteReservation( checkInDate,  checkOutDate,  nights,  guest,  room6,  vipService, companyName,  15);
								room6.reserve();
								hotel.addReservation(csr);

								System.out.println("Reservation details: \n \n" + csr.getSummary());

							}
							else if(room7.isAvailable()) {
								 csr = new CorporateSuiteReservation( checkInDate,  checkOutDate,  nights,  guest,  room7,  vipService, companyName,  15);

								room7.reserve();
								hotel.addReservation(csr);

								System.out.println("Reservation details: \n \n" + csr.getSummary());

							}
							else if(room8.isAvailable() ){
								 csr = new CorporateSuiteReservation( checkInDate,  checkOutDate,  nights,  guest,  room8,  vipService, companyName,  15);

								room8.reserve();
								hotel.addReservation(csr);

								System.out.println("Reservation details: \n \n" + csr.getSummary());

							}
							else if(room9.isAvailable()) {
								 csr = new CorporateSuiteReservation( checkInDate,  checkOutDate,  nights,  guest,  room9,  vipService, companyName,  15);

								room9.reserve();
								hotel.addReservation(csr);

								System.out.println("Reservation details: \n \n" + csr.getSummary());

							}
							else if(room10.isAvailable()) {
								 csr = new CorporateSuiteReservation( checkInDate,  checkOutDate,  nights,  guest,  room10,  vipService, companyName,  15);

								room3.reserve();
								hotel.addReservation(csr);

								System.out.println("Reservation details: \n \n" + csr.getSummary());

							}
							else System.out.println("there is no suite room available");
							System.out.println("---------------------");

						}	
					 else
							System.out.println("Choose a correct number");
						break;

					case 2:
						System.out.println("Enter your reservation ID: ");
						String ReservationID=input.next();
						
						Reservation foundReservation = hotel.searchReservation(ReservationID);
						
						if(foundReservation != null) {
							Room room = foundReservation.getRoom();
							if(room != null) {
								room.release();
							}
							hotel.cancelReservation(ReservationID);
							guest = null;
						}
						else
							System.out.println("there is no resevation yet! ");

						break;

					case 3:
						System.out.println("Enter your reservation ID: ");
						String idsearch = input.next();
						if (null != hotel.searchReservation(idsearch)) {
							System.out.println("Reservation details:  \n");
							System.out.println(hotel.searchReservation(idsearch).getSummary());
						}
						

						break;

					case 4:

						hotel.displayAllReservations();

						break;

					case 5:
						System.out.println();
						System.out.println( hotel.countAvailableRoomRecuresive(0));
						break;

					case 6:
						 sr = null;
				         sur = null;
						 csr = null;
						
						System.out.println("Signing out...");
						break;

					default:
						System.out.println("Choose a correct number");

					}// default for switch num2
				} while (choose2 != 6);
				break;
			case 2:
				System.out.println("---------------------");
				System.out.println("Good bye");
				break;

			default:
				System.out.println("Choose a correct number");
			}
		} while (choose1 != 2);
	}
}
