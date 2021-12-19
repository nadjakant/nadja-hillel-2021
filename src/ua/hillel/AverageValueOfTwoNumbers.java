package ua.hillel;

public class AverageValueOfTwoNumbers {
    public static void main(String args[]) {
        String one = args[0];
        String two = args[1];
        int summ = 0;
        int average = 0;
        for (String str : args) {
            System.out.println(str);
            int i = Integer.valueOf(one);
            int j = Integer.valueOf(two);
            summ = i+j;
            average = summ / args.length;

        }
        System.out.print("Average value = "+average);
    }
}

