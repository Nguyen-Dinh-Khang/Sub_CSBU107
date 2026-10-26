package Lab3.Ex1_Student;

public class CollegeStudent extends Student {
    private double graduationExamScore;

    public CollegeStudent(String studentId, String fullName, String address,
                          int totalCredits, double gpa, double graduationExamScore) {
        super(studentId, fullName, address, totalCredits, gpa);
        setGraduationExamScore(graduationExamScore);
    }

    public double getGraduationExamScore() {
        return graduationExamScore;
    }

    public void setGraduationExamScore(double graduationExamScore) {
        if (graduationExamScore < 0.0 || graduationExamScore > 10.0) {
            throw new IllegalArgumentException("Graduation exam score ranges from 0.0 to 10.0!");
        }
        this.graduationExamScore = graduationExamScore;
    }

    @Override
    public boolean isGraduated() {
        // Điều kiện: credits >= 120, gpa >= 5.0, examScore >= 5.0
        return getTotalCredits() >= 120 && getGpa() >= 5.0 && graduationExamScore >= 5.0;
    }

    @Override
    public String toString() {
        return String.format("[College] %s | Graduation exam score: %.2f | Graduated: %s",
                super.toString(), graduationExamScore, isGraduated() ? "Yes" : "No");
    }
}