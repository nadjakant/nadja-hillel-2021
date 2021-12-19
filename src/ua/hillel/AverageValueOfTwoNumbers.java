package ua.hillel;

public class AverageValueOfTwoNumbers {
    public static void main(String args[]) {
        if (args.length > 2) {
            throw new IllegalArgumentException("введи правильное кол-во аргументов");
        }
        int one = Integer.valueOf(args[0]);
        int two = Integer.valueOf(args[1]);
        int average = (one+two) / 2;
        System.out.print("Average value = "+average);
    }
}

