public class Bike extends Vehicle {
    private int engineCapacityCc;
    private String bikeCategory;

    public Bike(String vehicleId, String brand, String model, double dailyRentalPrice, int engineCapacityCc, String bikeCategory) {
        super(vehicleId, brand, model, dailyRentalPrice);
        setEngineCapacityCc(engineCapacityCc);
        setBikeCategory(bikeCategory);
    }

    public int getEngineCapacityCc() {
        return engineCapacityCc;
    }

    public void setEngineCapacityCc(int engineCapacityCc) {
        if (engineCapacityCc <= 0) {
            throw new IllegalArgumentException("Engine capacity must be greater than 0.");
        }
        this.engineCapacityCc = engineCapacityCc;
    }

    public String getBikeCategory() {
        return bikeCategory;
    }

    public void setBikeCategory(String bikeCategory) {
        if (bikeCategory == null || bikeCategory.trim().isEmpty()) {
            throw new IllegalArgumentException("Bike category cannot be empty.");
        }
        this.bikeCategory = bikeCategory.trim();
    }

    @Override
    public String getVehicleType() {
        return "Bike";
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Engine=" + engineCapacityCc + "cc"
                + ", Category=" + bikeCategory;
    }
}
