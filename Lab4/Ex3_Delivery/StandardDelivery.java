package Lab4.Ex3_Delivery;

public class StandardDelivery extends Delivery {

    public StandardDelivery(String orderId, String customerName, double distance, double weight) {
        super(orderId, customerName, distance, weight);
    }

    public StandardDelivery(String orderId, double distance, double weight) {
        super(orderId, distance, weight);
    }

    @Override
    public double calculateShippingFee() {
        return 15000 + (3000 * getDistance()) + (2000 * getWeight());
    }

    @Override
    public String toString() {
        return String.format("[Standard Delivery] %s", super.toString());
    }
}
