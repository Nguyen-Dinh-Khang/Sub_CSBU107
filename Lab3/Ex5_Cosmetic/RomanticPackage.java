package Lab3.Ex5_Cosmetic;

public class RomanticPackage extends Package {
    public RomanticPackage() {
        super("Romantic Package");
    }

    @Override
    public boolean isValid() {
        // Romantic Package: Bắt buộc phải có Rose Perfume
        for (Product p : getProducts()) {
            if ("Rose Perfume".equalsIgnoreCase(p.getType())) {
                return true;
            }
        }
        return false;
    }
}
