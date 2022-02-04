package HW10;

import java.util.Scanner;

//3. написать программу для вычисления корней квадратного уравнения

public class QuadraticEquation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("введи значения для а");
        double a = scanner.nextDouble();
        System.out.println("введи значения для b");
        double b = scanner.nextDouble();
        System.out.println("введи значения для c");
        double c = scanner.nextDouble();
        double d = 0;

        d = b * b - 4 * a * c;
        if ( d < 0 ){
            System.out.println("нет действительных корней");
        } else if ( d == 0) {
            System.out.println("один действительный корень");

            System.out.println("root= :"+ -b /(2*a));

        } else {
            System.out.println("два действительных корня");
            System.out.println("root1= :"+ (-b - Math.sqrt(d))/(2*a));
            System.out.println("root2= :"+ (-b + Math.sqrt(d))/(2*a));
        }






    }
}
