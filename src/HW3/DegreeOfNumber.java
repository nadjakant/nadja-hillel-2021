package HW3;

import java.util.Scanner;

public class DegreeOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number you want to raise a power of");
        int x = sc.nextInt();
        System.out.println("Enter a degree");
        int n = sc.nextInt();
        int result = 1;
        for (int i = 1; i <= n; i++) {
         result *= x;
         if(i==n) {
             System.out.println(result);
         }
        }
    }
    }



