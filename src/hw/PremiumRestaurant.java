package hw;


import java.util.Objects;

/**
 * Represents a premium restaurant which checks minimum transaction value
 * and adds a percentage-based luxury service charge.
 */
public class PremiumRestaurant extends Restaurant {
    private double minimumOrderValue;
    private double serviceChargePercentage;

    // Generate Constructor using fields
    public PremiumRestaurant(String restaurantCode, String restaurantName, String cuisineType, double rating, boolean isOpen, double baseDeliveryFee, double minimumOrderValue, double serviceChargePercentage) {
        super(restaurantCode, restaurantName, cuisineType, rating, isOpen, baseDeliveryFee);
        setMinimumOrderValue(minimumOrderValue);
        setServiceChargePercentage(serviceChargePercentage);
    }

    /**
     * Polymorphic implementation computing absolute additional percentage-based fee.
     */
    @Override
    public double calculateFinalPrice(double baseOrderAmount) {
        return super.calculateFinalPrice(baseOrderAmount) + (baseOrderAmount * (serviceChargePercentage / 100));
    }

    // Generate Getters & Setters
    public double getMinimumOrderValue() { return minimumOrderValue; }
    public void setMinimumOrderValue(
            double minimumOrderValue) {

        if (minimumOrderValue >= 0
                && minimumOrderValue <= 1000) {

            this.minimumOrderValue =
                    minimumOrderValue;

        } else {

            this.minimumOrderValue = 0.0;
        }
    }

    public double getServiceChargePercentage() { return serviceChargePercentage; }
    public void setServiceChargePercentage(
            double serviceChargePercentage) {

        if (serviceChargePercentage >= 0
                && serviceChargePercentage <= 100) {

            this.serviceChargePercentage =
                    serviceChargePercentage;

        } else {

            this.serviceChargePercentage = 0.0;
        }
    }

    // Generate equals & hashCode (Includes super check)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PremiumRestaurant that = (PremiumRestaurant) o;
        return Double.compare(that.minimumOrderValue, minimumOrderValue) == 0 && Double.compare(that.serviceChargePercentage, serviceChargePercentage) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minimumOrderValue, serviceChargePercentage);
    }

    // Generate toString
    @Override
    public String toString() {
        return "PremiumRestaurant{" +
                "minimumOrderValue=" + minimumOrderValue +
                ", serviceChargePercentage=" + serviceChargePercentage +
                ", " + super.toString() +
                '}';
    }
}