package datastructures.interfaces;

import java.util.Collection;

public interface Queue<T> {
    boolean add(Object t);

    boolean offer(Object t);

    T remove() throws NoSuchFieldException;

    T poll() throws NoSuchFieldException;

    T element() throws NoSuchFieldException;

    T peek() throws NoSuchFieldException;

    boolean isEmpty();

    int size();
}
