package Lab3.Ex5_Cosmetic;

public class Product {
    private String id;
    private String type;
    private int volume;
    private int unitPrice;

    public Product(String id, String type, int volume, int unitPrice) {
        setId(id);
        setType(type);
        setVolume(volume);
        setUnitPrice(unitPrice);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid product ID!");
        }
        this.id = id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid product type!");
        }
        this.type = type.trim();
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("Volume must be greater than 0!");
        }
        this.volume = volume;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Unit price must be greater than 0!");
        }
        this.unitPrice = unitPrice;
    }

    public long getPrice() {
        return (long) volume * unitPrice;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Type: %s | Volume: %dml | Price: %,d VND",
                id, type, volume, getPrice());
    }
}
