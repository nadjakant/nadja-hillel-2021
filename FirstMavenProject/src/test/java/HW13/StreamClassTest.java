package HW13;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StreamClassTest {
    @Test
    void getAverageValuePositive() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertEquals(2.0, StreamClass.getAverageValue(list), "Среднее значение не совпадает с ожидаемым");
    }

    @Test
    void getAverageValueNegative() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertNotEquals(false, StreamClass.getAverageValue(list) == 2.0, "Среднее значение не совпадает с ожидаемым");
    }

    //добавила, потому что forEach вроде не гарантирует порядка элементов
    @RepeatedTest(10)
    void getUpperCasePairsPositive() {
        List<String> list1 = Arrays.asList("я", "тут", "был");
        List<MyPair> myPairsList = new ArrayList<>();
        myPairsList.add(new MyPair("я", "Я"));
        myPairsList.add(new MyPair("тут", "ТУТ"));
        myPairsList.add(new MyPair("был", "БЫЛ"));

        assertEquals(myPairsList.toString(), StreamClass.getUpperCasePairs(list1).toString(), "List<Pair> получен неверно");
    }
//добавила, потому что forEach вроде не гарантирует порядка элементов
    @RepeatedTest(10)
    void getUpperCasePairsNegative() {
        List<String> list1 = Arrays.asList("я", "тут", "был");
        List<MyPair> myPairsList = new ArrayList<>();
        myPairsList.add(new MyPair("я", "Я"));
        myPairsList.add(new MyPair("тут", "ТУТ"));
        myPairsList.add(new MyPair("был", "БЫЛ"));

        assertNotEquals(false, myPairsList.toString().equals(StreamClass.getUpperCasePairs(list1).toString()), "List<Pair> получен неверно");
    }

    @Test
    void getStingValuesPositive() {
        List<String> list2 = Arrays.asList("надя", "Балда", "!");
        List<String> list = Arrays.asList("надя");
        assertEquals(true, list.toString().equals(StreamClass.getStingValues(list2).toString()), "получено неверное значение");
    }

    @Test
    void getStingValuesNegative() {
        List<String> list2 = Arrays.asList("надя", "Балда", "!");
        List<String> list = Arrays.asList("надя");
        assertNotEquals(false, list.toString().equals(StreamClass.getStingValues(list2).toString()), "получено неверное значение");
    }
}