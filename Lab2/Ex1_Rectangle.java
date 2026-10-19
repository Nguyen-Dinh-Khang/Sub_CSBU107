package Lab2;

public class Ex1_Rectangle {
    private double width;
    private double height;
    
    public Ex1_Rectangle() {
        width = 1;
        height = 1;
    }

    public Ex1_Rectangle(double width, double height) {
        if (width < 0){
            this.width = 1;
        } else {
            this.width = width;
        }

        if (height < 0){
            this.height = 1;
        } else {
            this.height = height;
        }
    }

    public double area(){
        return width * height;
    }

    public double perimeter(){
        return 2 * (width + height);
    }
    
    public void displayInfo(){
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }

    public static void main(String[] args) {
        Ex1_Rectangle A = new Ex1_Rectangle();
        Ex1_Rectangle B = new Ex1_Rectangle(2, 3);
        Ex1_Rectangle C = new Ex1_Rectangle(27, 49);

        System.out.println("A's info: ");
        A.displayInfo();
        System.out.println("Area: " + A.area());
        System.out.println("Perimeter: " + A.perimeter());

        System.out.println();

        System.out.println("B's info: ");
        B.displayInfo();
        System.out.println("Area: " + B.area());
        System.out.println("Perimeter: " + B.perimeter());

        System.out.println();

        System.out.println("C's info: ");
        C.displayInfo();
        System.out.println("Area: " + C.area());
        System.out.println("Perimeter: " + C.perimeter());
    }
}
