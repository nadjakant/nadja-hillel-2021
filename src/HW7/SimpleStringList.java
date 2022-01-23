package HW7;

public class SimpleStringList {

//Реализовать простую коллекцию для String на базе массива.
//Реализовать следующие методы для работы с коллекцией:
//1. public boolean add(int index, String value);
//2. public boolean add(String value);
//3. public boolean delete(int index);
//4. public boolean delete(String value);
//5. public String get(int index);

    private String[] simpleArray = new String[1];
    private int size;

    private boolean isCorrectIndex(int index) {
        return (index >= 0 && index < simpleArray.length);
    }

    private void resize() {
        String[] newSimpleArray = new String[size + 1];

        for (int i = 0; i < size; i++) {
            newSimpleArray[i] = simpleArray[i];
        }
        simpleArray = newSimpleArray;
    }

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
        boolean result = false;

        if (!isCorrectIndex(index)) {
            result = false;
        } else {
            for (int i = index; i < size; i++) {
                simpleArray[i] = simpleArray[i + 1];
            }

            size--;
            resize();

            result = true;
        }
        return result;
    }

    public boolean delete(String value) {
        boolean result = false;
        int currentIndex = 0;

        if (value == null) {
            result = false;
        } else {
            for (int i = 0; i < size; i++) {
                if (simpleArray[i].equals(value)) {
                    currentIndex = i;
                    break;
                }
            }
            result = this.delete(currentIndex);
        }
        return result;
    }

    public String get(int index) {
        if (!isCorrectIndex(index)) {
            return null;
        } else {
            String value = simpleArray[index];
            return value;
        }
    }

    public int getSize(){
        return this.size;
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

}

