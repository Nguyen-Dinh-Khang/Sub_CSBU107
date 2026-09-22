import  java.util.Scanner;

public class Ex7 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many numbers in array 1: ");
        int n = scanner.nextInt();
        int[] Array1 = new int[n];
        for (int i=0; i < n; i++){
            System.out.print("Input a number into array 1: ");
            Array1[i] = scanner.nextInt();
        }
        
        System.out.print("How many numbers in array 2: ");
        int m = scanner.nextInt();
        int [] Array2 = new int[m];
        for (int i=0; i < m; i++){
            System.out.print("Input a number into array 2: ");
            Array2[i] = scanner.nextInt();
        }


        int x = 0;
        int y = 0;
        int[] result = new int[n+m];
        for (int i=0; i < n+m; i++){
            if (x == n){
                result[i] = Array2[y++];
                // y += 1;
            } else if (y == m){
                result[i] = Array1[x++];
                // x += 1;
            } else {
                if (Array1[x] < Array2[y]){
                    result[i] = Array1[x++];
                } else {
                    result[i] = Array2[y++];
                }
            }
        }

        System.out.print("The sorted array: ");
        for (int i=0; i < n+m; i++){
            System.out.print(result[i] + " ");
        }
        
        
        scanner.close();
    }
}
