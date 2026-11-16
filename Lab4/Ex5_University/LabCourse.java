package Lab4.Ex5_University;

public class LabCourse extends CourseRegistration {
    public static final double RATE_PER_CREDIT = 600000.0;
    private double equipmentFee;

    public LabCourse(String courseCode, String courseName, int credits, int registeredStudents, double equipmentFee) {
        super(courseCode, courseName, credits, registeredStudents);
        setEquipmentFee(equipmentFee);
    }

    public LabCourse(String courseCode, String courseName, int credits, double equipmentFee) {
        super(courseCode, courseName, credits);
        setEquipmentFee(equipmentFee);
    }

    public double getEquipmentFee() {
        return equipmentFee;
    }

    public void setEquipmentFee(double equipmentFee) {
        if (equipmentFee < 0) {
            throw new IllegalArgumentException("Equipment fee must be >= 0!");
        }
        this.equipmentFee = equipmentFee;
    }

    @Override
    public double tuitionPerStudent() {
        return (getCredits() * RATE_PER_CREDIT) + equipmentFee;
    }

    @Override
    public String displayInfo() {
        return String.format("[Lab Course   ] %s | Equip Fee: %,.0f VND", super.displayInfo(), equipmentFee);
    }
}
