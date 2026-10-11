public class Car extends Vehicle {
    private int seatingCapacity;
    private String fuelType;

    public Car(String vehicleId, String brand, String model, double dailyRentalPrice, int seatingCapacity, String fuelType) {
        super(vehicleId, brand, model, dailyRentalPrice);
        setSeatingCapacity(seatingCapacity);
        setFuelType(fuelType);
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        if (seatingCapacity <= 0) {
            throw new IllegalArgumentException("Seating capacity must be greater than 0.");
        }
        this.seatingCapacity = seatingCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        if (fuelType == null || fuelType.trim().isEmpty()) {
            throw new IllegalArgumentException("Fuel type cannot be empty.");
        }
        this.fuelType = fuelType.trim();
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    // Method overriding: child class adds more details in toString().
    @Override
    public String toString() {
        return super.toString()
                + ", Seats=" + seatingCapacity
                + ", Fuel=" + fuelType;
    }
}
