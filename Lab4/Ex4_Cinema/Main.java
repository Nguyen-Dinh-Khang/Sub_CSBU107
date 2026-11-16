package Lab4.Ex4_Cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        loadSample();

        int choice;
        do {
            System.out.println("==================================================");
            System.out.println("        CINEMA TICKET SALES MANAGEMENT            ");
            System.out.println("==================================================");
            System.out.println("1. Display All Ticket Purchases");
            System.out.println("2. Search Purchases by Movie Title");
            System.out.println("3. Calculate Total Revenue");
            System.out.println("4. Find Movie Title with Highest Total Revenue");
            System.out.println("5. Display Purchases Sorted by Total Price (High to Low)");
            System.out.println("6. Add New Ticket Purchase");
            System.out.println("0. Exit");
            System.out.print("Please enter your choice (0-6): ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1;
            }
            System.out.println();

            switch (choice) {
                case 0 -> System.out.println("Program exited. Goodbye!");
                case 1 -> displayAllPurchases();
                case 2 -> searchByMovieTitle();
                case 3 -> displayTotalRevenue();
                case 4 -> findMovieWithHighestRevenue();
                case 5 -> displaySortedPurchases();
                case 6 -> addNewTicket();
                default -> System.out.println("Invalid option! Please enter a number from 0 to 6.");
            }
            System.out.println();
        } while (choice != 0);
    }

    private static void loadSample() {
        tickets.add(new RegularTicket("TK01", "Inception", 5));
        tickets.add(new VIPTicket("TK02", "Avatar", 3));
        tickets.add(new RegularTicket("TK03", "Interstellar", 2));
    }

    private static void displayAllPurchases() {
        System.out.println("----------------- ALL TICKET PURCHASES -----------------");
        if (tickets.isEmpty()) {
            System.out.println("No ticket purchases recorded.");
            return;
        }

        for (Ticket t : tickets) {
            System.out.println(t);
        }
    }

    public static Ticket findTicketById(String id) {
        if (id == null) return null;
        for (Ticket t : tickets) {
            if (t.getId().equalsIgnoreCase(id.trim())) {
                return t;
            }
        }
        return null;
    }

    private static void searchByMovieTitle() {
        System.out.println("--- Search Purchases by Movie Title ---");
        System.out.print("Enter movie title: ");
        String title = sc.nextLine().trim();

        List<Ticket> matches = new ArrayList<>();
        double movieRevenue = 0;
        for (Ticket t : tickets) {
            if (t.getMovieTitle().equalsIgnoreCase(title)) {
                matches.add(t);
                movieRevenue += t.calculateTotalPrice();
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No purchases found for movie: " + title);
        } else {
            System.out.printf("Found %d purchase(s) for '%s':%n", matches.size(), title);
            for (Ticket t : matches) {
                System.out.println(t);
            }
            System.out.printf("Subtotal revenue for '%s': %,.0f VND%n", title, movieRevenue);
        }
    }

    public static double calculateTotalRevenue() {
        double total = 0;
        for (Ticket t : tickets) {
            total += t.calculateTotalPrice();
        }
        return total;
    }

    private static void displayTotalRevenue() {
        System.out.println("--- Total Cinema Revenue ---");
        System.out.printf("Total revenue from %d purchases: %,.0f VND%n", tickets.size(), calculateTotalRevenue());
    }

    private static void findMovieWithHighestRevenue() {
        System.out.println("--- Movie with Highest Total Revenue ---");
        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }

        Map<String, Double> revenueByMovie = new HashMap<>();
        for (Ticket t : tickets) {
            String title = t.getMovieTitle();
            revenueByMovie.put(title, revenueByMovie.getOrDefault(title, 0.0) + t.calculateTotalPrice());
        }

        String topMovie = null;
        double maxRevenue = -1;
        for (Map.Entry<String, Double> entry : revenueByMovie.entrySet()) {
            if (entry.getValue() > maxRevenue) {
                maxRevenue = entry.getValue();
                topMovie = entry.getKey();
            }
        }

        System.out.printf("Top grossing movie: '%s' with total revenue of %,.0f VND%n", topMovie, maxRevenue);
    }

    private static void displaySortedPurchases() {
        System.out.println("--- Purchases Sorted by Total Price (High to Low) ---");
        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }

        List<Ticket> sortedList = new ArrayList<>(tickets);
        int n = sortedList.size();

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (sortedList.get(j).calculateTotalPrice() > sortedList.get(maxIdx).calculateTotalPrice()) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                Ticket temp = sortedList.get(i);
                sortedList.set(i, sortedList.get(maxIdx));
                sortedList.set(maxIdx, temp);
            }
        }

        for (int i = 0; i < sortedList.size(); i++) {
            System.out.printf("%d. %s%n", (i + 1), sortedList.get(i));
        }
    }

    private static void addNewTicket() {
        System.out.println("--- Add Ticket Purchase ---");
        System.out.println("1. Regular Ticket (80,000 VND, 10% off if >= 5 tickets)");
        System.out.println("2. VIP Ticket     (150,000 VND, 15% off if >= 3 tickets)");
        System.out.println("0. Cancel");
        System.out.print("Choose ticket type: ");

        int type;
        try {
            type = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid selection!");
            return;
        }

        if (type == 0) return;
        if (type != 1 && type != 2) {
            System.out.println("Invalid selection!");
            return;
        }

        try {
            System.out.print("Enter Ticket ID: ");
            String id = sc.nextLine().trim();
            if (findTicketById(id) != null) {
                System.out.println("Error: Ticket ID already exists! Rejecting duplicate ID.");
                return;
            }

            System.out.print("Enter Movie Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Quantity (>= 1): ");
            int quantity = Integer.parseInt(sc.nextLine().trim());

            Ticket ticket = (type == 1)
                    ? new RegularTicket(id, title, quantity)
                    : new VIPTicket(id, title, quantity);

            tickets.add(ticket);
            System.out.println("Ticket purchase recorded successfully!");
            System.out.println(ticket);
        } catch (NumberFormatException e) {
            System.out.println("Input Error: Quantity must be a valid integer!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
