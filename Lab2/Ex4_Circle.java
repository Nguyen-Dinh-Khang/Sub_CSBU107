package Lab2;

public class Ex4_Circle {
    private int centerX;
    private int centerY;
    private double radius;

    public Ex4_Circle(){
        centerX = 0;
        centerY = 0;
        radius = 1;
    }

    public Ex4_Circle(int X, int Y, double r){
        if (r <= 0){
            throw new IllegalArgumentException("Invalid radius!");
        }

        centerX = X;
        centerY = Y;
        radius = r;
    }

    public double area(){
        return Math.PI * radius * radius;
    }

    public double perimeter(){
        return 2 * Math.PI * radius;
    }

    public boolean contains(double x, double y) {
        double dx = x - centerX;
        double dy = y - centerY;
        double distanceSquared = dx * dx + dy * dy;
        return distanceSquared <= (radius * radius);
    }

    public static void main(String[] args) {
        Ex4_Circle A = new Ex4_Circle();
        Ex4_Circle B = new Ex4_Circle(3,2, 7);
        Ex4_Circle C = new Ex4_Circle(2,5,4);

        System.err.println("Circle A'area: " + A.area());
        System.out.println("Circle B'area: " + B.area());

        System.out.println();

        System.out.println("Circle A'perimetor: " + A.perimeter());
        System.out.println("Circle C'perimetor: " + C.perimeter());

        System.out.println();

        System.out.println("Point 1: [2,3]");
        System.out.println("Point 1 is in A: " + A.contains(2, 3));
        System.out.println("Point 1 is in B: " + B.contains(2, 3));
        System.out.println("Point 1 is in C: " + C.contains(2, 3));
    }
}
