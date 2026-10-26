package Lab3.Ex4_Singer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Singer> singers = new ArrayList<>();
    private static final DecimalFormat currencyFormat = new DecimalFormat("#,### VND");

    public static void main(String[] args) {
        // Nạp sẵn dữ liệu mẫu để kiểm thử
        loadSampleData();

        int choice;
        do {
            System.out.println("\n=== SINGER SALARY MANAGEMENT ===");
            System.out.println("1. Add Regular Singer");
            System.out.println("2. Add Famous Singer");
            System.out.println("3. Display all singers & salaries");
            System.out.println("4. Find highest-paid singer");
            System.out.println("0. Exit");
            System.out.print("Choose function: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1 -> addRegularSinger();
                case 2 -> addFamousSinger();
                case 3 -> displayAllSingers();
                case 4 -> findHighestPaidSinger();
                case 0 -> System.out.println("End program.");
                default -> System.out.println("Invalid choice, please try again!");
            }
        } while (choice != 0);
    }

    private static void loadSampleData() {
        // Sample 1: Ca sĩ thường (3 năm KN, 2000 album, 10 show -> 8,500,000 VND)
        singers.add(new RegularSinger("Nguyen Van A", 3, 2000, 10));
        // Sample 2: Ca sĩ nổi tiếng (5 năm KN, 5000 album, 15 show, 4 gameshow -> 23,000,000 VND)
        singers.add(new FamousSinger("Tran Thi B", 5, 5000, 15, 4));
    }

    private static void addRegularSinger() {
        System.out.println("\n--- Add Regular Singer ---");
        try {
            System.out.print("Full name: ");
            String name = scanner.nextLine();
            System.out.print("Years of experience: ");
            int exp = Integer.parseInt(scanner.nextLine());
            System.out.print("Albums sold: ");
            int albums = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of performances: ");
            int shows = Integer.parseInt(scanner.nextLine());

            singers.add(new RegularSinger(name, exp, albums, shows));
            System.out.println("Added regular singer successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Numeric input required for experience, albums, and shows.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addFamousSinger() {
        System.out.println("\n--- Add Famous Singer ---");
        try {
            System.out.print("Full name: ");
            String name = scanner.nextLine();
            System.out.print("Years of experience: ");
            int exp = Integer.parseInt(scanner.nextLine());
            System.out.print("Albums sold: ");
            int albums = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of performances: ");
            int shows = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of game shows: ");
            int gameShows = Integer.parseInt(scanner.nextLine());

            singers.add(new FamousSinger(name, exp, albums, shows, gameShows));
            System.out.println("Added famous singer successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Numeric input required.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayAllSingers() {
        if (singers.isEmpty()) {
            System.out.println("No singers in the list.");
            return;
        }

        System.out.println("\n--- LIST OF SINGERS & SALARIES ---");
        for (Singer s : singers) {
            System.out.println(s);
        }
    }

    private static void findHighestPaidSinger() {
        if (singers.isEmpty()) {
            System.out.println("No singers in the list.");
            return;
        }

        Singer highest = singers.get(0);
        for (Singer s : singers) {
            if (s.calculateSalary() > highest.calculateSalary()) {
                highest = s;
            }
        }

        System.out.println("\n--- HIGHEST-PAID SINGER ---");
        System.out.println(highest);
    }
}
