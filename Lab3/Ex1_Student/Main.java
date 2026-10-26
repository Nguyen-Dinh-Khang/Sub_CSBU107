package Lab3.Ex1_Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        // Nạp sẵn 2 test cases theo gợi ý của đề bài để kiểm thử nhanh
        loadSampleData();

        int choice;
        do {
            System.out.println("\n=== University Student Graduation Management ===");
            System.out.println("1. Input College's student: ");
            System.out.println("2. Input University's student: ");
            System.out.println("3. Show all students: ");
            System.out.println("4. The number of graduated students: ");
            System.out.println("5. The student with highest GPA: ");
            System.out.println("0. Exit");
            System.out.print("Choose function: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1 -> addCollegeStudent();
                case 2 -> addUniversityStudent();
                case 3 -> displayAll();
                case 4 -> countGraduatedStudents();
                case 5 -> findTopUniversityStudent();
                case 0 -> System.out.println("End program");
                default -> System.out.println("Invalid input, please try again!");
            }
        } while (choice != 0);
    }

    private static void loadSampleData() {
        // Suggested test 1: College đủ điều kiện
        students.add(new CollegeStudent("C01", "Nguyen Van A", "Hanoi", 125, 6.5, 7.0));
        // Suggested test 2: University thiếu tín chỉ (165 < 170) -> Không đủ điều kiện
        students.add(new UniversityStudent("U01", "Tran Thi B", "HCMC", 165, 8.0, "AI in Healthcare", 9.0));
        // Thêm test case chuẩn cho University để kiểm tra tìm kiếm thủ khoa
        students.add(new UniversityStudent("U02", "Le Van C", "Da Nang", 175, 8.5, "Distributed Systems", 8.5));
    }

    private static void addCollegeStudent() {
        System.out.println("\n--- Input College's student ---");
        try {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Total credits: ");
            int credits = Integer.parseInt(scanner.nextLine());
            System.out.print("GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());
            System.out.print("Graduation score: ");
            double examScore = Double.parseDouble(scanner.nextLine());

            students.add(new CollegeStudent(id, name, address, credits, gpa, examScore));
            System.out.println("Add College's student successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addUniversityStudent() {
        System.out.println("\n--- Input University's student ---");
        try {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Total credits: ");
            int credits = Integer.parseInt(scanner.nextLine());
            System.out.print("GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());
            System.out.print("Thesis title: ");
            String thesis = scanner.nextLine();
            System.out.print("Thesis score: ");
            double thesisScore = Double.parseDouble(scanner.nextLine());

            students.add(new UniversityStudent(id, name, address, credits, gpa, thesis, thesisScore));
            System.out.println("Add University's student successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("Empty list!");
            return;
        }
        System.out.println("\n--- Student list ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void countGraduatedStudents() {
        int count = 0;
        // Đa hình: s.isGraduated() tự động gọi phương thức của College hoặc University tương ứng
        for (Student s : students) {
            if (s.isGraduated()) {
                count++;
            }
        }
        System.out.printf("\nThe total number of graduated students: %d / %d\n", count, students.size());
    }

    private static void findTopUniversityStudent() {
        UniversityStudent topStudent = null;

        for (Student s : students) {
            if (s instanceof UniversityStudent uStudent) {
                if (topStudent == null || uStudent.getGpa() > topStudent.getGpa()) {
                    topStudent = uStudent;
                }
            }
        }

        if (topStudent == null) {
            System.out.println("No University student is in list.");
        } else {
            System.out.println("\n--- UNIVERSITY student has the highest GPA ---");
            System.out.println(topStudent);
        }
    }
}
