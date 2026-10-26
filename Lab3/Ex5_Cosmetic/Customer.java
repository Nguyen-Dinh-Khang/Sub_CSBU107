package Lab3.Ex5_Cosmetic;

public class Customer {
    private String customerId;
    private String fullName;
    private String address;
    private String phoneNumber;

    public Customer(String customerId, String fullName, String address, String phoneNumber) {
        setCustomerId(customerId);
        setFullName(fullName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid customer ID!");
        }
        this.customerId = customerId.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid full name!");
        }
        this.fullName = fullName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid address!");
        }
        this.address = address.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid phone number!");
        }
        this.phoneNumber = phoneNumber.trim();
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Address: %s | Phone: %s",
                customerId, fullName, address, phoneNumber);
    }
}
