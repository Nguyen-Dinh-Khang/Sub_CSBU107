import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input an interger: ");
        int x = scanner.nextInt();

        for (int i=1; i < 11; i++){
            System.out.println(x + " x " + i + " = " + (x*i));
        }


        scanner.close();
    }
}
