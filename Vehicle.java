package MiniProject;

public class Vehicle {

	private int vehicleId;
	private String vehicleName;
	private String brand;
	private String model;
	private String vehicleNumber;
	private double pricePerDay;
	private boolean available;
	
	static String companyName = "Maitri Rentals";
	static int vehicleCount = 0;
	
	public double caculateRent(int days) {
		return pricePerDay * days;
	}
	
	public void rentVehicle() {
		
		if(available) {
			available = false;
			System.out.println("Vehicle Rented Successfully!!!!");
		}else
			System.err.println("Vehicle is already rented");
	}
	
	public void returnVehicle() {
		
		if(!available) {
			available = true;
	        System.out.println("Vehicle returned successfully!");
		}else
			System.err.println("Vehicle is already available!");
	}
	
	public void checkAvailability() {
		
		if(available)
			System.out.println("Vehicle is available for rent!");
		else
			System.err.println("Vechicle is not available.");
	}
	
	
	Vehicle(){
		
	}

	public Vehicle(int vehicleId, String vehicleName, String brand, String model, String vehicleNumber,
			double pricePerDay, boolean available) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.brand = brand;
		this.model = model;
		this.vehicleNumber = vehicleNumber;
		this.pricePerDay = pricePerDay;
		this.available = available;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
	    return "\nVehicle\n\n" +
	           "Vehicle ID     : " + vehicleId + "\n" +
	           "Vehicle Name   : " + vehicleName + "\n" +
	           "Brand          : " + brand + "\n" +
	           "Model          : " + model + "\n" +
	           "Vehicle Number : " + vehicleNumber + "\n" +
	           "Price Per Day  : " + pricePerDay + "\n" +
	           "Available      : " + available;
	}

	public void caculateRent() {
		// TODO Auto-generated method stub
		
	}

	
	

	
	
}
