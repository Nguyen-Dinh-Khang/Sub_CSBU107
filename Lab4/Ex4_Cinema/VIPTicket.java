package Lab4.Ex4_Cinema;

public class VIPTicket extends Ticket {
    public static final double UNIT_PRICE = 150000.0;

    public VIPTicket(String id, String movieTitle, int quantity) {
        super(id, movieTitle, quantity);
    }

    public VIPTicket(String id, String movieTitle) {
        super(id, movieTitle);
    }

    @Override
    public double getUnitPrice() {
        return UNIT_PRICE;
    }

    @Override
    public double getDiscountRate() {
        return (getQuantity() >= 3) ? 0.15 : 0.0;
    }

    @Override
    public String toString() {
        return String.format("[VIP    ] %s", super.toString());
    }
}
