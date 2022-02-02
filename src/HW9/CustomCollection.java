package HW9;

import java.util.Collection;

public interface CustomCollection<T,E>{
    boolean add(T str);

    boolean addAll(T[] strArr);

    boolean addAll(E strColl);

    boolean delete(int index);

    boolean delete(T str);

    String get(int index);

    boolean contains(T str);

    boolean clear();

    int size();

    boolean trim();

    boolean compare(E coll);
}