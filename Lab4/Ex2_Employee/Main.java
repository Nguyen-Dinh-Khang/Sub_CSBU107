package Lab4.Ex2_Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static final List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        loadSample();

        int choice;
        do {
            System.out.println("==================================================");
            System.out.println("        EMPLOYEE PAYROLL MANAGEMENT SYSTEM        ");
            System.out.println("==================================================");
            System.out.println("1. Display Payroll (All Employees)");
            System.out.println("2. Find Employees by Department");
            System.out.println("3. Find Employee by ID (Overload 1)");
            System.out.println("4. Find Employee by Name & Department (Overload 2)");
            System.out.println("5. Calculate Total Payroll");
            System.out.println("6. Find Employee with Highest Salary");
            System.out.println("7. Add New Employee");
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
                case 1 -> displayPayroll();
                case 2 -> handleFindByDepartment();
                case 3 -> handleFindById();
                case 4 -> handleFindByNameAndDepartment();
                case 5 -> displayTotalPayroll();
                case 6 -> displayHighestSalary();
                case 7 -> handleAddEmployee();
                default -> System.out.println("Invalid option! Please enter a number from 0 to 7.");
            }
            System.out.println();
        } while (choice != 0);
    }

    private static void loadSample() {
        employees.add(new PartTimeEmployee("PT01", "Nguyen Van A", "Hotel", 40, 50000));
        employees.add(new FullTimeEmployee("FT01", "Nguyen Thi B", "IT", 10400000, 1000000, 26));
        employees.add(new FullTimeEmployee("FT02", "Tran Van C", "IT", 13000000, 500000, 20));
        employees.add(new PartTimeEmployee("PT02", "Le Thi D", "Hotel", 25, 60000));
    }

    public static void displayPayroll() {
        System.out.println("----------------- PAYROLL LIST -----------------");
        if (employees.isEmpty()) {
            System.out.println("No employees in the list.");
            return;
        }

        for (Employee e : employees) {
            System.out.printf("%s | Computed Salary: %,.0f VND%n", e.toString(), e.calculateSalary());
        }
    }

    public static List<Employee> findByDepartment(String department) {
        List<Employee> result = new ArrayList<>();
        if (department == null) return result;

        for (Employee e : employees) {
            if (e.getDepartment().equalsIgnoreCase(department.trim())) {
                result.add(e);
            }
        }
        return result;
    }

    public static Employee findEmployee(String id) {
        if (id == null) return null;

        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id.trim())) {
                return e;
            }
        }
        return null;
    }

    public static List<Employee> findEmployee(String name, String department) {
        List<Employee> result = new ArrayList<>();
        if (name == null || department == null) return result;

        for (Employee e : employees) {
            if (e.getFullName().equalsIgnoreCase(name.trim()) &&
                e.getDepartment().equalsIgnoreCase(department.trim())) {
                result.add(e);
            }
        }
        return result;
    }

    private static void handleFindByDepartment() {
        System.out.println("--- Find Employees by Department ---");
        System.out.print("Enter department name: ");
        String dept = sc.nextLine();

        List<Employee> list = findByDepartment(dept);
        if (list.isEmpty()) {
            System.out.println("No employees found in department: " + dept);
        } else {
            System.out.printf("Found %d employee(s) in department '%s':%n", list.size(), dept);
            for (Employee e : list) {
                System.out.printf("%s | Computed Salary: %,.0f VND%n", e, e.calculateSalary());
            }
        }
    }

    private static void handleFindById() {
        System.out.println("--- Find Employee by ID ---");
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        Employee emp = findEmployee(id);
        if (emp == null) {
            System.out.println("No employee found with ID: " + id);
        } else {
            System.out.println("Found employee:");
            System.out.printf("%s | Computed Salary: %,.0f VND%n", emp, emp.calculateSalary());
        }
    }

    private static void handleFindByNameAndDepartment() {
        System.out.println("--- Find Employee by Name and Department ---");
        System.out.print("Enter Full Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        List<Employee> list = findEmployee(name, dept);
        if (list.isEmpty()) {
            System.out.printf("No employee found with Name '%s' in Department '%s'.%n", name, dept);
        } else {
            System.out.printf("Found %d matching employee(s):%n", list.size());
            for (Employee e : list) {
                System.out.printf("%s | Computed Salary: %,.0f VND%n", e, e.calculateSalary());
            }
        }
    }

    public static double calculateTotalPayroll() {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }

    private static void displayTotalPayroll() {
        System.out.println("--- Total Payroll Calculation ---");
        double total = calculateTotalPayroll();
        System.out.printf("Total Payroll for all %d employees: %,.0f VND%n", employees.size(), total);
    }

    public static Employee findHighestSalaryEmployee() {
        if (employees.isEmpty()) return null;

        Employee highest = employees.get(0);
        for (Employee e : employees) {
            if (e.calculateSalary() > highest.calculateSalary()) {
                highest = e;
            }
        }
        return highest;
    }

    private static void displayHighestSalary() {
        System.out.println("--- Employee with Highest Salary ---");
        Employee highest = findHighestSalaryEmployee();
        if (highest == null) {
            System.out.println("No employees currently registered.");
        } else {
            System.out.println("Employee with the highest salary is:");
            System.out.printf("%s | Computed Salary: %,.0f VND%n", highest, highest.calculateSalary());
        }
    }

    private static void handleAddEmployee() {
        System.out.println("--- Add New Employee ---");
        System.out.println("1. Full-time Employee");
        System.out.println("2. Part-time Employee");
        System.out.println("0. Back to Main Menu");
        System.out.print("Choose employee type: ");

        int type;
        try {
            type = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid selection. Returning to menu.");
            return;
        }

        switch (type) {
            case 0 -> System.out.println("Cancelled.");
            case 1 -> addFullTime();
            case 2 -> addPartTime();
            default -> System.out.println("Invalid selection.");
        }
    }

    private static void addFullTime() {
        try {
            System.out.println("\n[New Full-Time Employee]");
            System.out.print("Enter ID: ");
            String id = sc.nextLine().trim();
            if (findEmployee(id) != null) {
                System.out.println("Error: Employee ID already exists!");
                return;
            }

            System.out.print("Enter Full Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Base Salary (>= 0): ");
            double baseSalary = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Enter Allowance (>= 0): ");
            double allowance = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Enter Workdays (0 <= workdays <= 31): ");
            int workdays = Integer.parseInt(sc.nextLine().trim());

            FullTimeEmployee emp = new FullTimeEmployee(id, name, department, baseSalary, allowance, workdays);
            employees.add(emp);
            System.out.println("Successfully added Full-Time Employee!");
            System.out.printf("Summary: %s | Salary: %,.0f VND%n", emp, emp.calculateSalary());
        } catch (NumberFormatException e) {
            System.out.println("Input Error: Number format is invalid!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private static void addPartTime() {
        try {
            System.out.println("\n[New Part-Time Employee]");
            System.out.print("Enter ID: ");
            String id = sc.nextLine().trim();
            if (findEmployee(id) != null) {
                System.out.println("Error: Employee ID already exists!");
                return;
            }

            System.out.print("Enter Full Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Hours Worked (>= 0): ");
            double hoursWorked = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Enter Hourly Rate (>= 0): ");
            double hourlyRate = Double.parseDouble(sc.nextLine().trim());

            PartTimeEmployee emp = new PartTimeEmployee(id, name, department, hoursWorked, hourlyRate);
            employees.add(emp);
            System.out.println("Successfully added Part-Time Employee!");
            System.out.printf("Summary: %s | Salary: %,.0f VND%n", emp, emp.calculateSalary());
        } catch (NumberFormatException e) {
            System.out.println("Input Error: Number format is invalid!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
