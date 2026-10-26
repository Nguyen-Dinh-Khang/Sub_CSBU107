package Lab3.Ex1_Student;

public class UniversityStudent extends Student {
    private String thesisTitle;
    private double thesisScore;

    public UniversityStudent(String studentId, String fullName, String address,
                             int totalCredits, double gpa, String thesisTitle, double thesisScore) {
        super(studentId, fullName, address, totalCredits, gpa);
        setThesisTitle(thesisTitle);
        setThesisScore(thesisScore);
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        if (thesisTitle == null || thesisTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("You have to input title!");
        }
        this.thesisTitle = thesisTitle.trim();
    }

    public double getThesisScore() {
        return thesisScore;
    }

    public void setThesisScore(double thesisScore) {
        if (thesisScore < 0.0 || thesisScore > 10.0) {
            throw new IllegalArgumentException("The thesis score ranges from 0.0 to 10.0!");
        }
        this.thesisScore = thesisScore;
    }

    @Override
    public boolean isGraduated() {
        // Điều kiện: credits >= 170, gpa >= 5.0, thesisScore >= 5.0
        return getTotalCredits() >= 170 && getGpa() >= 5.0 && thesisScore >= 5.0;
    }

    @Override
    public String toString() {
        return String.format("[University] %s | Title: \"%s\" | Thesis score: %.2f | Graduated: %s",
                super.toString(), thesisTitle, thesisScore, isGraduated() ? "Yes" : "No");
    }
}