import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private final ArrayList<Customer> customers = new ArrayList<>();
    private final ArrayList<Rental> rentals = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.loadSampleData();
        app.startMenu();
    }

    private void loadSampleData() {
        addVehicle(new Car("V101", "Toyota", "Innova", 3500, 7, "Diesel"));
        addVehicle(new Car("V102", "Honda", "City", 2800, 5, "Petrol"));
        addVehicle(new Bike("V201", "Yamaha", "FZ", 1000, 150, "Street"));
        addVehicle(new Bike("V202", "Royal Enfield", "Classic 350", 1800, 350, "Cruiser"));

        addCustomer(new Customer("C101", "Aarav Sharma", "DL-12345", "9876543210"));
        addCustomer(new Customer("C102", "Meera Iyer", "MH98765", "9123456780"));
    }

    private void startMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n===== Vehicle Rental System =====");
            System.out.println("1. List all vehicles");
            System.out.println("2. Search vehicle by ID");
            System.out.println("3. List customers");
            System.out.println("4. Rent a vehicle");
            System.out.println("5. Return a vehicle");
            System.out.println("6. Cancel a rental");
            System.out.println("7. List rentals");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    listVehicles();
                    break;
                case "2":
                    searchVehicleById();
                    break;
                case "3":
                    listCustomers();
                    break;
                case "4":
                    rentVehicle();
                    break;
                case "5":
                    returnVehicle();
                    break;
                case "6":
                    cancelRental();
                    break;
                case "7":
                    listRentals();
                    break;
                case "0":
                    running = false;
                    System.out.println("Thank you for using Vehicle Rental System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void addVehicle(Vehicle vehicle) {
        if (findVehicleById(vehicle.getVehicleId()) != null) {
            throw new IllegalArgumentException("Duplicate vehicle ID: " + vehicle.getVehicleId());
        }
        vehicles.add(vehicle);
    }

    private void addCustomer(Customer customer) {
        if (findCustomerById(customer.getCustomerId()) != null) {
            throw new IllegalArgumentException("Duplicate customer ID: " + customer.getCustomerId());
        }
        if (!Customer.isValidDrivingLicense(customer.getDrivingLicenseNumber())) {
            throw new IllegalArgumentException("Invalid driving license for customer: " + customer.getCustomerId());
        }
        customers.add(customer);
    }

    private Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equalsIgnoreCase(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    private Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equalsIgnoreCase(customerId)) {
                return customer;
            }
        }
        return null;
    }

    private Rental findRentalById(String rentalId) {
        for (Rental rental : rentals) {
            if (rental.getRentalId().equalsIgnoreCase(rentalId)) {
                return rental;
            }
        }
        return null;
    }

    private void listVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }
        System.out.println("\n--- Vehicles ---");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
            return;
        }
        System.out.println("\n--- Customers ---");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void listRentals() {
        if (rentals.isEmpty()) {
            System.out.println("No rentals found.");
            return;
        }
        System.out.println("\n--- Rentals ---");
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }

    private void searchVehicleById() {
        System.out.print("Enter Vehicle ID: ");
        String vehicleId = scanner.nextLine().trim();
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle == null) {
            System.out.println("Vehicle not found.");
        } else {
            System.out.println(vehicle);
        }
    }

    private void rentVehicle() {
        try {
            System.out.print("Enter Rental ID: ");
            String rentalId = scanner.nextLine().trim();
            if (rentalId.isEmpty() || findRentalById(rentalId) != null) {
                System.out.println("Invalid or duplicate rental ID.");
                return;
            }

            System.out.print("Enter Customer ID: ");
            String customerId = scanner.nextLine().trim();
            Customer customer = findCustomerById(customerId);
            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }

            System.out.print("Enter Vehicle ID: ");
            String vehicleId = scanner.nextLine().trim();
            Vehicle vehicle = findVehicleById(vehicleId);
            if (vehicle == null) {
                System.out.println("Vehicle not found.");
                return;
            }
            if (!vehicle.isAvailable()) {
                System.out.println("Vehicle is currently unavailable.");
                return;
            }

            System.out.print("Enter Rental Days: ");
            int rentalDays = Integer.parseInt(scanner.nextLine().trim());
            if (rentalDays <= 0) {
                System.out.println("Rental days must be greater than 0.");
                return;
            }

            Rental rental = new Rental(rentalId, vehicle, customer, rentalDays);
            rentals.add(rental);
            System.out.println("Rental created successfully.");
            System.out.println(rental);
        } catch (NumberFormatException ex) {
            System.out.println("Rental days must be a valid number.");
        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.println("Unable to create rental: " + ex.getMessage());
        }
    }

    private void returnVehicle() {
        System.out.print("Enter Rental ID to return: ");
        String rentalId = scanner.nextLine().trim();
        Rental rental = findRentalById(rentalId);
        if (rental == null) {
            System.out.println("Rental not found.");
            return;
        }
        try {
            rental.completeRental();
            System.out.println("Vehicle returned successfully.");
            System.out.println(rental);
        } catch (IllegalStateException ex) {
            System.out.println("Unable to return vehicle: " + ex.getMessage());
        }
    }

    private void cancelRental() {
        System.out.print("Enter Rental ID to cancel: ");
        String rentalId = scanner.nextLine().trim();
        Rental rental = findRentalById(rentalId);
        if (rental == null) {
            System.out.println("Rental not found.");
            return;
        }
        try {
            rental.cancelRental();
            System.out.println("Rental cancelled successfully.");
            System.out.println(rental);
        } catch (IllegalStateException ex) {
            System.out.println("Unable to cancel rental: " + ex.getMessage());
        }
    }
}
