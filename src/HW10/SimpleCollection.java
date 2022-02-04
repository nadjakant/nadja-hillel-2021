package HW10;

import HW8.Collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

//2. Написать итератор по коллекции реализованной в ДЗ №8
//надо заимплементить интерфейс Iterator


public class SimpleCollection implements Collection<String> {
    public class SimpleIterator implements Iterator<String>{
        private int index = -1;

        @Override
        public boolean hasNext(){
            return (index+1 < size) ;
        }

        @Override
        public String next(){
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }

            index++;
            return simpleArray[index];
        }
    }



    private SimpleIterator iterator = new SimpleIterator();
    public SimpleIterator getIterator(){
        return iterator;
    }

    private String[] simpleArray = new String[1];
    private int size;

    private boolean isCorrectIndex(int index) {
        return (index >= 0 && index < size);
    }

    private void resize() {
        String[] newSimpleArray = new String[size + 1];

        for (int i = 0; i < size; i++) {
            newSimpleArray[i] = simpleArray[i];
        }
        simpleArray = newSimpleArray;
    }
    private int getFirstOccurrenceIndex(String value){
        int result = -1;

        for (int i = 0; i < size; i++) {
            if (simpleArray[i].equals(value)) {
                result = i;
                break;
            }
        }

        return result;
    }

   @Override
    public boolean add(int index, String value) {
        boolean result;

        if (!isCorrectIndex(index)) {
            result = false;
        } else if (index == size) {
            result = this.add(value);
        } else {
            for (int i = size - 1; i >= index; i--) {
                simpleArray[i + 1] = simpleArray[i];
            }
            simpleArray[index] = value;
            size++;
            resize();

            result = true;
        }

        return result;
    }

   @Override
    public boolean add(String value) {
        boolean result;

        if (value == null) {
            result = false;
        } else {
            simpleArray[size] = value;
            size++;
            resize();
            result = true;
        }

        return result;
    }

    public boolean delete(int index) {
        if (!isCorrectIndex(index)) {
            return false;
        } else {
            for (int i = index; i < size; i++) {
                simpleArray[i] = simpleArray[i + 1];
            }

            size--;
            resize();

            return true;
        }
    }

    @Override
    public boolean delete(String value) {
        if (value == null) {
            return false;
        } else {
            return this.delete(getFirstOccurrenceIndex(value));
        }
    }

    @Override
    public String get(int index) {
        if (!isCorrectIndex(index)) {
            return "<wrong index!!!>";
        } else {
            String value = simpleArray[index];
            return value;
        }
    }

    @Override
    public String toString() {
        String st = "List: ";
        if (size == 0) {
            st += "<empty>";
        } else {
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    st += ", ";
                }

                st += simpleArray[i];
            }
        }
        return st;
    }


    @Override
    public boolean contain(String o) {
        return (getFirstOccurrenceIndex(o) >= 0);
    }

    @Override
    public boolean equals(Collection str) {
       return this.toString().equals(str.toString());
    }

    @Override
    public boolean clear() {
        simpleArray = new String[1];
        size = 0;

        return true;
    }

    @Override
    public int size() {
        return size;
    }


}
