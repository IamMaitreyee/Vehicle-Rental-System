package MiniProject;

public class Customer {

	private int customerId;
	private String customerName;
	private String customerEmail;
	private String phoneNo;
	private String address;
	private String licenseNo;
	
	public Customer() {

	}

	public Customer(int customerId, String customerName, String customerEmail, String phoneNo, String address,
			String licenseNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.phoneNo = phoneNo;
		this.address = address;
		this.licenseNo = licenseNo;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", phoneNo=" + phoneNo + ", address=" + address + ", licenseNo=" + licenseNo + "]";
	}

	
	public void validateLicense() {
		
		if(licenseNo != null && !licenseNo.trim().isEmpty())
			System.out.println("Valid License");
		else
			System.err.println("Invalid License");
	}
	
	public void checkCustomerDetails() {
		System.out.println(this);
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	
	
}
