package ua.hillel;

import java.util.Scanner;

public class Deposit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter contribution in ₴");
        float contribution = scanner.nextFloat();
        System.out.print("Enter percentage:");
        float percentage = scanner.nextFloat() / 100;
        System.out.print("Enter the number of years");
        int years = scanner.nextInt();
        double period = years * 12;
        double percentagePerMonth = percentage / 12;
        double summProcentage = 0;
        for (int i = 0; i <= period; i++) {
            double percentagePerYear = contribution * percentagePerMonth;
            summProcentage += percentagePerYear;
            contribution += (float) percentagePerYear;
            if (i !=0 && i % 12 == 0) {
                System.out.printf("начисленные процента %.2f%n", summProcentage);
                System.out.printf("накопленная сумма за год %.2f%n",  contribution);
            }
        }
    }
}