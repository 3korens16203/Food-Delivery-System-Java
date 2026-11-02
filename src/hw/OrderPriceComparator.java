package hw;

import java.util.Comparator;

/**
 * Compares orders by final price (highest first).
 */
public class OrderPriceComparator
        implements Comparator<Order> {

    @Override
    public int compare(
            Order o1,
            Order o2) {

        return Double.compare(
                o2.getFinalPrice(),
                o1.getFinalPrice());
    }
}
