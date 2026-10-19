package Lab2;

import java.util.Random;


public class Ex5_Dice {
    private int value;
    private Random random;

    public Ex5_Dice(){
        value = 1;
        random = new Random();
    }

    public int roll(){
        value = random.nextInt(6) + 1;
        return value - 1;
    }

    public static void main(String[] args) {
        Ex5_Dice A = new Ex5_Dice();
        int n = 20;

        int[] array = new int[6];
        for (int i=0; i < n; i++){
            array[A.roll()] += 1;
        }

        for (int i=0; i < 6; i++){
            System.out.println(i+1 + ": " + array[i]);
        }
    }
}
