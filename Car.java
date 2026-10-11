package MiniProject;

public class Car extends Vehicle{

	int seats;
	String fuelType;
	boolean airConditioned;
	
	
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
		// TODO Auto-generated method stub
		super.returnVehicle();
	}


	@Override
	public void checkAvailability() {
		// TODO Auto-generated method stub
		super.checkAvailability();
	}


	Car(){
		
	}

	public Car(int vehicleId, String vehicleName, String brand, String model, String vehicleNumber, double pricePerDay,
			boolean available, int seats, String fuelType, boolean airConditioned) {
		super(vehicleId, vehicleName, brand, model, vehicleNumber, pricePerDay, available);
		this.seats = seats;
		this.fuelType = fuelType;
		this.airConditioned = airConditioned;
	}


	@Override
	public String toString() {
	    return "\n\nCar\n\n" +
	           "Vehicle ID     : " + getVehicleId() + "\n" +
	           "Vehicle Name   : " + getVehicleName() + "\n" +
	           "Brand          : " + getBrand() + "\n" +
	           "Model          : " + getModel() + "\n" +
	           "Vehicle Number : " + getVehicleNumber() + "\n" +
	           "Price Per Day  : " + getPricePerDay() + "\n" +
	           "Available      : " + isAvailable() + "\n" +
	           "Seats          : " + seats + "\n" +
	           "Fuel Type      : " + fuelType + "\n" +
	           "Air Condition  : " + airConditioned;
	}
	
	
	
	
}
