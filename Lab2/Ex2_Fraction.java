package Lab2;

public class Ex2_Fraction {
    private int numerator;
    private int denominator;

    public Ex2_Fraction(){
        numerator = 0;
        denominator = 1;
    }

    public Ex2_Fraction(int nu, int de){
        if (de == 0){
            throw new IllegalArgumentException("Invalid denominator!");
        }

        numerator = nu;
        denominator = de;
    }

    public Ex2_Fraction(Ex2_Fraction other){
        numerator = other.numerator;
        denominator = other.denominator;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public void simplify(){
        int g = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= g;
        denominator /= g;
    }

    public Ex2_Fraction add(Ex2_Fraction other){
        Ex2_Fraction result;
        if (denominator == other.denominator){
            result = new Ex2_Fraction((numerator + other.numerator), denominator);
        } else {
            result = new Ex2_Fraction((numerator * other.denominator + other.numerator * denominator), (denominator * other.denominator));
        }
        result.simplify();

        return result;
    }

    public Ex2_Fraction subtract(Ex2_Fraction other){
        Ex2_Fraction result;
        if (denominator == other.denominator){
            result = new Ex2_Fraction((numerator - other.numerator), denominator);
        } else {
            result = new Ex2_Fraction((numerator * other.denominator - other.numerator * denominator), (denominator * other.denominator));
        }
        result.simplify();

        return result;
    }

    public Ex2_Fraction multiply(Ex2_Fraction other){
        Ex2_Fraction result = new Ex2_Fraction((numerator * other.numerator), (denominator * other.denominator));
        result.simplify();
    
        return result;
    }

    public Ex2_Fraction divide(Ex2_Fraction other){
        Ex2_Fraction result = new Ex2_Fraction((numerator * other.denominator), (denominator * other.numerator));
        result.simplify();
    
        return result;
    }

    public void display(){
        System.out.println(numerator + "/" + denominator);
    }


    public static void main(String[] args) {
        Ex2_Fraction A = new Ex2_Fraction(2, 3);
        Ex2_Fraction B = new Ex2_Fraction(3, 6);


        System.out.print("Fraction A: ");
        A.display();
        System.out.print("Fraction B: ");
        B.display();

        Ex2_Fraction C;
        C = B.add(A);
        System.out.print("B add A: ");
        C.display();

        C = B.subtract(A);
        System.out.print("B subtract A: ");
        C.display();

        C = B.multiply(A);
        System.out.print("B multiply A: ");
        C.display();

        C = B.divide(A);
        System.out.print("B divide A: ");
        C.display();

        B.simplify();
        System.out.print("Simplify B: ");
        B.display();

        System.out.println();
        Ex2_Fraction D = new Ex2_Fraction(A);
        System.out.print("Fraction A: ");
        A.display();
        System.out.print("Fraction D: ");
        D.display();
        D.numerator = 7;
        System.out.println("After change: ");
        System.out.print("Fraction A: ");
        A.display();
        System.out.print("Fraction D: ");
        D.display();
    }
}