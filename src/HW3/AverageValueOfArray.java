package HW3;

import java.util.Scanner;

public class AverageValueOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What size should have an array");
        int[] array = new int[sc.nextInt()];
        System.out.println("Enter the elements");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        double average = 0;
        if (array.length > 0)
        {
            double sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            average = sum / array.length;
        }
        System.out.println(average);
    }
}
