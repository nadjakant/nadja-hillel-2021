package HW3;

import java.util.Scanner;

public class SmallestArrayNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What size should have an array");
        int[] array = new int[sc.nextInt()];
        System.out.println("Enter the elements");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        int min = array[0];
        int repeatOfMin = 1;
        for (int i = 0; i < array.length; i++) {

            if (array[i] < min) {
                if (array[i] == min) {
                    repeatOfMin += 1;
                }
                min = array[i];
            }
        }
        for (int i = 0; i <= repeatOfMin; i++) {
            System.out.println(min);
        }
    }
}

