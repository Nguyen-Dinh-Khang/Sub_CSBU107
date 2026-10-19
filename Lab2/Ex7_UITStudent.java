package Lab2;

public class Ex7_UITStudent {
    private String studentId; 
    private String fullName; 
    private String major; 
    private double GPA;

    public Ex7_UITStudent() {
        studentId = "";
        fullName = "";
        major = "";
        GPA = 0.0;
    }

    public Ex7_UITStudent(String studentId, String fullName){
        this(studentId, fullName, "", 0.0);
    }

    public Ex7_UITStudent(String studentId, String fullName, String major, double GPA) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.major = major;
        this.GPA = GPA;
    }

    public void displayInfo(){
        System.out.println("Name: " + fullName);
        System.out.println("Id: " + studentId);
        System.out.println("Major: " + major);
        System.out.println("GPA: " + GPA);
        System.out.println("--------------------------------------------------------");
    }

    public boolean isPassed(){
        if (GPA >= 2){
            return true;
        } else {
            return false;
        }
    }

    public void academicClassification(){
        if (GPA >= 3.5){
            System.out.println("Excellent");
        } else if (GPA >= 3){
            System.out.println("Good");
        } else if (GPA >= 2){
            System.out.println("Normal");
        } else {
            System.out.println("Fail");
        }
    }

    public static void main(String[] args) {
        Ex7_UITStudent s1 = new Ex7_UITStudent();
        
        Ex7_UITStudent s2 = new Ex7_UITStudent("24560001", "Nguyen Van A");
        Ex7_UITStudent s3 = new Ex7_UITStudent("24560002", "Nguyen van B");

        Ex7_UITStudent s4 = new Ex7_UITStudent("24560003", "Nguyen Thi A", "Computer science", 3.2);
        Ex7_UITStudent s5 = new Ex7_UITStudent("24560004", "Nguyen Thi B", "Computer science", 2.5);

        // Hiển thị thông tin 5 sinh viên
        Ex7_UITStudent[] students = {s1, s2, s3, s4, s5};
        for (Ex7_UITStudent s : students) {
            s.displayInfo();
        }
    }
}
