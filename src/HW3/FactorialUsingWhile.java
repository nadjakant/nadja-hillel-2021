package HW3;

import java.util.Scanner;

public class FactorialUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 1;
        int i = 1;
        while ( i <= n ) {
            i++;
            result *= i;
            if (i == n) {
                System.out.println(result);
            }
        }
    }
}
