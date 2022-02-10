package HW13;

public class MyPair {
    private String key;
    private String value;

    MyPair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String setValue(String v) {
        value = v;
        return value;
    }

    @Override
    public String toString() {
        return "{\"" + key + "\":\"" + value + "\"}";
    }
}