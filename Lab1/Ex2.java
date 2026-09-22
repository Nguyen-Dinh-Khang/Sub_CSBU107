import java.util.Scanner;


public class Ex2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the first number: ");
        int a = scanner.nextInt();

        System.out.print("Input the second number: ");
        int b = scanner.nextInt();

        System.out.print("Input the third number: ");
        int c = scanner.nextInt();

        if (a > b && a > c){
            System.out.println("The biggest number: " + a);
        } else if (b > c){
            System.out.println("The biggest number: " + b);
        } else {
            System.out.println("The biggest number: " + c);
        }

        scanner.close();
    }
}
