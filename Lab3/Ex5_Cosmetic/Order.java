package Lab3.Ex5_Cosmetic;

public class Order {
    private String orderId;
    private Customer customer;
    private String invoiceDate;
    private Package pkg;

    public Order(String orderId, Customer customer, String invoiceDate, Package pkg) {
        setOrderId(orderId);
        setCustomer(customer);
        setInvoiceDate(invoiceDate);
        setPkg(pkg);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid order ID!");
        }
        this.orderId = orderId.trim();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null!");
        }
        this.customer = customer;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        if (invoiceDate == null || invoiceDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid invoice date!");
        }
        this.invoiceDate = invoiceDate.trim();
    }

    public Package getPkg() {
        return pkg;
    }

    public void setPkg(Package pkg) {
        if (pkg == null) {
            throw new IllegalArgumentException("Package cannot be null!");
        }
        this.pkg = pkg;
    }

    public long getOrderPrice() {
        return pkg.getPackagePrice();
    }

    @Override
    public String toString() {
        return String.format("Order ID: %s | Date: %s | Total: %,d VND\n  Customer -> %s\n  Package  -> %s",
                orderId, invoiceDate, getOrderPrice(), customer, pkg);
    }
}
