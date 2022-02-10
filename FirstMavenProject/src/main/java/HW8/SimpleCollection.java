package HW8;

public class SimpleCollection implements Collection<String> {

    private String[] simpleArray = new String[1];
    private int size;

    private boolean isCorrectIndex(int index) {
        return (index >= 0 && index < size) || (index == 0 && size == 0);
    }

    private void resize() {
        String[] newSimpleArray = new String[size + 1];

        for (int i = 0; i < size; i++) {
            newSimpleArray[i] = simpleArray[i];
        }

        simpleArray = newSimpleArray;
    }

    private int getFirstOccurrenceIndex(String value){
        for (int i = 0; i < size; i++) {
            if (simpleArray[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

   @Override
    public boolean add(int index, String value) {
        if (!isCorrectIndex(index)) {
            return false;
        } else if (index == size) {
            return this.add(value);
        } else {
            for (int i = size - 1; i >= index; i--) {
                simpleArray[i + 1] = simpleArray[i];
            }
            simpleArray[index] = value;
            size++;
            resize();

            return true;
        }
    }

   @Override
    public boolean add(String value) {
        simpleArray[size] = value;
        size++;
        resize();

        return true;
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
            return "<Incorrect index>";
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
