package HW14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("введите цифры для псевдографики");
        String str = scanner.nextLine();
        if (str.matches("\\d+")) {
            ASCIIArt.printNumbers(str);
        } else {
             System.out.println("Ой, все!");
        }
    }
}
