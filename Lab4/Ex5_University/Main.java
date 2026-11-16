package Lab4.Ex5_University;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<CourseRegistration> courses = new ArrayList<>();

    public static void main(String[] args) {
        loadSample();

        int choice;
        do {
            System.out.println("==================================================");
            System.out.println("     UNIVERSITY COURSE REGISTRATION & TUITION     ");
            System.out.println("==================================================");
            System.out.println("1. Display All Courses & Expected Collections");
            System.out.println("2. Search Course by Course Code");
            System.out.println("3. Compute Total Expected Collection (All Courses)");
            System.out.println("4. Find Course with Largest Expected Collection");
            System.out.println("5. Count Course Types & Weighted Average Tuition");
            System.out.println("6. Add New Course Registration");
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
                case 1 -> displayAllCourses();
                case 2 -> searchByCourseCode();
                case 3 -> displayTotalCollection();
                case 4 -> displayLargestCollectionCourse();
                case 5 -> displayStatisticsAndWeightedAverage();
                case 6 -> addNewCourse();
                default -> System.out.println("Invalid option! Please enter a number between 0 and 6.");
            }
            System.out.println();
        } while (choice != 0);
    }

    private static void loadSample() {
        courses.add(new TheoryCourse("CS101", "Introduction to OOP", 3, 20));
        courses.add(new LabCourse("CS102", "OOP Laboratory", 2, 10, 100000));
    }

    private static void displayAllCourses() {
        System.out.println("----------------- COURSE REGISTRATION LIST -----------------");
        if (courses.isEmpty()) {
            System.out.println("No course registrations available.");
            return;
        }

        for (CourseRegistration c : courses) {
            System.out.println(c);
        }
    }

    public static CourseRegistration findCourseByCode(String code) {
        if (code == null) return null;
        for (CourseRegistration c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code.trim())) {
                return c;
            }
        }
        return null;
    }

    private static void searchByCourseCode() {
        System.out.println("--- Search Course by Code ---");
        System.out.print("Enter Course Code: ");
        String code = sc.nextLine().trim();

        CourseRegistration c = findCourseByCode(code);
        if (c != null) {
            System.out.println("Found Course:");
            System.out.println(c);
        } else {
            System.out.println("No course found with code: " + code);
        }
    }

    public static double computeTotalCollection() {
        double total = 0;
        for (CourseRegistration c : courses) {
            total += c.totalExpectedCollection();
        }
        return total;
    }

    private static void displayTotalCollection() {
        System.out.println("--- Total Expected Tuition Collection ---");
        System.out.printf("Total expected collection across %d course(s): %,.0f VND%n",
                courses.size(), computeTotalCollection());
    }

    public static CourseRegistration findCourseWithLargestCollection() {
        if (courses.isEmpty()) return null;

        CourseRegistration maxCourse = courses.get(0);
        for (CourseRegistration c : courses) {
            if (c.totalExpectedCollection() > maxCourse.totalExpectedCollection()) {
                maxCourse = c;
            }
        }
        return maxCourse;
    }

    private static void displayLargestCollectionCourse() {
        System.out.println("--- Course with Largest Expected Collection ---");
        CourseRegistration c = findCourseWithLargestCollection();
        if (c == null) {
            System.out.println("No course registrations recorded.");
        } else {
            System.out.println("Top course by total collection:");
            System.out.println(c);
        }
    }

    private static void displayStatisticsAndWeightedAverage() {
        System.out.println("--- Course Statistics & Weighted Average Tuition ---");
        int theoryCount = 0;
        int labCount = 0;
        int totalStudents = 0;
        double totalCollection = 0;

        for (CourseRegistration c : courses) {
            if (c instanceof TheoryCourse) {
                theoryCount++;
            } else if (c instanceof LabCourse) {
                labCount++;
            }
            totalStudents += c.getRegisteredStudents();
            totalCollection += c.totalExpectedCollection();
        }

        System.out.printf("Theory Courses     : %d course(s)%n", theoryCount);
        System.out.printf("Laboratory Courses : %d course(s)%n", labCount);
        System.out.printf("Total Courses      : %d course(s)%n", courses.size());
        System.out.printf("Total Students     : %d student(s)%n", totalStudents);
        System.out.printf("Combined Revenue   : %,.0f VND%n", totalCollection);

        if (totalStudents == 0) {
            System.out.println("Weighted Average Tuition per Student: N/A (Total registered students = 0)");
        } else {
            double weightedAverage = totalCollection / totalStudents;
            System.out.printf("Weighted Average Tuition per Student: %,.2f VND/student%n", weightedAverage);
        }
    }

    private static void addNewCourse() {
        System.out.println("--- Add Course Registration ---");
        System.out.println("1. Theory Course (credits * 450,000 VND)");
        System.out.println("2. Laboratory Course (credits * 600,000 VND + equipment fee)");
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
            System.out.println("Invalid selection!");
            return;
        }

        try {
            System.out.print("Enter Course Code: ");
            String code = sc.nextLine().trim();
            if (findCourseByCode(code) != null) {
                System.out.println("Error: Course code already exists! Duplicate codes are rejected.");
                return;
            }

            System.out.print("Enter Course Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Credits (>= 1): ");
            int credits = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Registered Students (>= 0): ");
            int students = Integer.parseInt(sc.nextLine().trim());

            CourseRegistration course;
            if (type == 1) {
                course = new TheoryCourse(code, name, credits, students);
            } else {
                System.out.print("Enter Equipment Fee per student (>= 0): ");
                double equipFee = Double.parseDouble(sc.nextLine().trim());
                course = new LabCourse(code, name, credits, students, equipFee);
            }

            courses.add(course);
            System.out.println("Course added successfully!");
            System.out.println(course);
        } catch (NumberFormatException e) {
            System.out.println("Input Error: Numbers must be valid integers or decimals!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
