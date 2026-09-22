import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input a number: ");
        int a = scanner.nextInt();
        int n = 0;

        for (int i = 1; i <= a; i++){
            n += i;
        }

        System.out.println("Sum from 1 to n: " + n);

        scanner.close();
    }
}
