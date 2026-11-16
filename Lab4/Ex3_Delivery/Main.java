package Lab4.Ex3_Delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Delivery> orders = new ArrayList<>();

    public static void main(String[] args) {
        loadSample();

        int choice;
        do {
            System.out.println("==================================================");
            System.out.println("        ONLINE ORDER DELIVERY MANAGEMENT          ");
            System.out.println("==================================================");
            System.out.println("1. Display All Deliveries & Fees");
            System.out.println("2. Search Order by Order ID");
            System.out.println("3. Calculate Total Shipping Revenue");
            System.out.println("4. Count Orders by Delivery Type");
            System.out.println("5. Filter Orders Exceeding Fee Threshold");
            System.out.println("6. Display Delivery Count (Static Member Concept)");
            System.out.println("7. Add New Delivery Order");
            System.out.println("0. Exit");
            System.out.print("Please enter your choice (0-7): ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1;
            }
            System.out.println();

            switch (choice) {
                case 0 -> System.out.println("Program exited. Goodbye!");
                case 1 -> displayAllDeliveries();
                case 2 -> searchByOrderId();
                case 3 -> displayTotalRevenue();
                case 4 -> countOrdersByType();
                case 5 -> filterOrdersByFeeThreshold();
                case 6 -> displayStaticCounter();
                case 7 -> addNewDelivery();
                default -> System.out.println("Invalid option! Please enter a number between 0 and 7.");
            }
            System.out.println();
        } while (choice != 0);
    }

    private static void loadSample() {
        orders.add(new StandardDelivery("ORD01", "Alice Smith", 10.0, 2.0));
        orders.add(new ExpressDelivery("ORD02", "Bob Johnson", 10.0, 2.0));
    }

    private static void displayAllDeliveries() {
        System.out.println("----------------- ALL DELIVERY ORDERS -----------------");
        if (orders.isEmpty()) {
            System.out.println("No delivery orders recorded.");
            return;
        }

        for (Delivery d : orders) {
            System.out.printf("%s | Shipping Fee: %,.0f VND%n", d, d.calculateShippingFee());
        }
    }

    public static Delivery findOrder(String orderId) {
        if (orderId == null) return null;
        for (Delivery d : orders) {
            if (d.getOrderId().equalsIgnoreCase(orderId.trim())) {
                return d;
            }
        }
        return null;
    }

    private static void searchByOrderId() {
        System.out.println("--- Search Order by ID ---");
        System.out.print("Enter Order ID: ");
        String id = sc.nextLine();

        Delivery d = findOrder(id);
        if (d != null) {
            System.out.println("Found Order:");
            System.out.printf("%s | Shipping Fee: %,.0f VND%n", d, d.calculateShippingFee());
        } else {
            System.out.println("No delivery order found with ID: " + id);
        }
    }

    public static double calculateTotalRevenue() {
        double total = 0;
        for (Delivery d : orders) {
            total += d.calculateShippingFee();
        }
        return total;
    }

    private static void displayTotalRevenue() {
        System.out.println("--- Total Shipping Revenue ---");
        System.out.printf("Total Shipping Revenue (%d orders): %,.0f VND%n", orders.size(), calculateTotalRevenue());
    }

    private static void countOrdersByType() {
        System.out.println("--- Order Count by Delivery Type ---");
        int standardCount = 0;
        int expressCount = 0;

        for (Delivery d : orders) {
            if (d instanceof ExpressDelivery) {
                expressCount++;
            } else if (d instanceof StandardDelivery) {
                standardCount++;
            }
        }

        System.out.printf("Standard Deliveries: %d order(s)%n", standardCount);
        System.out.printf("Express Deliveries : %d order(s)%n", expressCount);
        System.out.printf("Total Deliveries   : %d order(s)%n", orders.size());
    }

    private static void filterOrdersByFeeThreshold() {
        System.out.println("--- Filter Orders by Shipping Fee Threshold ---");
        System.out.print("Enter minimum shipping fee threshold (VND): ");
        double threshold;
        try {
            threshold = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid threshold value!");
            return;
        }

        List<Delivery> filtered = new ArrayList<>();
        for (Delivery d : orders) {
            if (d.calculateShippingFee() > threshold) {
                filtered.add(d);
            }
        }

        if (filtered.isEmpty()) {
            System.out.printf("No orders found with shipping fee exceeding %,.0f VND.%n", threshold);
        } else {
            System.out.printf("Found %d order(s) with fee > %,.0f VND:%n", filtered.size(), threshold);
            for (Delivery d : filtered) {
                System.out.printf("%s | Shipping Fee: %,.0f VND%n", d, d.calculateShippingFee());
            }
        }
    }

    private static void displayStaticCounter() {
        System.out.println("--- Static Member Inspection ---");
        System.out.printf("Total Delivery objects created in memory: %d%n", Delivery.getDeliveryCount());
        System.out.println();
        System.out.println(Delivery.getStaticExplanation());
    }

    private static void addNewDelivery() {
        System.out.println("--- Add New Delivery Order ---");
        System.out.println("1. Standard Delivery (Base 15,000 + 3,000/km + 2,000/kg)");
        System.out.println("2. Express Delivery  (Base 30,000 + 5,000/km + 4,000/kg)");
        System.out.println("0. Cancel");
        System.out.print("Choose type: ");

        int type;
        try {
            type = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid selection!");
            return;
        }

        if (type == 0) return;
        if (type != 1 && type != 2) {
            System.out.println("Invalid type selection.");
            return;
        }

        try {
            System.out.print("Enter Order ID: ");
            String orderId = sc.nextLine().trim();
            if (findOrder(orderId) != null) {
                System.out.println("Error: Order ID already exists!");
                return;
            }

            System.out.print("Enter Customer Name: ");
            String customerName = sc.nextLine();

            System.out.print("Enter Distance in km (> 0): ");
            double distance = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Enter Parcel Weight in kg (> 0): ");
            double weight = Double.parseDouble(sc.nextLine().trim());

            Delivery delivery = (type == 1)
                    ? new StandardDelivery(orderId, customerName, distance, weight)
                    : new ExpressDelivery(orderId, customerName, distance, weight);

            orders.add(delivery);
            System.out.println("Order added successfully!");
            System.out.printf("Created: %s | Shipping Fee: %,.0f VND%n", delivery, delivery.calculateShippingFee());
        } catch (NumberFormatException e) {
            System.out.println("Input Error: Distance and Weight must be valid numbers!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
