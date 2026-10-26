package Lab3.Ex5_Cosmetic;

public class FreshAirPackage extends Package {
    public FreshAirPackage() {
        super("Fresh-Air Package");
    }

    @Override
    public boolean isValid() {
        // Fresh-Air Package: Bắt buộc phải có Oily Hair Shampoo
        for (Product p : getProducts()) {
            if (p.getType().contains("Oily Hair Shampoo")) {
                return true;
            }
        }
        return false;
    }
}
