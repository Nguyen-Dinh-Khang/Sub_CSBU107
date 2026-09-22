import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input a string: ");
        String x = scanner.nextLine();
        String result = "";
        for (int i = x.length()-1; i >= 0 ; i--){
            result += x.charAt(i);
        }

        System.out.print("Result: " + result);

        scanner.close();
    }
}
