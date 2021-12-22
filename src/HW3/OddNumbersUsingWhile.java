package HW3;

public class OddNumbersUsingWhile {
    public static void main(String[] args) {
        int i = 1;
        while (i < 100) {
            i++;
            if (i % 2 != 0) {
                System.out.println(i);

            }

        }
    }
}

