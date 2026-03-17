import java.util.Scanner;

public class HotelReservationApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Hotel hotel = new Hotel();
		Room room1 = new Room(100, "Standard", 200);
		hotel.addRoom(room1);
		Room room2 = new Room(101, "Standard", 200);
		hotel.addRoom(room2);
		Room room3 = new Room(102, "Standard", 200);
		hotel.addRoom(room3);
		Room room4 = new Room(103, "Standard", 200);
		hotel.addRoom(room4);
		Room room5 = new Room(104, "Standard", 200);
		hotel.addRoom(room5);
		Room room6 = new Room(200, "Suite", 500);
		hotel.addRoom(room6);
		Room room7 = new Room(201, "Suite", 500);
		hotel.addRoom(room7);
		Room room8 = new Room(202, "Suite", 500);
		hotel.addRoom(room8);
		Room room9 = new Room(203, "Suite", 500);
		hotel.addRoom(room9);
		Room room10 = new Room(204, "Suite", 500);
		hotel.addRoom(room10);

		int choose1, choose2, choose3, nights, roomNumber;
		String checkInDate, guestId, checkOutDate;
		Guest guest;
		boolean isbreakfastIncluded, vipService;
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

						System.out.print("What is your id: ");
						guestId = input.next();

						// check if the user is already registered via ID
						if (hotel.searchGuest(guestId) == null) {
							System.out.print("What is your name: ");
							String name = input.next();
							System.out.print("what is your phone number: ");
							String phone = input.next();
							System.out.print("what is your email: ");
							String email = input.next();
							System.out.println("---------------------");
							guest = new Guest(guestId, name, phone, email);
							hotel.addGuest(guest);
							System.out.println("---------------------");

						} else {
							System.out.println(
									"This ID is registered in the system, so we will use the same information to create this reservation");
							guest = hotel.searchGuest(guestId);

						}

						System.out.println(
								"What would you like to reserve (enter a number): \n1- Standard \n2- Suite \n3- Corporate Suite");
						choose3 = input.nextInt();

						// if the number is wrong
						if (choose3 < 1 || choose3 > 3) {
							System.out.println("---------------------");
							System.out.println("Choose a correct number, you will be returned to the main menu,,,");
							break;
						}

						// setting room type based on the type of the reservation (using that in setting
						// the room number)
						String roomType;
						if (choose3 == 1)
							roomType = "Standard";
						else
							roomType = "Suite";
						System.out.println("---------------------");
						System.out.print("When would you like to check-in: ");
						checkInDate = input.next();
						System.out.println("---------------------");
						System.out.print("When would you like to check-out: ");
						checkOutDate = input.next();
						System.out.println("---------------------");
						System.out.print("So how many nights you would like to have: ");
						nights = input.nextInt();
						System.out.println("---------------------");

						// check the room availability & and if the type of the room matches the
						// reservation type, and check if the room number is valid
						while (true) {

							System.out.print("Enter room number: ");
							roomNumber = input.nextInt();
							System.out.println("---------------------");
							if ((roomNumber < 100 || roomNumber > 104) && (roomNumber < 200 || roomNumber > 204)) {
								System.out.println("Please choose a valid room number!");
								System.out.println("---------------------");
								continue;
							}
							if (hotel.searchRoom(roomNumber).getType() != roomType) {
								System.out.println("Please choose a room that matches the reservation type!");
								System.out.println("---------------------");
								continue;
							}
							if (!hotel.searchRoom(roomNumber).isAvailable()) {
								System.out.println("This room is not available currently please choose another room");
								System.out.println("---------------------");
								continue;
							}
							break;
						}

						if (choose3 == 1) {

							System.out.print("Do you want breakfast: ");
							String breakfast = input.next();
							isbreakfastIncluded = breakfast.equalsIgnoreCase("yes");
							System.out.println("---------------------");
							Room room = hotel.searchRoom(roomNumber);
							sr = new StandardReservation(checkInDate, checkOutDate, nights, guest, room,
									isbreakfastIncluded);
							hotel.addReservation(sr);
							System.out.println("---------------------");

							System.out.println("Reservation details: \n \n" + sr.getSummary());
						} else if (choose3 == 2) {

							System.out.print("Do you want VIP Service: ");
							String VIP = input.next();
							vipService = VIP.equalsIgnoreCase("yes");
							System.out.println("---------------------");
							Room room = hotel.searchRoom(roomNumber);
							sur = new SuiteReservation(checkInDate, checkOutDate, nights, guest, room, vipService);
							hotel.addReservation(sur);
							System.out.println("---------------------");
							System.out.println("Reservation details: \n \n" + sur.getSummary());
						} else {

							System.out.print("Do you want VIP Service: ");
							String VIP = input.next();
							vipService = VIP.equalsIgnoreCase("yes");
							System.out.println("---------------------");
							System.out.print("What is your company name: ");
							String companyName = input.next();

							double corporateDiscount = 20;
							Room room = hotel.searchRoom(roomNumber);

							System.out.println("---------------------");
							csr = new CorporateSuiteReservation(checkInDate, checkOutDate, nights, guest, room,
									vipService, companyName, corporateDiscount);
							hotel.addReservation(csr);
							System.out.println("---------------------");
							System.out.println("Reservation details: \n \n" + csr.getSummary());

						}
						break;

					case 2:
						System.out.print("Enter the reservation ID: ");
						String reservatioId = input.next();
						System.out.println("---------------------");
						hotel.cancelReservation(reservatioId);
						break;

					case 3:
						System.out.print("Enter the reservation ID: ");
						String idsearch = input.next();
						System.out.println("---------------------");
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
						System.out.println(hotel.countAvailableRoomRecuresive(0));
						break;

					case 6:
						sr = null;
						sur = null;
						csr = null;

						System.out.println("Signing out...");
						break;

					default:
						System.out.print("Choose a correct number");

					}// default for switch num2
				} while (choose2 != 6);
				break;
			case 2:
				System.out.println("---------------------");
				System.out.println("Good bye, see you later!");
				break;

			default:
				System.out.println("Choose a correct number");
			}
		} while (choose1 != 2);
	}
}
