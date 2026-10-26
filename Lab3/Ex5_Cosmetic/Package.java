package Lab3.Ex5_Cosmetic;

import java.util.ArrayList;
import java.util.List;

public abstract class Package {
    private String packageName;
    private List<Product> products = new ArrayList<>();

    public Package(String packageName) {
        setPackageName(packageName);
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        if (packageName == null || packageName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid package name!");
        }
        this.packageName = packageName.trim();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("Invalid product list!");
        }
        this.products = products;
    }

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    public long getPackagePrice() {
        long sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }

    public abstract boolean isValid();

    @Override
    public String toString() {
        return String.format("%s | Price: %,d VND | Products: %s",
                packageName, getPackagePrice(), products);
    }
}
