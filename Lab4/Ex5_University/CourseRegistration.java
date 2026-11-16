package Lab4.Ex5_University;

public abstract class CourseRegistration {
    private String courseCode;
    private String courseName;
    private int credits;
    private int registeredStudents;

    public CourseRegistration(String courseCode, String courseName, int credits, int registeredStudents) {
        setCourseCode(courseCode);
        setCourseName(courseName);
        setCredits(credits);
        setRegisteredStudents(registeredStudents);
    }

    public CourseRegistration(String courseCode, String courseName, int credits) {
        this(courseCode, courseName, credits, 0);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be empty!");
        }
        this.courseCode = courseCode.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty!");
        }
        this.courseName = courseName.trim();
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits < 1) {
            throw new IllegalArgumentException("Credits must be >= 1!");
        }
        this.credits = credits;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(int registeredStudents) {
        if (registeredStudents < 0) {
            throw new IllegalArgumentException("Registered students must be >= 0!");
        }
        this.registeredStudents = registeredStudents;
    }

    public abstract double tuitionPerStudent();

    public double totalExpectedCollection() {
        return tuitionPerStudent() * registeredStudents;
    }

    public String displayInfo() {
        return String.format("Code: %-8s | Name: %-25s | Credits: %d | Students: %3d",
                courseCode, courseName, credits, registeredStudents);
    }

    @Override
    public String toString() {
        return String.format("%s | Tuition/Student: %,.0f VND | Total Collection: %,.0f VND",
                displayInfo(), tuitionPerStudent(), totalExpectedCollection());
    }
}
