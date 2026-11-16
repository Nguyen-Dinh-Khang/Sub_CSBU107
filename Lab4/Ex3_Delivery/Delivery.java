package Lab4.Ex3_Delivery;

public abstract class Delivery {

    private static int deliveryCount = 0;

    private String orderId;
    private String customerName;
    private double distance;
    private double weight;

    public Delivery(String orderId, String customerName, double distance, double weight) {
        setOrderId(orderId);
        setCustomerName(customerName);
        setDistance(distance);
        setWeight(weight);
        deliveryCount++;
    }

    public Delivery(String orderId, double distance, double weight) {
        this(orderId, "Guest Customer", distance, weight);
    }

    public static int getDeliveryCount() {
        return deliveryCount;
    }

    public static String getStaticExplanation() {
        return "Explanation: The 'deliveryCount' is declared static because it belongs to the Delivery class itself,\n"
             + "not to any single delivery instance. It maintains a shared counter that persists across all instantiated objects,\n"
             + "tracking the total number of orders created regardless of their concrete delivery type.";
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be empty!");
        }
        this.orderId = orderId.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty!");
        }
        this.customerName = customerName.trim();
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be greater than 0 km!");
        }
        this.distance = distance;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0 kg!");
        }
        this.weight = weight;
    }

    public abstract double calculateShippingFee();

    @Override
    public String toString() {
        return String.format("Order ID: %s | Customer: %s | Distance: %.1f km | Weight: %.1f kg",
                orderId, customerName, distance, weight);
    }
}
