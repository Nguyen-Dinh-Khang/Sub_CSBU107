package Lab3.Ex5_Cosmetic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Order> orders = new ArrayList<>();
    private static final DecimalFormat currencyFormat = new DecimalFormat("#,### VND");

    public static void main(String[] args) {
        // Nạp sẵn dữ liệu mẫu theo ví dụ trong đề bài
        loadSampleData();

        int choice;
        do {
            System.out.println("\n=== COSMETIC STORE ORDER MANAGEMENT ===");
            System.out.println("1. Input N Orders");
            System.out.println("2. Display all Orders");
            System.out.println("3. Save Orders to order_list.txt");
            System.out.println("0. Exit");
            System.out.print("Choose function: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1 -> inputNOrders();
                case 2 -> displayOrders();
                case 3 -> saveOrdersToFile();
                case 0 -> System.out.println("End program.");
                default -> System.out.println("Invalid choice, please try again!");
            }
        } while (choice != 0);
    }

    private static void loadSampleData() {
        // Sample order theo ví dụ đề bài:
        // Gói Romantic gồm 50ml Rose Perfume (20k/ml) + 100ml Dry Skin Shower Gel (20k/ml) = 3,000,000 VND
        Customer c1 = new Customer("KH01", "Nguyen Van A", "123 Le Loi, D1, HCMC", "0901234567");
        Package p1 = new RomanticPackage();
        p1.addProduct(new Product("P01", "Rose Perfume", 50, 20000));
        p1.addProduct(new Product("P06", "Dry Skin Shower Gel", 100, 20000));
        orders.add(new Order("ORD01", c1, "2026-10-25", p1));
    }

    private static void inputNOrders() {
        try {
            System.out.print("Enter number of orders (N): ");
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("\n--- Input Order #" + (i + 1) + " ---");
                System.out.print("Order ID: ");
                String orderId = scanner.nextLine();
                System.out.print("Invoice Date (YYYY-MM-DD): ");
                String date = scanner.nextLine();

                System.out.print("Customer ID: ");
                String cId = scanner.nextLine();
                System.out.print("Customer Name: ");
                String cName = scanner.nextLine();
                System.out.print("Customer Address: ");
                String cAddress = scanner.nextLine();
                System.out.print("Customer Phone: ");
                String cPhone = scanner.nextLine();
                Customer customer = new Customer(cId, cName, cAddress, cPhone);

                System.out.println("Select Package Type: 1. Romantic Package | 2. Fresh-Air Package");
                System.out.print("Your choice: ");
                int pkgChoice = Integer.parseInt(scanner.nextLine());

                Package pkg = (pkgChoice == 1) ? new RomanticPackage() : new FreshAirPackage();
                inputProductsForPackage(pkg);

                orders.add(new Order(orderId, customer, date, pkg));
                System.out.println("Order added successfully!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void inputProductsForPackage(Package pkg) {
        System.out.println("Choose products to add to package (enter 0 to finish):");
        System.out.println("1. Rose Perfume (20,000 VND/ml)");
        System.out.println("2. Chamomile Perfume (15,000 VND/ml)");
        System.out.println("3. Dry Hair Shampoo (20,000 VND/ml)");
        System.out.println("4. Oily Hair Shampoo - Standard 1 (30,000 VND/ml)");
        System.out.println("5. Oily Hair Shampoo - Standard 2 (40,000 VND/ml)");
        System.out.println("6. Dry Skin Shower Gel (20,000 VND/ml)");
        System.out.println("7. Oily Skin Shower Gel (40,000 VND/ml)");

        while (true) {
            try {
                System.out.print("Product choice (1-7, 0 to stop): ");
                int pChoice = Integer.parseInt(scanner.nextLine());
                if (pChoice == 0) break;

                String type = "";
                int unitPrice = 0;
                switch (pChoice) {
                    case 1 -> { type = "Rose Perfume"; unitPrice = 20000; }
                    case 2 -> { type = "Chamomile Perfume"; unitPrice = 15000; }
                    case 3 -> { type = "Dry Hair Shampoo"; unitPrice = 20000; }
                    case 4 -> { type = "Oily Hair Shampoo - Standard 1"; unitPrice = 30000; }
                    case 5 -> { type = "Oily Hair Shampoo - Standard 2"; unitPrice = 40000; }
                    case 6 -> { type = "Dry Skin Shower Gel"; unitPrice = 20000; }
                    case 7 -> { type = "Oily Skin Shower Gel"; unitPrice = 40000; }
                    default -> {
                        System.out.println("Invalid product option!");
                        continue;
                    }
                }

                System.out.print("Product ID: ");
                String pId = scanner.nextLine();
                System.out.print("Volume (ml): ");
                int vol = Integer.parseInt(scanner.nextLine());

                pkg.addProduct(new Product(pId, type, vol, unitPrice));
                System.out.println("Product added to package!");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        if (!pkg.isValid()) {
            System.out.println("Warning: This package is missing mandatory products per requirements!");
        }
    }

    private static void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        System.out.println("\n================ ORDER LIST ================");
        for (Order o : orders) {
            System.out.println(o);
            System.out.println("--------------------------------------------");
        }
    }

    private static void saveOrdersToFile() {
        if (orders.isEmpty()) {
            System.out.println("No orders to save.");
            return;
        }

        String fileName = "order_list.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Order o : orders) {
                writer.println(o);
                writer.println("--------------------------------------------");
            }
            System.out.println("Saved " + orders.size() + " order(s) successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}
