package Lab3.Ex1_Student;

public abstract class Student {
    private String studentId;
    private String fullName;
    private String address;
    private int totalCredits;
    private double gpa;

    public Student(String studentId, String fullName, String address, int totalCredits, double gpa) {
        setStudentId(studentId);
        setFullName(fullName);
        setAddress(address);
        setTotalCredits(totalCredits);
        setGpa(gpa);
    }

    // Abstract method để các lớp con tự định nghĩa quy tắc xét tốt nghiệp
    public abstract boolean isGraduated();

    // Getters và Setters có validation
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("You have to input id");
        }
        this.studentId = studentId.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("You have to input name");
        }
        this.fullName = fullName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = (address != null) ? address.trim() : "";
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        if (totalCredits < 0) {
            throw new IllegalArgumentException("The total credit has to over 0!");
        }
        this.totalCredits = totalCredits;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 10.0) {
            throw new IllegalArgumentException("GPA ranges from 0.0 to 10.0");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Credits: %d | GPA: %.2f",
                studentId, fullName, totalCredits, gpa);
    }
}