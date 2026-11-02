package hw;
//Matches the package name seen in your project

import java.util.Objects; // Required to fix the Objects.hash error

/**
* Represents a Fast Food Restaurant in the system, extending the base Restaurant class.
* All comments and documentation are provided in English as requested.
*/
public class FastFoodRestaurant extends Restaurant {
 // Class properties (Assuming these are the fields based on your getters/setters)
 private double averagePreparationTimeMinutes;
 private double rushHourSurcharge;

 /**
  * Parameterized constructor invoking the super constructor and initializing class fields.
  */
 public FastFoodRestaurant(String restaurantCode, String restaurantName, String cuisineType, 
                           double rating, boolean isOpen, double baseDeliveryFee,
                           double averagePreparationTimeMinutes, double rushHourSurcharge) {
     super(restaurantCode, restaurantName, cuisineType, rating, isOpen, baseDeliveryFee);
     setAveragePreparationTimeMinutes(averagePreparationTimeMinutes);
     setRushHourSurcharge(rushHourSurcharge);
 }


 // Getters & Setters


 public double getAveragePreparationTimeMinutes() {
     return averagePreparationTimeMinutes;
 }

 public void setAveragePreparationTimeMinutes(double averagePreparationTimeMinutes) {

	    if (averagePreparationTimeMinutes >= 1
	            && averagePreparationTimeMinutes <= 120) {

	        this.averagePreparationTimeMinutes =
	                averagePreparationTimeMinutes;

	    } else {

	        this.averagePreparationTimeMinutes = 15.0;
	    }
	}

 public double getRushHourSurcharge() {
     return rushHourSurcharge;
 }

 public void setRushHourSurcharge(double rushHourSurcharge) {

	    if (rushHourSurcharge >= 0
	            && rushHourSurcharge <= 50) {

	        this.rushHourSurcharge =
	                rushHourSurcharge;

	    } else {

	        this.rushHourSurcharge = 0.0;
	    }
	}

 // ==========================================
 // ✅ Generate equals & hashCode (Includes super check)
 // ==========================================
 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;
     if (!super.equals(o)) return false;
     
     FastFoodRestaurant other = (FastFoodRestaurant) o; // Fixed the '+' typo error completely
     
     // Using Double.compare for safe decimal equality verification in Java
     return Double.compare(other.averagePreparationTimeMinutes, averagePreparationTimeMinutes) == 0 &&
            Double.compare(other.rushHourSurcharge, rushHourSurcharge) == 0;
 }

 @Override
 public int hashCode() {
     // Combines fields from superclass along with local properties safely
     return Objects.hash(super.hashCode(), averagePreparationTimeMinutes, rushHourSurcharge);
 }


 // Generate toString

 @Override
 public String toString() {
     return "FastFoodRestaurant{" +
             "averagePreparationTimeMinutes=" + averagePreparationTimeMinutes +
             ", rushHourSurcharge=" + rushHourSurcharge +
             ", " + super.toString() +
             '}';
 }
}