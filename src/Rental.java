import java.time.LocalDate;

public class Rental {
    public enum RentalStatus {
        ACTIVE,
        COMPLETED,
        CANCELLED
    }

    private String rentalId;
    private Vehicle vehicle;
    private Customer customer;
    private int rentalDays;
    private double totalCost;
    private LocalDate startDate;
    private RentalStatus status;

    public Rental(String rentalId, Vehicle vehicle, Customer customer, int rentalDays) {
        setRentalId(rentalId);
        setVehicle(vehicle);
        setCustomer(customer);
        setRentalDays(rentalDays);
        if (!vehicle.isAvailable()) {
            throw new IllegalStateException("Vehicle is not available for rent.");
        }
        this.startDate = LocalDate.now();
        this.totalCost = calculateRentalCost();
        this.status = RentalStatus.ACTIVE;
        this.vehicle.setAvailable(false);
    }

    public String getRentalId() {
        return rentalId;
    }

    public void setRentalId(String rentalId) {
        if (rentalId == null || rentalId.trim().isEmpty()) {
            throw new IllegalArgumentException("Rental ID cannot be empty.");
        }
        this.rentalId = rentalId.trim();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        this.customer = customer;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be greater than 0.");
        }
        this.rentalDays = rentalDays;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public double calculateRentalCost() {
        return vehicle.getDailyRentalPrice() * rentalDays;
    }

    public void completeRental() {
        if (status != RentalStatus.ACTIVE) {
            throw new IllegalStateException("Only active rentals can be completed.");
        }
        status = RentalStatus.COMPLETED;
        vehicle.setAvailable(true);
    }

    public void cancelRental() {
        if (status != RentalStatus.ACTIVE) {
            throw new IllegalStateException("Only active rentals can be cancelled.");
        }
        status = RentalStatus.CANCELLED;
        vehicle.setAvailable(true);
    }

    @Override
    public String toString() {
        return "Rental ID=" + rentalId
                + ", Vehicle ID=" + vehicle.getVehicleId()
                + ", Customer ID=" + customer.getCustomerId()
                + ", Days=" + rentalDays
                + ", Start Date=" + startDate
                + ", Total Cost=" + totalCost
                + ", Status=" + status;
    }
}
