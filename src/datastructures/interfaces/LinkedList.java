package datastructures.interfaces;

public interface LinkedList<T> extends List{
    void addFirst(T t);
    void addLast(T t);
    T removeFirst() throws NoSuchFieldException;
    T removeLast() throws NoSuchFieldException;
    T getFirst() throws NoSuchFieldException;
    T getLast() throws NoSuchFieldException;
    void clear();
}
