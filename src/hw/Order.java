package hw;

import java.util.Objects;

/**
 * Tracks individual transactions, linked to specific clients, couriers, and eateries.
 */
public class Order {
    private String orderCode;
    private String customerCode;
    private Restaurant restaurant;
    private String riderCode;
    private String orderDate;
    private String deliveryDate;
    private double baseAmount;
    private double finalPrice;
    private OrderStatus status;

    //  Generate Constructor using fields
    public Order(String orderCode, String customerCode, Restaurant restaurant, double baseAmount, String orderDate) {
        this.orderCode = orderCode;
        this.customerCode = customerCode;
        this.restaurant = restaurant;
        this.baseAmount = baseAmount;
        this.orderDate = orderDate;
        this.deliveryDate = "Not Delivered Yet";
        this.status = OrderStatus.SENT;
        this.riderCode = null;
        this.finalPrice = restaurant.calculateFinalPrice(baseAmount); // Dynamic Runtime Polymorphism
    }

    //Generate Getters & Setters
    public String getOrderCode() { return orderCode; }
    public void setOrderCode(String orderCode) { this.orderCode = orderCode; }

    public String getCustomerCode() { return customerCode; }
    public void setCustomerCode(String customerCode) { this.customerCode = customerCode; }

    public Restaurant getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }

    public String getRiderCode() { return riderCode; }
    public void setRiderCode(String riderCode) { this.riderCode = riderCode; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public String getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(String deliveryDate) { this.deliveryDate = deliveryDate; }

    public double getBaseAmount() { return baseAmount; }
    public void setBaseAmount(double baseAmount) { this.baseAmount = baseAmount; }

    public double getFinalPrice() { return finalPrice; }
    public void setFinalPrice(double finalPrice) { this.finalPrice = finalPrice; }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    // Generate equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderCode, order.orderCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderCode);
    }

    //  Generate toString
    @Override
    public String toString() {
        return "Order{" +
                "orderCode='" + orderCode + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", restaurant=" + restaurant.getRestaurantName() +
                ", riderCode='" + riderCode + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", baseAmount=" + baseAmount +
                ", finalPrice=" + finalPrice +
                ", status='" + status + '\'' +
                '}';
    }
}