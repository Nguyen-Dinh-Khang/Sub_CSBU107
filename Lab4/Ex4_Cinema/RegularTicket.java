package Lab4.Ex4_Cinema;

public class RegularTicket extends Ticket {
    public static final double UNIT_PRICE = 80000.0;

    public RegularTicket(String id, String movieTitle, int quantity) {
        super(id, movieTitle, quantity);
    }

    public RegularTicket(String id, String movieTitle) {
        super(id, movieTitle);
    }

    @Override
    public double getUnitPrice() {
        return UNIT_PRICE;
    }

    @Override
    public double getDiscountRate() {
        return (getQuantity() >= 5) ? 0.10 : 0.0;
    }

    @Override
    public String toString() {
        return String.format("[Regular] %s", super.toString());
    }
}
