import java.util.Scanner;

public class Damage_calculation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("How many hits: ");
        int n = sc.nextInt();
        double[] array = new double[n];
        for (int i=0; i < n; i++){
            System.out.print("Hit " + (i+1) + ": ");
            array[i] = sc.nextDouble();
        }

        System.out.print("The base dame: ");
        double base_damage = sc.nextDouble();
        
        System.out.print("The quill dame: ");
        double quill_damage = sc.nextDouble();

        System.out.print("The duration of the quill: ");
        double duration = sc.nextDouble();


        int start = 0;
        int end = 0;
        double second = 0;
        double result = 0;
        for (int i=0; i < n; i++){
            second = array[i];
            start = Set_New_Start(array, start, end, duration, second);
            
            result += base_damage + (end - start)*quill_damage;
            end += 1;
            if (second - array[start] == duration){
                start += 1;
            }
        }

        System.out.print("Total damage: " + result);

        sc.close();
    }

    public static int Set_New_Start (double[] array, int start, int end, double duration, double second){
        for (int i=start; i < end; i++){
            if (second - array[i] > duration){
                start += 1;
            } else {
                break;
            }
        }

        return start;
    }
}

// 5 4.9 12.6 19.1 22.9 46.2 65 51 15.0
// 13 4.9 12.6 19.1 22.9 26.2 32.7 34.6 44.3 44.6 50.5 59.8 66.2 72.1 65 51 15.0 