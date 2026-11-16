package Lab4.Ex3_Delivery;

public class ExpressDelivery extends Delivery {

    public ExpressDelivery(String orderId, String customerName, double distance, double weight) {
        super(orderId, customerName, distance, weight);
    }

    public ExpressDelivery(String orderId, double distance, double weight) {
        super(orderId, distance, weight);
    }

    @Override
    public double calculateShippingFee() {
        return 30000 + (5000 * getDistance()) + (4000 * getWeight());
    }

    @Override
    public String toString() {
        return String.format("[Express Delivery]  %s", super.toString());
    }
}
