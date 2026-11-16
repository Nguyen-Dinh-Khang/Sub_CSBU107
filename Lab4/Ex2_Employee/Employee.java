package Lab4.Ex2_Employee;

public abstract class Employee {
    private String id;
    private String fullName;
    private String department;

    public Employee(String id, String fullName, String department) {
        setId(id);
        setFullName(fullName);
        setDepartment(department);
    }

    public String getId() {
        return id;
    }

    public String getID() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be empty!");
        }
        this.id = id.trim();
    }

    public void setID(String id) {
        setId(id);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty!");
        }
        this.fullName = fullName.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty!");
        }
        this.department = department.trim();
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("ID: %s | Full Name: %s | Department: %s", id, fullName, department);
    }
}
