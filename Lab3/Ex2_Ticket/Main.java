package Lab3.Ex2_Ticket;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Ticket> tickets = new ArrayList<>();
    private static final DecimalFormat currencyFormat = new DecimalFormat("#,### VND");

    public static void main(String[] args) {
        // Load sample test data:
        // 1 Full Package ticket + 1 Partial ticket (4 games) -> Total: 350,000 VND
        loadSampleData();

        int choice;
        do {
            System.out.println("\n=== DAM SEN PARK TICKET MANAGEMENT ===");
            System.out.println("1. Add Full Package Ticket");
            System.out.println("2. Add Partial Ticket");
            System.out.println("3. Display Sold Tickets");
            System.out.println("4. Calculate Total Revenue");
            System.out.println("5. Count Sold Partial Tickets");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1 -> addFullPackageTicket();
                case 2 -> addPartialTicket();
                case 3 -> displayAllTickets();
                case 4 -> calculateTotalRevenue();
                case 5 -> countPartialTickets();
                case 0 -> System.out.println("Program exited.");
                default -> System.out.println("Invalid choice. Please try again!");
            }
        } while (choice != 0);
    }

    private static void loadSampleData() {
        // Sample data:
        // 1 Full ticket: 200,000 VND (up to 30 games)
        tickets.add(new Full("T01", "Nguyen Van A", 2003));
        // 1 Partial ticket: 70,000 + 4 * 20,000 = 150,000 VND
        tickets.add(new Partial("T02", "Tran Thi B", 2005, 4));
    }

    private static void addFullPackageTicket() {
        System.out.println("\n--- Add Full Package Ticket ---");
        try {
            System.out.print("Ticket ID: ");
            String id = scanner.nextLine();
            System.out.print("Customer Name: ");
            String name = scanner.nextLine();
            System.out.print("Birth Year: ");
            int birthYear = Integer.parseInt(scanner.nextLine());

            tickets.add(new Full(id, name, birthYear));
            System.out.println("Full package ticket added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Birth year must be an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Data error: " + e.getMessage());
        }
    }

    private static void addPartialTicket() {
        System.out.println("\n--- Add Partial Ticket ---");
        try {
            System.out.print("Ticket ID: ");
            String id = scanner.nextLine();
            System.out.print("Customer Name: ");
            String name = scanner.nextLine();
            System.out.print("Birth Year: ");
            int birthYear = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of Games: ");
            int games = Integer.parseInt(scanner.nextLine());

            tickets.add(new Partial(id, name, birthYear, games));
            System.out.println("Partial ticket added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Birth year and number of games must be integers.");
        } catch (IllegalArgumentException e) {
            System.out.println("Data error: " + e.getMessage());
        }
    }

    private static void displayAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets found in the system.");
            return;
        }
        System.out.println("\n--- SOLD TICKETS LIST ---");
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    private static void calculateTotalRevenue() {
        double totalRevenue = 0;
        // Polymorphism: ticket.getPrice() dynamically calculates price per subclass
        for (Ticket ticket : tickets) {
            totalRevenue += ticket.getPrice();
        }
        System.out.printf("\nTotal revenue from %d ticket(s): %s\n", 
                tickets.size(), currencyFormat.format(totalRevenue));
    }

    private static void countPartialTickets() {
        int partialCount = 0;
        for (Ticket ticket : tickets) {
            if (ticket instanceof Partial) {
                partialCount++;
            }
        }
        System.out.printf("\nTotal partial ticket(s) sold: %d\n", partialCount);
    }
}