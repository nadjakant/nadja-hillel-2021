package HW10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Напишите метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов.

public class UniqueValues {
    public static void main(String[] args) {
        List list1 = List.of("я", "тут", "был", "и", "там","тоже","был", "я");
        System.out.println(uniqueCollection(list1));

    }

    private static ArrayList uniqueCollection(List list){
     return new ArrayList(new HashSet(list));
    }
}
