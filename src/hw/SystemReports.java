package hw;

import java.util.ArrayList;

/**
 * Wildcards reports class.
 */
public class SystemReports {

    /**
     * Prints all restaurants.
     */
    public static void printRestaurants(
            ArrayList<? extends Restaurant> restaurants) {

        for (Restaurant restaurant : restaurants) {

            System.out.println(restaurant);
        }
    }

    /**
     * Calculates total order prices.
     */
    public static double getTotalOrdersPrice(
            ArrayList<? extends Order> orders) {

        double total = 0;

        for (Order order : orders) {

            total += order.getFinalPrice();
        }

        return total;
    }

    /**
     * Adds a fast food restaurant.
     */
    public static void addFastFoodRestaurant(
            ArrayList<? super FastFoodRestaurant> restaurants,
            FastFoodRestaurant restaurant) {

        restaurants.add(restaurant);
    }

    /**
     * Returns largest object using Comparable.
     */
    public static <T extends Comparable<T>> T getLargest(
            ArrayList<T> list) {

        if (list == null || list.isEmpty()) {

            return null;
        }

        T largest = list.get(0);

        for (T item : list) {

            if (item.compareTo(largest) < 0) {

                largest = item;
            }
        }

        return largest;
    }
}
