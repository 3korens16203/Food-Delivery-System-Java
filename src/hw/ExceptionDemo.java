package hw;

/**
 * Demonstrates custom exceptions.
 */
public class ExceptionDemo {

    /**
     * Checks customer.
     */
    public static void checkCustomer(
            String customerCode)
            throws CustomerNotFoundException {

        if (customerCode == null
                || customerCode.isEmpty()) {

            throw new CustomerNotFoundException(
                    "Customer not found.");
        }
    }

    /**
     * Checks restaurant.
     */
    public static void checkRestaurant(
            String restaurantCode)
            throws RestaurantNotFoundException {

        if (restaurantCode == null
                || restaurantCode.isEmpty()) {

            throw new RestaurantNotFoundException(
                    "Restaurant not found.");
        }
    }

    /**
     * Checks balance.
     */
    public static void checkBalance(
            double balance,
            double amount)
            throws InsufficientBalanceException {

        if (balance < amount) {

            throw new InsufficientBalanceException(
                    "Insufficient balance.");
        }
    }

    /**
     * Checks rider availability.
     */
    public static void checkRider(
            boolean available)
            throws DeliveryPersonUnavailableException {

        if (!available) {

            throw new DeliveryPersonUnavailableException(
                    "No rider available.");
        }
    }
}