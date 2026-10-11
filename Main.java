package MiniProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Company Name: " + Vehicle.companyName);
		System.out.println("Total Vehicles: " + Vehicle.vehicleCount);
		Vehicle.vehicleCount++;

		Scanner sc = new Scanner(System.in);

		ArrayList<Vehicle> vehicles = new ArrayList<>();

		vehicles.add(new Vehicle(101, "Swift", "Maruti", "VXI", "MH12AB1234", 1500, true));

		vehicles.add(new Car(102, "Creta", "Hyundai", "SX", "MH14CD5678", 2500, true, 5, "Petrol", true));

		vehicles.add(new Bike(103, "Classic 350", "Royal Enfield", "Classic", "MH15EF9012", 1000, true, "Petrol",
				"Manual", true));

		ArrayList<Customer> cust = new ArrayList<>();

		cust.add(new Customer(201, "Mayur Patil", "9876543210", "mayure@gmail.com", "Pune", "MH20261001"));

		cust.add(new Customer(202, "Siddhi Kale", "8765432109", "siddhi@gmail.com", "Jalgaon", "MH20261002"));

		ArrayList<Rental> rent = new ArrayList<>();

		rent.add(new Rental(301, cust.get(0), vehicles.get(1), 3, 7500, "Active"));

		rent.add(new Rental(302, cust.get(1), vehicles.get(2), 2, 2000, "Completed"));

		int choice = 0;

		while (choice != 9) {

			System.out.println("\n======================================");
			System.out.println("        VEHICLE RENTAL SYSTEM");
			System.out.println("======================================");
			System.out.println("1. Display All Vehicles");
			System.out.println("2. Search Vehicle");
			System.out.println("3. Check Vehicle Availability");
			System.out.println("4. Rent Vehicle");
			System.out.println("5. Return Vehicle");
			System.out.println("6. Display Customers");
			System.out.println("7. Display Rental Details");
			System.out.println("8. Calculate Rental Amount");
			System.out.println("9. Exit");
			System.out.println("======================================");

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.println("\n----- ALL VEHICLES -----");

				for (Vehicle v : vehicles) {
					System.out.println(v);
				}

				break;

			case 2:

				System.out.println("Enter the Vehicle Id: ");
				int vehicleId = sc.nextInt();

				boolean foundVehicle = false;

				for (Vehicle v : vehicles) {

					if (v.getVehicleId() == vehicleId) {
						System.out.println(v);
						foundVehicle = true;
						break;
					}
				}
				if (!foundVehicle)
					System.err.println("Vechile Not found...");

				break;

			case 3:

				System.out.println("Enter the Vehicle Id: ");
				int Id = sc.nextInt();

				boolean found = false;

				for (Vehicle v : vehicles) {

					if (v.getVehicleId() == Id) {
						v.checkAvailability();
						found = true;
						break;
					}
				}
				if (!found)
					System.err.println("Vechile Not found...");
				break;

			case 4:

				System.out.println("Enter the VehicleId to rent: ");
				int rentId = sc.nextInt();

				for (Vehicle v : vehicles) {

					if (v.getVehicleId() == rentId) {
						v.rentVehicle();
						break;
					}

				}
				break;

			case 5:
				System.out.println("Enter the VehicleId to return: ");
				int returnId = sc.nextInt();

				for (Vehicle v : vehicles) {

					if (v.getVehicleId() == returnId) {
						v.returnVehicle();
						break;
					}
				}
				break;

			case 6:

				System.out.println("\n-------------- Customer Details -------------");

				for (Customer c : cust) {
					System.out.println(c);
				}
				break;

			case 7:

				System.out.println("\n-------------- Rental Details -------------");

				for (Rental r : rent) {
					System.out.println(r);
				}
				break;

			case 8:

				System.out.println("Enter Rental Id: ");
				int rentalId = sc.nextInt();

				for (Rental r : rent) {

					if (r.rentalid == rentalId) {
						r.calculateTotalAmount();
						break;
					}
				}
				break;

			case 9:
				System.out.println("Thank You for using Vechile Rental System by Maitreyi!!!");
				break;

			default:
				System.err.println("Invalid Choice!");

			}
		}

		sc.close();
	}
}