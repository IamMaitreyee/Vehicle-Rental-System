package MiniProject;

public class Bike extends Vehicle{

	String fuelType;
	String gearType;
	Boolean hasSelfStart;
	
	Bike(){
		
	}
	
	public Bike(int vehicleId, String vehicleName, String brand, String model, String vehicleNumber, double pricePerDay,
			boolean available, String fuelType, String gearType, Boolean hasSelfStart) {
		super(vehicleId, vehicleName, brand, model, vehicleNumber, pricePerDay, available);
		this.fuelType = fuelType;
		this.gearType = gearType;
		this.hasSelfStart = hasSelfStart;
	}

	@Override
	public double caculateRent(int days) {
		return super.caculateRent(days);
	}
	
	@Override
	public void rentVehicle() {
		super.rentVehicle();
	}
	
	@Override
	public void returnVehicle() {
		super.returnVehicle();
	}
	
	@Override
	public void checkAvailability() {
		super.checkAvailability();
	}

	@Override
	public String toString() {
	    return "\n\nBike\n\n" +
	           "Vehicle ID     : " + getVehicleId() + "\n" +
	           "Vehicle Name   : " + getVehicleName() + "\n" +
	           "Brand          : " + getBrand() + "\n" +
	           "Model          : " + getModel() + "\n" +
	           "Vehicle Number : " + getVehicleNumber() + "\n" +
	           "Price Per Day  : " + getPricePerDay() + "\n" +
	           "Available      : " + isAvailable() + "\n" +
	           "Fuel Type      : " + fuelType + "\n" +
	           "Gear Type      : " + gearType + "\n" +
	           "Self Start     : " + hasSelfStart;
	}
	
	

	
	

}
