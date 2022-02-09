package HW8;

public interface Collection<Type> {
    public boolean add(Type o);

    public boolean add(int index, Type o);

    public boolean delete(Type o);

    public Type get(int index);

    public boolean contain(Type o);

    public boolean equals(Collection str);

    public boolean clear();

    public int size();
}
