package HW13;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <Integer> list = Arrays.asList(1,2,3,4,5);
        List <String> list1 = Arrays.asList("я","тут","был");
        List <String> list2 = Arrays.asList("надя","Балда","!");
        System.out.println(StreamClass.getAverageValue(list));
        System.out.println(StreamClass.getUpperCasePairs(list1));
        System.out.println(StreamClass.getStingValues(list2));
    }
}
