package hw;
import java.util.Objects;

/**
 * Base class representing a standard restaurant.
 * Serves as the foundation for specialized sub-types using polymorphism.
 */
public class Restaurant {
    protected String restaurantCode;
    protected String restaurantName;
    protected String cuisineType;
    protected double rating;
    protected boolean isOpen;
    protected double baseDeliveryFee;

    // Generate Constructor using fields
    public Restaurant(String restaurantCode, String restaurantName, String cuisineType, double rating, boolean isOpen, double baseDeliveryFee) {
        this.restaurantCode = restaurantCode;
        this.restaurantName = restaurantName;
        this.cuisineType = cuisineType;
        this.rating = rating;
        this.isOpen = isOpen;
        this.baseDeliveryFee = baseDeliveryFee;
    }

    /**
     * Calculates the final bill price including delivery charges.
     * Overridden polymorphically by subclasses.
     */
    public double calculateFinalPrice(double baseOrderAmount) {
        return baseOrderAmount + baseDeliveryFee;
    }

    //  Generate Getters & Setters
    public String getRestaurantCode() { return restaurantCode; }
    public void setRestaurantCode(String restaurantCode) { this.restaurantCode = restaurantCode; }

    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }

    public String getCuisineType() { return cuisineType; }
    public void setCuisineType(String cuisineType) { this.cuisineType = cuisineType; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public boolean isOpen() { return isOpen; }
    public void setOpen(boolean open) { isOpen = open; }

    public double getBaseDeliveryFee() { return baseDeliveryFee; }
    public void setBaseDeliveryFee(double baseDeliveryFee) { this.baseDeliveryFee = baseDeliveryFee; }

    //  Generate equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(restaurantCode, that.restaurantCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantCode);
    }

    //  Generate toString
    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantCode='" + restaurantCode + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", rating=" + rating +
                ", isOpen=" + isOpen +
                ", baseDeliveryFee=" + baseDeliveryFee +
                '}';
    }
}