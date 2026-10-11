public abstract class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double dailyRentalPrice;
    private boolean available;

    // Constructor overloading: this constructor defaults availability to true.
    public Vehicle(String vehicleId, String brand, String model, double dailyRentalPrice) {
        this(vehicleId, brand, model, dailyRentalPrice, true);
    }

    public Vehicle(String vehicleId, String brand, String model, double dailyRentalPrice, boolean available) {
        setVehicleId(vehicleId);
        setBrand(brand);
        setModel(model);
        setDailyRentalPrice(dailyRentalPrice);
        this.available = available;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        if (vehicleId == null || vehicleId.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be empty.");
        }
        this.vehicleId = vehicleId.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty.");
        }
        this.brand = brand.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty.");
        }
        this.model = model.trim();
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(double dailyRentalPrice) {
        if (dailyRentalPrice <= 0) {
            throw new IllegalArgumentException("Daily rental price must be greater than 0.");
        }
        this.dailyRentalPrice = dailyRentalPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Polymorphism: each child class gives its own vehicle type.
    public abstract String getVehicleType();

    @Override
    public String toString() {
        return "ID=" + vehicleId
                + ", Type=" + getVehicleType()
                + ", Brand=" + brand
                + ", Model=" + model
                + ", Daily Price=" + dailyRentalPrice
                + ", Available=" + available;
    }
}
