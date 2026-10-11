public class Customer {
    private String customerId;
    private String name;
    private String drivingLicenseNumber;
    private String phoneNumber;

    public Customer(String customerId, String name, String drivingLicenseNumber) {
        this(customerId, name, drivingLicenseNumber, "N/A");
    }

    public Customer(String customerId, String name, String drivingLicenseNumber, String phoneNumber) {
        setCustomerId(customerId);
        setName(name);
        setDrivingLicenseNumber(drivingLicenseNumber);
        setPhoneNumber(phoneNumber);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be empty.");
        }
        this.customerId = customerId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        this.name = name.trim();
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        if (!isValidDrivingLicense(drivingLicenseNumber)) {
            throw new IllegalArgumentException("Invalid driving license number.");
        }
        this.drivingLicenseNumber = drivingLicenseNumber.trim().toUpperCase();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }
        this.phoneNumber = phoneNumber.trim();
    }

    public static boolean isValidDrivingLicense(String licenseNumber) {
        if (licenseNumber == null) {
            return false;
        }
        String value = licenseNumber.trim();
        return value.matches("[A-Za-z0-9-]{5,20}");
    }

    @Override
    public String toString() {
        return "ID=" + customerId
                + ", Name=" + name
                + ", License=" + drivingLicenseNumber
                + ", Phone=" + phoneNumber;
    }
}
