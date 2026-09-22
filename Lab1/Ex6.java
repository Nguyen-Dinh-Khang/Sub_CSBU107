import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many number in an array: ");
        int n = scanner.nextInt();
        int[] Array = new int[n];

        for (int i=0; i < n; i++){
            System.out.print("Input number " + (i+1) + ": ");
            Array[i] = scanner.nextInt();
        }

        System.out.print("Input x: ");
        int x = scanner.nextInt();

        for (int i=0 ; i < n; i++){
            if (Array[i] == x){
                System.out.print(i);
                return;
            }
        }

        System.out.print(-1);

        scanner.close();
    }
}
