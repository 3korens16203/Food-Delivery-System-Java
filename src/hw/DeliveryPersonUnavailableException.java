package hw;

/**
 * Thrown when no rider is available.
 */
public class DeliveryPersonUnavailableException
        extends Exception {
	private static final long serialVersionUID = 1L;

    public DeliveryPersonUnavailableException(
            String message) {

        super(message);
    }
}
