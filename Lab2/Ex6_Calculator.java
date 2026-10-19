package Lab2;

public class Ex6_Calculator {
    public static int add(int a, int b){
        return a + b;
    }

    public static double add(double a, double b){
        return a + b;
    }

    public static int add(int a, int b, int c){
        return a + b + c;
    }

    public static int max(int a, int b){
        if (a > b){
            return a;
        } else {
            return b;
        }
    }

    public static double max(double a, double b){
        if (a > b){
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        double d = 3.1;
        double e = 3.2;

        // Different arguments -> different function activates
        System.out.println("int a + int b = " + Ex6_Calculator.add(a, b));
        System.out.println("double d + double e = " + Ex6_Calculator.add(d, e));
        System.out.println("int a + int b + int c = " + Ex6_Calculator.add(a, b, c));
        System.out.println("max between int a and int b = " + Ex6_Calculator.max(a, b));
        System.out.println("max between double d and double e = " + Ex6_Calculator.max(d, e));
    }
}
