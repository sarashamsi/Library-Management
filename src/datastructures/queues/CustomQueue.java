package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomQueue() {
        list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(Object t) {
        list.addLast((T) t);
        return true ;
    }

    @Override
    public boolean offer(Object t) {
        try {
            list.addLast((T) t);
            return true ;
        }catch (Exception e){
            return false ;
        }
    }

    @Override
    public T remove() throws NoSuchFieldException {
        if (list.isEmpty()){
            throw new NoSuchFieldException("Queue is 'Empty' !");
        }
        return list.removeFirst();
    }

    @Override
    public T poll() throws NoSuchFieldException {
        if (list.isEmpty()){
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public T element() throws NoSuchFieldException {
        if (list.isEmpty()){
            throw new NoSuchFieldException("Queue is 'Empty' !");
        }
        return list.getFirst() ;
    }

    @Override
    public T peek() throws NoSuchFieldException {
        if (list.isEmpty()){
            return null ;
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    // TODO: Override and fill the methods to complete the data structure

}