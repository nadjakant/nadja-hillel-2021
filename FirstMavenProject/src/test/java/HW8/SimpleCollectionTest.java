package HW8;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SimpleCollectionTest {
    SimpleCollection simpleList1;
    SimpleCollection simpleList2;

//    @BeforeAll
//    public void once(){
//        simpleList1 = c;
//        simpleList2 = new SimpleCollection();
//
//        simpleList2.add("я");
//        simpleList2.add("тут");
//        simpleList2.add("был");
//    }

    @BeforeEach
    public void adjust(){
        simpleList1 = new SimpleCollection();
        simpleList2 = new SimpleCollection();

        simpleList2.add("я");
        simpleList2.add("тут");
        simpleList2.add("был");
    }

    @Test
    void getPositive() {
        assertEquals("тут", simpleList2.get(1), "ошибка при получении элемента из середины списка");
        assertEquals("я", simpleList2.get(0), "ошибка при получении первого элемента");
        assertEquals("был", simpleList2.get(simpleList2.size()-1), "ошибка при получении последнего элемента");

        assertEquals("<Incorrect index>", simpleList2.get(simpleList2.size()), "неверное значение при некоректном индексе");
        assertEquals("<Incorrect index>", simpleList2.get(-1), "неверное значение при некоректном индексе");
    }

    @Test
    void getNegative() {
        assertNotEquals("я", simpleList2.get(1), "получено неверное значение из середины списка");
        assertNotEquals("был", simpleList2.get(0), "получено неверное значение из середины списка");
        assertNotEquals("тут", simpleList2.get(simpleList2.size()-1), "получено неверное значение из середины списка");

        assertNotEquals(false, simpleList2.get(simpleList2.size()).equals("<Incorrect index>"), "неверное значение при некоректном индексе");
        assertNotEquals(false, simpleList2.get(-1).equals("<Incorrect index>"), "неверное значение при некоректном индексе");
    }

    @Test
    void addToTheEndPositive() {
        assertEquals(true,simpleList1.add("!"),"элемент не был добавлен");
        assertEquals("!", simpleList1.get(0),"получено неверное значение после добавления в конец списка");
    }

    @Test
    void addToTheEndNegative() {
        assertNotEquals(false,simpleList1.add("!"),"элемент был добавлен");
        assertNotEquals(false, simpleList1.get(0).equals("!"),"не найден элемент после добавления в конец списка");
    }

    @Test
    void addByIndexPositive() {

        assertEquals(true,simpleList1.add(0,"!"),"элемент не был добавлен");
        assertEquals("!", simpleList1.get(0),"не был добавлен элемент по индексу 0 при пустом списке");
        assertEquals(true,simpleList1.add(0,"!!"),"элемент не был добавлен");
        assertEquals("!!", simpleList1.get(0),"не был добавлен элемент в начало списка при непустом списке");
        assertEquals(true,simpleList1.add(1,"!!!"),"элемент не был добавлен");
        assertEquals("!!!", simpleList1.get(1),"не был добавлен элемент в середину списка при непустом списке");
        assertEquals(3, simpleList1.size(),"после добвление элемента сайз не поменялся");
    }

    @Test
    void addByIndexNegative() {
        assertNotEquals(false,simpleList1.add(0,"!"),"элемент не был добавлен");
        assertNotEquals(false, simpleList1.get(0).equals("!"),"не был добавлен элемент по индексу 0 при пустом списке");
        assertNotEquals(false,simpleList1.add(0,"!!"),"элемент не был добавлен");
        assertNotEquals(false, simpleList1.get(0).equals("!!"),"не был добавлен элемент в начало списка при непустом списке");
        assertNotEquals(false, simpleList1.add(1,"!!!"),"элемент не был добавлен");
        assertNotEquals(false, simpleList1.get(1).equals("!!!"),"не был добавлен элемент в середину списка при непустом списке");
        assertNotEquals(false, simpleList1.size()==3,"после добвление элемента сайз не поменялся");
    }

    @Test
    void deleteByIndexPositive() {
        assertNotEquals(true,simpleList1.delete(0),"элемент не был удален");


    }
    @Test
    void deleteByIndexNegative() {


    }

    @Test
    void deleteByValuePositive() {


    }

    @Test
    void deleteByValueNegative() {


    }



    @Test
    void testToString() {
    }

    @Test
    void contain() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void clear() {
    }

    @Test
    void size() {
    }
}