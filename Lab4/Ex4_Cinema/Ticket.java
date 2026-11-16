package Lab4.Ex4_Cinema;

public abstract class Ticket {
    private String id;
    private String movieTitle;
    private int quantity;

    public Ticket(String id, String movieTitle, int quantity) {
        setId(id);
        setMovieTitle(movieTitle);
        setQuantity(quantity);
    }

    public Ticket(String id, String movieTitle) {
        this(id, movieTitle, 1);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket ID cannot be empty!");
        }
        this.id = id.trim();
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        if (movieTitle == null || movieTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Movie title cannot be empty!");
        }
        this.movieTitle = movieTitle.trim();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1!");
        }
        this.quantity = quantity;
    }

    public abstract double getUnitPrice();
    public abstract double getDiscountRate();

    public double calculateSubtotal() {
        return quantity * getUnitPrice();
    }

    public double calculateDiscountAmount() {
        return calculateSubtotal() * getDiscountRate();
    }

    public double calculateTotalPrice() {
        return calculateSubtotal() - calculateDiscountAmount();
    }

    @Override
    public String toString() {
        return String.format("Ticket ID: %s | Movie: %-15s | Quantity: %2d | Unit Price: %,8.0f VND | Discount: %,7.0f VND | Total: %,9.0f VND",
                id, movieTitle, quantity, getUnitPrice(), calculateDiscountAmount(), calculateTotalPrice());
    }
}
