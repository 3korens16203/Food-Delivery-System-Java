package hw;

/**
 * Thrown when restaurant is not found.
 */
public class RestaurantNotFoundException
        extends Exception {
	private static final long serialVersionUID = 1L;

    public RestaurantNotFoundException(
            String message) {

        super(message);
    }
}
