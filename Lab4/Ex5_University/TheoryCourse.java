package Lab4.Ex5_University;

public class TheoryCourse extends CourseRegistration {
    public static final double RATE_PER_CREDIT = 450000.0;

    public TheoryCourse(String courseCode, String courseName, int credits, int registeredStudents) {
        super(courseCode, courseName, credits, registeredStudents);
    }

    public TheoryCourse(String courseCode, String courseName, int credits) {
        super(courseCode, courseName, credits);
    }

    @Override
    public double tuitionPerStudent() {
        return getCredits() * RATE_PER_CREDIT;
    }

    @Override
    public String displayInfo() {
        return String.format("[Theory Course] %s", super.displayInfo());
    }
}
