package HW12;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCollectionTest {
    SimpleCollection simpleList1;
    SimpleCollection simpleList2;
    final String EMPTY_LIST_STR = "List: <empty>";

    @BeforeEach
    public void adjust() {
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
        assertEquals("был", simpleList2.get(simpleList2.size() - 1), "ошибка при получении последнего элемента");

        assertEquals("<Incorrect index>", simpleList2.get(simpleList2.size()), "неверное значение при некоректном индексе");
        assertEquals("<Incorrect index>", simpleList2.get(-1), "неверное значение при некоректном индексе");
    }

    @Test
    void getNegative() {
        assertNotEquals("я", simpleList2.get(1), "получено неверное значение из середины списка");
        assertNotEquals("был", simpleList2.get(0), "получено неверное значение первого элемента");
        assertNotEquals("тут", simpleList2.get(simpleList2.size() - 1), "получено неверное значение последнего элемента");

        assertNotEquals(false, simpleList2.get(simpleList2.size()).equals("<Incorrect index>"), "неверное значение при некоректном индексе");
        assertNotEquals(false, simpleList2.get(-1).equals("<Incorrect index>"), "неверное значение при некоректном индексе");
    }

    @Test
    void addToTheEndPositive() {
        assertEquals(true, simpleList1.add("!"), "элемент не был добавлен");
        assertEquals("!", simpleList1.get(0), "получено неверное значение после добавления в конец списка");
        assertEquals(1, simpleList1.size(), "после добвление элемента сайз не поменялся");
    }

    @Test
    void addToTheEndNegative() {
        assertNotEquals(false, simpleList1.add("!"), "элемент не был добавлен");
        assertNotEquals(false, simpleList1.get(0).equals("!"), "не найден элемент после добавления в конец списка");
        assertNotEquals(false, simpleList1.size()==1, "после добвление элемента сайз не поменялся");
    }

    @Test
    void addByIndexPositive() {
        assertEquals(true, simpleList1.add(0, "!"), "элемент не был добавлен");
        assertEquals("!", simpleList1.get(0), "не был добавлен элемент по индексу 0 при пустом списке");
        assertEquals(true, simpleList1.add(0, "!!"), "элемент не был добавлен");
        assertEquals("!!", simpleList1.get(0), "не был добавлен элемент в начало списка при непустом списке");
        assertEquals(true, simpleList1.add(1, "!!!"), "элемент не был добавлен");
        assertEquals("!!!", simpleList1.get(1), "не был добавлен элемент в середину списка при непустом списке");
        assertEquals(3, simpleList1.size(), "после добвление элементов получен неверный размер");
    }

    @Test
    void addByIndexNegative() {
        assertNotEquals(false, simpleList1.add(0, "!"), "элемент не был добавлен");
        assertNotEquals(false, simpleList1.get(0).equals("!"), "не был добавлен элемент по индексу 0 при пустом списке");
        assertNotEquals(false, simpleList1.add(0, "!!"), "элемент не был добавлен");
        assertNotEquals(false, simpleList1.get(0).equals("!!"), "не был добавлен элемент в начало списка при непустом списке");
        assertNotEquals(false, simpleList1.add(1, "!!!"), "элемент не был добавлен");
        assertNotEquals(false, simpleList1.get(1).equals("!!!"), "не был добавлен элемент в середину списка при непустом списке");
        assertNotEquals(false, simpleList1.size() == 3, "после добвление элементов получен неверный размер");
    }

    @Test
    void deleteByIndexPositive() {
        assertFalse(simpleList1.delete(0), "элемент из пустого списка не был удален");
        assertTrue(simpleList2.delete(0), "элемент был удален с первой позиции");
        assertFalse(simpleList2.delete(simpleList2.size()), "элемент за пределом коллекции не был удален");
        assertTrue(simpleList2.delete(simpleList2.size() - 1), "элемент c последней позиции был удален");
        assertEquals(1, simpleList2.size(), "размер не соответствует ожидаемому");
    }

    @Test
    void deleteByIndexNegative() {
        assertNotEquals(true, simpleList1.delete(0), "элемент из пустого списка был удален");
        assertNotEquals(false, simpleList2.delete(0), "элемент не был удален с первой позиции");
        assertNotEquals(true, simpleList2.delete(simpleList2.size()), "элемент за пределом коллекции был удален");
        assertNotEquals(false, simpleList2.delete(simpleList2.size() - 1), "элемент c последней позиции не был удален");
        assertNotEquals(false, simpleList2.size() == 1, "размер не соответствует ожидаемому");
    }

    @Test
    void deleteByValuePositive() {
        assertTrue(simpleList2.delete("я"), "значение не был удалено из коллекции");
        assertTrue(simpleList2.delete("тут"), "значение не был удалено из коллекции");
        assertFalse(simpleList2.delete(null), "значение было удалено из коллекции");
        assertFalse(simpleList1.delete("я"), "значение из пустого списка было удалено");
        assertEquals(1, simpleList2.size(), "размер не соответствует ожидаемому");
    }

    @Test
    void deleteByValueNegative() {
        assertFalse(simpleList2.delete("блабла"), "значение было удалено из коллекции");
        assertNotEquals(true,simpleList1.delete("бла"), "значение было удалено из пустой коллекции");
        assertNotEquals(false, simpleList2.size() == 3, "размер не соответствует ожидаемому");
    }

    @Test
    void testToStringPositive() {
        assertEquals(true, simpleList1.toString().equals(EMPTY_LIST_STR), "получено значение при size равном 0");
        simpleList1.add("я");
        simpleList1.add("тут");
        simpleList1.add("был");
        assertEquals("List: я, тут, был", simpleList1.toString(), "выведен неверный список");
    }

    @Test
    void testToStringNegative() {
        assertNotEquals(false, simpleList1.toString().equals(EMPTY_LIST_STR), "получено значение при size равном 0");
        simpleList1.add("я");
        simpleList1.add("тут");
        simpleList1.add("был");
        assertNotEquals(false, simpleList1.toString().equals("List: я, тут, был"), "выведен неверный список");

    }
    @Test
    void containPositive() {
        assertTrue(simpleList2.contain("я"));
        assertFalse(simpleList2.contain("кто"));
    }

    @Test
    void containNegative() {
        assertNotEquals(false, simpleList2.contain("я"));
        assertNotEquals(true, simpleList2.contain("кто"));
    }

    @Test
    void testEqualsPositive() {
        simpleList1.add("я");
        simpleList1.add("тут");
        simpleList1.add("был");
        assertTrue(simpleList1.toString().equals(simpleList2.toString()), "списки не равны" );
    }

    @Test
    void testEqualsNegative() {
        simpleList1.add("я");
        simpleList1.add("тут");
        simpleList1.add("был");
        assertNotEquals(false,simpleList1.toString().equals(simpleList2.toString()),"списки не равны");

    }
    @Test
    void clearPositive() {
        simpleList2.clear();
        assertTrue(simpleList1.toString().equals(EMPTY_LIST_STR), "элементы не были удалены");
        assertEquals(0, simpleList2.size(), "элементы не были удалены");
    }

    @Test
    void clearNegative() {
        simpleList2.clear();
        assertNotEquals(false, simpleList2.toString().equals(EMPTY_LIST_STR), "элементы не были удалены");
        assertNotEquals(false, simpleList2.size() == 0, "размер не соответствует ожидаемому");
    }

    @Test
    void sizePositive() {
        assertEquals(0, simpleList1.size(), "неверное значение size у пустого списка");
        simpleList1.add("я");
        simpleList1.add("тут");
        simpleList1.add("был");
        assertEquals(3, simpleList1.size(), "неверное значение у списка simpleList2");
    }

    @Test
    void sizeNegative() {
        assertNotEquals(false, simpleList1.size() == 0, "неверное значение size у пустого списка");
        simpleList1.add("я");
        simpleList1.add("тут");
        simpleList1.add("был");
        assertNotEquals(false, simpleList1.size() == 3, "неверное значение у списка simpleList2");
    }
}