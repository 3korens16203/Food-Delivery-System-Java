package hw;
import java.util.Objects;

/**
 * Represents a Customer in the Food Delivery System.
 * Includes comprehensive data validation based on assignment specs.
 * All field comments and method documentations are provided in English.
 */
public class Customer implements Comparable<Customer> {
    // Class properties (Encapsulated as private according to guidelines)
    private String customerCode; // Unique client code (e.g., C0001)
    private String firstName;    // Client's first name
    private String lastName;     // Client's last name
    private String fullAddress;  // Street, house number, and city
    private String phoneNumber;  // Contact phone number
    private String email;        // Email address
    private double balance;      // Account monetary balance (Cannot be negative)
    private String idNumber;     // National ID card number (Exactly 9 digits)

    /**
     * Fully parameterized constructor with strict data validation inputs.
     */
    public Customer(String customerCode, String firstName, String lastName, String fullAddress, 
                    String phoneNumber, String email, double balance, String idNumber) {
        setCustomerCode(customerCode);
        setFirstName(firstName);
        setLastName(lastName);
        setFullAddress(fullAddress);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setBalance(balance);
        setIdNumber(idNumber);
    }
    /**
     * Overloaded constructor supporting legacy 7-parameter initialization from Main.
     * Automatically assigns a default ID number to fulfill the updated system model.
     */
    public Customer(String customerCode, String firstName, String lastName, String fullAddress, 
                    String phoneNumber, String email, double balance) {
        setCustomerCode(customerCode);
        setFirstName(firstName);
        setLastName(lastName);
        setFullAddress(fullAddress);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setBalance(balance);
        setIdNumber("000000000"); // Standard fallback default value
    }

   
    //  Generate Getters & Setters with Validations
   

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {

        if (customerCode != null &&
                customerCode.matches("C\\d+")) {

            this.customerCode = customerCode;

        } else {

            this.customerCode = "C0000";
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        // Validation: Letters only (English and Hebrew), no numbers allowed
        if (firstName != null && firstName.trim().matches("^[a-zA-Z\\\\s\\u0590-\\u05FF]+$")) {
            this.firstName = firstName;
        } else {
            this.firstName = "Unknown";
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        // Validation: Letters and spaces only, no numbers allowed
        if (lastName != null && lastName.trim().matches("^[a-zA-Z\u0590-\u05fe\\s]+$")) {
            this.lastName = lastName;
        } else {
            this.lastName = "Unknown";
        }
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        // Validation: Cannot be empty
    	if (fullAddress != null &&
    		    fullAddress.matches(
    		    "^[a-zA-Z0-9\\s\\-/\u0590-\u05FF]+$")) {
            this.fullAddress = fullAddress;
        } else {
            this.fullAddress = "Default Address";
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        // Validation: Digits and dashes only, recommended length around 10 digits
        if (phoneNumber != null && phoneNumber.matches("05\\d-?\\d{7}")) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "0500000000";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // Validation: Must contain '@' and a explicit '.' after the '@' symbol
    	if (email != null &&
    		    email.matches(
    		        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            this.email = email;
        } else {
            this.email = "default@email.com";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        // Validation: Double type value, must be non-negative (>= 0)
        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0.0;
        }
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        // Validation: Digits only, must be exactly 9 digits long
        if (idNumber != null && idNumber.trim().matches("^[0-9]{9}$")) {
            this.idNumber = idNumber;
        } else {
            this.idNumber = "000000000";
        }
    }

   
    //  Generate equals & hashCode (Fixed Errors)
   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerCode, customer.customerCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerCode);
    }

    
    // Generate toString
    

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode='" + customerCode + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
    /**
     * Compares customers by balance (highest first).
     */
    @Override
    public int compareTo(Customer other) {

        return Double.compare(
                other.getBalance(),
                this.getBalance());
    }
}