package HW3;

public class SequenceOfNumbers {
    public static void main(String[] args) {
        int number = 0;
        for (int i = 0; i < 10; i++) {
            if (number <= 0) {
                System.out.println(number);
            }
            number = number-5;

        }

    }
}
