package hw;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Represents a delivery rider in the system.
 * Stores completed delivery orders using ArrayList.
 */
public class Rider {
    // Rider ID number
    private String riderId;
    // Rider full name
    private String fullName;
    // Rider phone number
    private String phoneNumber;
    // Delivery vehicle type
    private String vehicle;
    // Rider availability status
    private boolean isAvailable;
    // Collection of completed orders
    private ArrayList<Order> completedOrders;
    
    /**
     * Full constructor.
     *
     * @param riderId Rider ID
     * @param fullName Rider full name
     * @param phoneNumber Rider phone number
     * @param vehicle Vehicle type
     * @param isAvailable Availability status
     */
    public Rider(String riderId,
                 String fullName,
                 String phoneNumber,
                 String vehicle,
                 boolean isAvailable) {
        this.riderId = riderId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.vehicle = vehicle;
        this.isAvailable = isAvailable;
        // Initialize completed orders collection
        this.completedOrders =
                new ArrayList<>();
    }
    
    // GETTERS & SETTERS
    
    public String getRiderId() {
        return riderId;
    }
    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getVehicle() {
        return vehicle;
    }
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public ArrayList<Order> getCompletedOrders() {
        return completedOrders;
    }
    public void setCompletedOrders(
            ArrayList<Order> completedOrders) {
        this.completedOrders =
                completedOrders;
    }
    
    /**
     * Returns number of completed orders.
     *
     * @return Number of orders
     */
    public int getOrderCount() {
        return completedOrders.size();
    }
    
    // CUSTOM METHODS
    
    /**
     * Adds completed order to rider history.
     * Prevents duplicate orders.
     *
     * @param order Order object
     */
    public void addOrder(Order order) {
        // Prevent duplicates
        if (!completedOrders.contains(order)) {
            completedOrders.add(order);
        }
    }
    
    // EQUALS & HASHCODE
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null
                || getClass() != o.getClass())
            return false;
        Rider rider = (Rider) o;
        return Objects.equals(
                riderId,
                rider.riderId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(riderId);
    }
    
    // TOSTRING
    
    @Override
    public String toString() {
        return "Rider{" +
                "riderId='" +
                riderId + '\'' +
                ", fullName='" +
                fullName + '\'' +
                ", phoneNumber='" +
                phoneNumber + '\'' +
                ", vehicle='" +
                vehicle + '\'' +
                ", isAvailable=" +
                isAvailable +
                ", completedOrders=" +
                completedOrders.size() +
                '}';
    }
}