package HW3;

import java.util.Arrays;
import java.util.Scanner;

public class ChangeMinMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What size should have an array");
        int[] array = new int[sc.nextInt()];
        System.out.println("Enter the elements");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        int max = array[0];
        int min = array[0];
        int indexMin = 0;
        int indexMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexMin = i;
            }
            if (array[i] > max) {
                max = array[i];
                indexMax = i;
            }
        }
        array[indexMax] = min;
        array[indexMin] = max;
        System.out.println(Arrays.toString(array));
    }
}

