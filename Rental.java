package MiniProject;

public class Rental {

	int rentalid;
	Customer customer;
	Vehicle vehicle;
	int rentDays;
	double totalAmt;
	String rentalStatus;

	public void calculateTotalAmount() {

		if (vehicle != null && rentDays > 0) {
			totalAmt = vehicle.caculateRent(rentDays);
			System.out.println("Total Rental Amount: " + totalAmt);
		} else
			System.err.println("Invalid vehicle or rental days!");

	}

	public void createRental() {

		if (vehicle != null && rentDays > 0 && vehicle.isAvailable()) {

			calculateTotalAmount();
			rentalStatus = "Active";
			vehicle.rentVehicle();

			System.out.println("Rental Created Successfully!!!");
		} else {
			System.out.println("Rental cannot be created!");
		}

	}

	public void completeRental() {

		if ("Active".equalsIgnoreCase(rentalStatus) && vehicle != null) {
			rentalStatus = "Completed";
			vehicle.rentVehicle();

			System.out.println("Rental completed successfully!");
		} else {
			System.out.println("Rental cannot be completed!");
		}
	}

	public void cancelRental() {

		if ("Completed".equalsIgnoreCase(rentalStatus) && vehicle != null) {
			rentalStatus = "Cancelled";
			vehicle.returnVehicle();

			System.out.println("Rental cancelled successfully!");
		} else {
			System.out.println("Rental cannot be cancelled!");
		}
	}

	public void displayRentalDetails() {

		System.out.println(this);
	}

	public Rental() {

	}

	public Rental(int rentalid, Customer customer, Vehicle vehicle, int rentDays, double totalAmt, String retalStatus) {
		super();
		this.rentalid = rentalid;
		this.customer = customer;
		this.vehicle = vehicle;
		this.rentDays = rentDays;
		this.totalAmt = totalAmt;
		this.rentalStatus = retalStatus;
	}

	@Override
	public String toString() {
		return "Rental [rentalid=" + rentalid + ", customer=" + customer + ", vehicle=" + vehicle + ", rentDays="
				+ rentDays + ", totalAmt=" + totalAmt + ", retalStatus=" + rentalStatus + "]";
	}

}
