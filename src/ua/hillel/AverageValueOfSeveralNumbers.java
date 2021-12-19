package ua.hillel;

public class AverageValueOfSeveralNumbers {
    public static void main(String args[]) {
        int summ = 0;
        int average = 0;
        for (String str : args) {
            System.out.println(str);
            int i = Integer.valueOf(str);
            summ += i;
            average = summ / args.length;

        }
        System.out.print("Average value = "+average);
    }
}
