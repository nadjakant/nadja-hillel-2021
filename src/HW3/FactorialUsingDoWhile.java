package HW3;

import java.util.Scanner;

public class FactorialUsingDoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scanner.nextInt();
        int array[] = new int[size];
        System.out.println("Enter " + size + "elements of an array");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(array);
    }
}

