import java.util.Scanner;

public class HotelResrevationApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int choose1, choose2, choose3 , nights , roomNumber;
		String checkInDate , guestId , checkOutDate;
		Guest guest;
		boolean isbreakfastIncluded , vipService;
		Hotel hotel = new Hotel();
		StandardReservation sr = null;
		SuiteReservation sur = null;
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
							"choose one of these services (enter a number):\n \n1- Reserve a room \n2- Cancel a reservation \n3- Search a reservation \n4- Disaplay all reservations \n5- Available rooms amount \n6- Sign Out");

					choose2 = input.nextInt();
					System.out.println("---------------------");
					switch (choose2) {
					case 1:
						System.out.print("What is your name: ");
						String name = input.next();
						
						while(true) {
						System.out.print("what is your id: ");
						 guestId = input.next();
						if(hotel.searchGuest(guestId)== null ) {
							break;
						}
						else {
							System.out.println("The ID is used before, unfortunately you cannot have more than one reservation, enter a diffrent Id please");
							
						}
						}
						System.out.print("what is your phone number: ");
						String phone = input.next();
						System.out.print("what is your email: ");
						String email = input.next();
					    guest = new Guest(guestId , name , phone , email);
						hotel.addGuest(guest);
						System.out.println("---------------------");


						System.out.println("What would you like to reserve (enter a number): \n1- Standard \n2- Suite \n3- Corporate Suite");
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
						while (true) {

							System.out.println("Enter room number: ");
							roomNumber = input.nextInt();
							System.out.println("---------------------");
							if (hotel.searchRoom(roomNumber) != null) {
								System.out.println("The room is already taken please choose another room");
								continue;
							}
							break;
						}

						if (choose3 == 1) {

							System.out.println("do you want breakfast? ");
							String breakfast = input.next();
							isbreakfastIncluded = breakfast.equalsIgnoreCase("yes");
							System.out.println("---------------------");

							Room room = new Room(roomNumber, "Standard ", 200);
							sr = new StandardReservation(checkInDate, checkOutDate, nights, guest, room,
									isbreakfastIncluded);

							hotel.addRoom(room);
							System.out.println("---------------------");
							hotel.addReservation(sr);
							System.out.println("---------------------");

							System.out.println("Reservation details: \n \n" + sr.getSummary());
						} else if (choose3 == 2) {

							System.out.println("Do you want VIP Service ");
							String VIP = input.next();
							vipService = VIP.equalsIgnoreCase("yes");
							System.out.println("---------------------");

							Room room = new Room(roomNumber, "Suite ", 500);
							sur = new SuiteReservation(checkInDate, checkOutDate, nights, guest, room, vipService);
							
							hotel.addRoom(room);
							System.out.println("---------------------");
							hotel.addReservation(sur);
							System.out.println("---------------------");

							System.out.println("Reservation details: \n \n" + sur.getSummary());
						}
						else if(choose3 == 3) {
							
							System.out.println("What is your company name: ");
							String companyName = input.next();
							while(true) {
							System.out.println("What type do you want (Standard \\ Suite) : ");
							String type = input.next();
							System.out.println("---------------------");
							
							
							if(type.equalsIgnoreCase("standard")) {
								vipService = false;
								double corporateDiscount = 15;
								Room room = new Room(roomNumber , "standard"  , 200 );
								hotel.addRoom(room);
								System.out.println("---------------------");

								csr = new CorporateSuiteReservation( checkInDate,  checkOutDate,  nights,
										 guest,  room,  vipService,  companyName,  corporateDiscount);

								hotel.addReservation(csr);
								System.out.println("---------------------");
								System.out.println("Reservation details: \n \n" + csr.getSummary());

								
								break;
							}
							else if(type.equalsIgnoreCase("suite")){
								vipService = true;
								double corporateDiscount = 20;

								Room room = new Room(roomNumber , "Suite"  , 500  );
								hotel.addRoom(room);
								System.out.println("---------------------");
								csr = new CorporateSuiteReservation( checkInDate,  checkOutDate,  nights,
										 guest,  room,  vipService,  companyName,  corporateDiscount);	
								hotel.addReservation(csr);
								System.out.println("---------------------");
								System.out.println("Reservation details: \n \n" + csr.getSummary());

								break;
							}
							else {
								System.out.println("Enter (Standard) or (Suite) only! ");
								System.out.println("---------------------");

								continue;
							}
						}
						}
						
							
					 else
							System.out.println("Choose a correct number");

						break;

					case 2:
						System.out.println("Enter your reservation ID: ");
						String reservatioId = input.next();
						hotel.cancelReservation(reservatioId);
						break;

					case 3:
						System.out.println("Enter your reservation ID: ");
						String idsearch = input.next();
						if (null != hotel.searchReservation(idsearch)) {
							System.out.println("Reservation details:  \n");
							System.out.println(hotel.searchReservation(idsearch).getSummary());
						}
						;

						break;

					case 4:

						hotel.displayAllReservations();

						break;

					case 5:
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
