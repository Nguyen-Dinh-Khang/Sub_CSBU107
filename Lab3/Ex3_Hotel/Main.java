package Lab3.Ex3_Hotel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Room> rooms = new ArrayList<>();
    private static final List<Staff> staffList = new ArrayList<>();
    private static final DecimalFormat currencyFormat = new DecimalFormat("#,### VND");

    public static void main(String[] args) {
        // Nạp sẵn dữ liệu mẫu (Sample data)
        loadSampleData();

        int choice;
        do {
            System.out.println("\n=== HOTEL ROOM RENTAL MANAGEMENT ===");
            System.out.println("1. Add new Room");
            System.out.println("2. Add Guest to a Room");
            System.out.println("3. Remove Guest from a Room");
            System.out.println("4. Display all Rooms and Guests");
            System.out.println("5. Calculate Rental Cost and Total Revenue");
            System.out.println("6. Display Staff List");
            System.out.println("0. Exit");
            System.out.print("Choose function: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1 -> addNewRoom();
                case 2 -> addGuestToRoom();
                case 3 -> removeGuestFromRoom();
                case 4 -> displayAllRooms();
                case 5 -> calculateRentalCost();
                case 6 -> displayStaffList();
                case 0 -> System.out.println("End program.");
                default -> System.out.println("Invalid choice, please try again!");
            }
        } while (choice != 0);
    }

    private static void loadSampleData() {
        // Sample 1: Phòng VIP2 thuê 3 ngày (Ví dụ trong đề: 700,000 x 3 = 2,100,000 VND)
        Room room1 = new Room("VIP2", 3);
        room1.addGuest(new Guest("Nguyen Van A", 28, "079203001234"));
        rooms.add(room1);

        // Sample 2: Phòng VIP1 thuê 2 ngày (900,000 x 2 = 1,800,000 VND)
        Room room2 = new Room("VIP1", 2);
        room2.addGuest(new Guest("Tran Thi B", 32, "079203005678"));
        rooms.add(room2);

        // Sample 3: Nhân viên khách sạn
        staffList.add(new Staff("Le Van Quan Ly", 35, "LID-001", "NV01"));
    }

    private static void addNewRoom() {
        System.out.println("\n--- Add New Room ---");
        try {
            System.out.print("Room type (VIP1 / VIP2 / VIP3): ");
            String type = scanner.nextLine();
            System.out.print("Number of rental days: ");
            int days = Integer.parseInt(scanner.nextLine());

            Room room = new Room(type, days);
            rooms.add(room);
            System.out.println("Room added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Rental days must be an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addGuestToRoom() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available. Please add a room first!");
            return;
        }

        System.out.println("\n--- Add Guest to Room ---");
        displayRoomListBrief();

        try {
            System.out.print("Select room index: ");
            int roomIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (roomIndex < 0 || roomIndex >= rooms.size()) {
                System.out.println("Invalid room index!");
                return;
            }

            System.out.print("Guest CCCD (Citizen ID): ");
            String cccd = scanner.nextLine();
            System.out.print("Guest Full Name: ");
            String name = scanner.nextLine();
            System.out.print("Guest Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            Guest guest = new Guest(name, age, cccd);
            rooms.get(roomIndex).addGuest(guest);
            System.out.println("Guest added to Room " + (roomIndex + 1) + " successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Age must be an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void removeGuestFromRoom() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available!");
            return;
        }

        System.out.println("\n--- Remove Guest from Room ---");
        displayRoomListBrief();

        try {
            System.out.print("Select room index: ");
            int roomIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (roomIndex < 0 || roomIndex >= rooms.size()) {
                System.out.println("Invalid room index!");
                return;
            }

            Room room = rooms.get(roomIndex);
            List<Person> guests = room.getGuests();
            if (guests.isEmpty()) {
                System.out.println("This room has no guests.");
                return;
            }

            System.out.println("Current guests in Room " + (roomIndex + 1) + ":");
            for (Person p : guests) {
                System.out.println(" - " + p);
            }

            System.out.print("Enter CCCD of guest to remove: ");
            String cccd = scanner.nextLine();

            Person foundGuest = null;
            for (Person p : guests) {
                if (p instanceof Guest g && g.getCitizenId().equalsIgnoreCase(cccd)) {
                    foundGuest = p;
                    break;
                }
            }

            if (foundGuest != null) {
                room.removeGuest(foundGuest);
                System.out.println("Guest removed successfully!");
            } else {
                System.out.println("No guest found with CCCD: " + cccd);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number.");
        }
    }

    private static void displayAllRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms in the system.");
            return;
        }

        System.out.println("\n--- ALL ROOMS & GUESTS ---");
        for (int i = 0; i < rooms.size(); i++) {
            Room r = rooms.get(i);
            System.out.printf("Room #%d: Type: %s | Price/day: %s | Days: %d | Cost: %s\n",
                    (i + 1),
                    r.getRoomType(),
                    currencyFormat.format(r.getDailyPrice()),
                    r.getRentalDays(),
                    currencyFormat.format(r.calculateRentalCost()));

            List<Person> guests = r.getGuests();
            if (guests.isEmpty()) {
                System.out.println("   No guests staying in this room.");
            } else {
                System.out.println("   Guests:");
                for (Person g : guests) {
                    System.out.println("    - " + g);
                }
            }
        }
    }

    private static void calculateRentalCost() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms in the system.");
            return;
        }

        System.out.println("\n--- RENTAL COST CALCULATION ---");
        long totalRevenue = 0;
        for (int i = 0; i < rooms.size(); i++) {
            Room r = rooms.get(i);
            int cost = r.calculateRentalCost();
            totalRevenue += cost;
            System.out.printf("Room #%d [%s, %d day(s)]: %s x %d = %s\n",
                    (i + 1),
                    r.getRoomType(),
                    r.getRentalDays(),
                    currencyFormat.format(r.getDailyPrice()),
                    r.getRentalDays(),
                    currencyFormat.format(cost));
        }

        System.out.println("----------------------------------------------");
        System.out.printf("TOTAL RENTAL REVENUE: %s\n", currencyFormat.format(totalRevenue));
    }

    private static void displayStaffList() {
        if (staffList.isEmpty()) {
            System.out.println("No staff in the system.");
            return;
        }

        System.out.println("\n--- HOTEL STAFF LIST ---");
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }

    private static void displayRoomListBrief() {
        for (int i = 0; i < rooms.size(); i++) {
            Room r = rooms.get(i);
            System.out.printf("%d. Room #%d [%s, %d days, %d guest(s)]\n",
                    (i + 1), (i + 1), r.getRoomType(), r.getRentalDays(), r.getGuests().size());
        }
    }
}
