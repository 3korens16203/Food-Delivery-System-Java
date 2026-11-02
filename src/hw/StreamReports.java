package hw;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Stream API reports.
 */
public class StreamReports {

    /**
     * Prints all open restaurants.
     */
    public static void printOpenRestaurants(
            DeliveryDataBase system) {

        system.getRestaurants()
                .stream()
                .filter(Restaurant::isOpen)
                .forEach(System.out::println);
    }

    /**
     * Prints all available riders.
     */
    public static void printAvailableRiders(
            DeliveryDataBase system) {

        system.getRiders()
                .stream()
                .filter(Rider::isAvailable)
                .forEach(System.out::println);
    }

    /**
     * Prints all delivered orders.
     */
    public static void printDeliveredOrders(
            DeliveryDataBase system) {

        system.getOrders()
                .stream()
                .filter(order ->
                order.getStatus()
                == OrderStatus.DELIVERED)
                .forEach(System.out::println);
    }

    /**
     * Calculates total payments.
     */
    public static double getTotalPayments(
            DeliveryDataBase system) {

        return system.getOrders()
                .stream()
                .mapToDouble(
                        Order::getFinalPrice)
                .sum();
    }
    /**
     * Counts open restaurants.
     */
    public static long countOpenRestaurants(
            DeliveryDataBase system) {

        return system.getRestaurants()
                .stream()
                .filter(Restaurant::isOpen)
                .count();
    }

    /**
     * Returns highest rated restaurant.
     */
    public static Restaurant getBestRestaurant(
            DeliveryDataBase system) {

        return system.getRestaurants()
                .stream()
                .max((r1, r2) ->
                        Double.compare(
                                r1.getRating(),
                                r2.getRating()))
                .orElse(null);
    }

    /**
     * Returns lowest rated restaurant.
     */
    public static Restaurant getWorstRestaurant(
            DeliveryDataBase system) {

        return system.getRestaurants()
                .stream()
                .min((r1, r2) ->
                        Double.compare(
                                r1.getRating(),
                                r2.getRating()))
                .orElse(null);
    }

    /**
     * Returns all premium restaurants.
     */
    public static List<Restaurant>
    getPremiumRestaurants(
            DeliveryDataBase system) {

        return system.getRestaurants()
                .stream()
                .filter(r ->
                        r instanceof PremiumRestaurant)
                .collect(
                        Collectors.toList());
    }
}