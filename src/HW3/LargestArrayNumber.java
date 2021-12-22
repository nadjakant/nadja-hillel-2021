package HW3;

import java.util.Scanner;

public class LargestArrayNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What size should have an array");
        int[] array = new int[sc.nextInt()];
        System.out.println("Enter the elements");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        int max = array[0];
        int repeatOfMax = 1;
        for (int i = 0; i < array.length; i++) {

            if (array[i] > max) {
                if (array[i] == max) {
                    repeatOfMax += 1;
                }
                max = array[i];
            }
        }
        for (int i = 0; i <= repeatOfMax; i++) {
            System.out.println(max);
        }
    }
}

