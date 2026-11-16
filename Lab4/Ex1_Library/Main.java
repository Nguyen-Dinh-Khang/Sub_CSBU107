package Lab4.Ex1_Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<LibraryItem> List = new ArrayList<>();

    public static void main(String[] args) {

        LoadSample();

        int choice;
        do {
            System.out.println("\n=== Library Borrowing Fee Management ===");
            System.out.println("1. Display all items");
            System.out.println("2. Input N items");
            System.out.println("3. Search by ID");
            System.out.println("4. The number of each type");
            System.out.println("5. The total borrowing revenue");
            System.out.println("6. Find item with highest fee");
            System.out.println("0. exit");
            System.out.print("Select an option: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1 -> displayAll();
                case 2 -> Input();
                case 3 -> Search();
                case 4 -> Count();
                case 5 -> Total_Revenue();
                case 6 -> Highest_Fee_Item();
                case 0 -> System.out.println("Program exited.");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    private static void displayAll() {
        System.out.println("\n=== ALL BORROWED ITEMS ===");
        if (List.isEmpty()) {
            System.out.println("No items in library.");
            return;
        }
        for (LibraryItem item : List) {
            System.out.printf("%s | Borrowing Fee: %,d VND%n", item.displayInfo(), item.calculateFee());
        }
    }

    private static void LoadSample(){
        List.add(new PrintedBook("001", "PrintedBook1", "Nguyễn A", 3, 200));
        List.add(new Magazine("002", "Magazine1", "Nguyễn B", 3, 12));
    }

    private static void Input_PrintedBook(){
        System.out.println("Input Printed Book:");
        try {
            System.out.print("ID: ");
            String ID = sc.nextLine();

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Borrowed day: ");
            int day = Integer.parseInt(sc.nextLine());

            System.out.print("Number of pages: ");
            int page = Integer.parseInt(sc.nextLine());

            List.add(new PrintedBook(ID, title, author, day, page));
        } catch (NumberFormatException e){
            System.out.println("Invalid input!");
        }
    }

    private static void Input_Magazine(){
        System.out.println("Input Magazine:");
        try {
            System.out.print("ID: ");
            String ID = sc.nextLine();

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Borrowed day: ");
            int day = Integer.parseInt(sc.nextLine());

            System.out.print("Number of issues: ");
            int issue = Integer.parseInt(sc.nextLine());

            List.add(new Magazine(ID, title, author, day, issue));
        } catch (NumberFormatException e){
            System.out.println("Invalid input!");
        }
    }

    private static void Input(){
        System.out.println("\n=== INPUT N ITEM ===");
        try {
            System.err.print("The number of item: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i=0; i < n; i++){
                System.out.println("1. Printed Book");
                System.out.println("2. Magazine");
                System.out.print("What type you want to input: ");
                int choice_input = Integer.parseInt(sc.nextLine());

                switch (choice_input){
                    case 1 -> Input_PrintedBook();
                    case 2 -> Input_Magazine();
                    default -> System.out.println("Invalid type!");
                }
            }
        } catch (NumberFormatException e){
            System.out.println("Invalid input!");
        }
    }

    private static void Search(){
        System.out.println("\n=== SEARCH BY ID ===");
        System.out.print("Input ID: ");
        String ID = sc.nextLine();

        for (LibraryItem l : List){
            if (l.getID().equals(ID)){
                System.out.println(l);
                return;
            }
        }

        System.out.println("No item with ID " + ID + "!");
    }

    private static void Count(){
        System.out.println("\n=== COUNT THE NUMBER OF ITEM EACH TYPE ===");
        int Printed = 0;
        int Magazine = 0;

        for (LibraryItem l : List){
            if (l instanceof PrintedBook){
                Printed += 1;
            } else {
                Magazine += 1;
            }
        }

        System.out.println("Printed Book: " + Printed);
        System.out.println("Magazine: " + Magazine);
    }

    private static void Total_Revenue(){
        System.out.println("\n=== THE TOTAL REVENUE ===");
        int total = 0;

        for (LibraryItem l : List){
            total += l.calculateFee();
        }

        System.out.println("The total of revenue: " + total);
    }

    private static void Highest_Fee_Item(){
        System.out.println("\n=== THE ITEM WITH THE HIGHEST FEE ===");
        LibraryItem result = null;
        int highest_fee = 0;

        for (LibraryItem l : List){
            if (l.calculateFee() > highest_fee){
                result = l;
                highest_fee = l.calculateFee();
            }
        }

        if (result != null){
            System.out.printf("%s | Borrowing Fee: %,d VND%n", result.displayInfo(), result.calculateFee());
        } else {
            System.out.println("No items found.");
        }
    }
}
