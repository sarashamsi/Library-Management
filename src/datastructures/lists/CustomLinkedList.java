package datastructures.lists;
import datastructures.interfaces.LinkedList;

public class CustomLinkedList<T> implements LinkedList<T>{

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public void addFirst(T t) {
        Node<T> node = new Node<>(t);
        if (isEmpty()){
            head = tail = node ;
        }else {
            node.next = head ;
            head.prev = node ;
            head = node ;
        }
        size++;
    }

    @Override
    public void addLast(T t) {
        Node<T> node = new Node<>(t);
        if (isEmpty()){
            head = tail = node ;
        }else {
            tail.next = node ;
            node.prev = tail;
            tail = node ;
        }
        size++ ;
    }

    @Override
    public T removeFirst() throws NoSuchFieldException {
        if (isEmpty()){
            throw new NoSuchFieldException("List is 'Empty' !");
        }
        T data = head.data;
        head = head.next ;
        if (head != null){
            head.prev = null ;
        }else {
            tail = null ;
        }
        size -- ;
        return data ;
    }

    @Override
    public T removeLast() throws NoSuchFieldException {
        if (isEmpty()){
            throw new NoSuchFieldException("List is 'Empty' !");
        }
        T data = tail.data;
        tail = tail.prev ;
        if (tail != null){
            tail.next = null ;
        }else {
            head = null ;
        }
        size--;
        return data ;
    }

    @Override
    public T getFirst() throws NoSuchFieldException {
        if (isEmpty()){
            throw new NoSuchFieldException("List is 'Empty' !");
        }
        return head.data ;
    }

    @Override
    public T getLast() throws NoSuchFieldException {
        if (isEmpty()){
            throw new NoSuchFieldException("List is 'Empty' !");
        }
        return tail.data ;
    }

    @Override
    public void clear() {
        head = tail = null ;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index : "+ index);
        }
        Node<T> current = head ;
        for (int i=0 ; i < index ; i++){
            current = current.next;
        }
        return current.data ;
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index : "+ index);
        }
        Node<T> current = head ;
        for (int i=0 ; i<index ; i++){
            current = current.next;
        }
        T value = current.data;
        current.data = (T) element ;
        return value ;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0 ;
    }

    @Override
    public boolean add(Object o) {
        addLast((T) o);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head ;
        while (current != null){
            if (current.data.equals(o)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) throws NoSuchFieldException {
        Node<T> current = head ;
        while (current != null){
            if (current.data.equals(o)){
                if (current == head){
                    removeFirst();
                }else if (current == tail){
                    removeLast();
                } else {
                    current.prev.next = current.next ;
                    current.next.prev = current.prev;
                    size-- ;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }


    // TODO: Override and fill the methods to complete the data structure

}