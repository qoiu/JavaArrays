package lesson03;

import java.util.EmptyStackException;

public class MyDeck<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int left = 0;
    private int right = 0;

    public MyDeck() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyDeck(int capacity){
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public void insertLeft(T item){
        outOfBoundsCheck();
        size++;
        list[left] = item;
        left = nextIndex(left);
    }

    public void insertRight(T item){
        outOfBoundsCheck();
        size++;
        right = prevIndex(right);
        list[right] = item;
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[right];
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[prevIndex(left)];
    }

    public T removeLeft() {
        T value = peekLeft();
        size--;
        list[right] = null;
        right = nextIndex(right);
        return value;
    }

    public T removeRight() {
        T value = peekRight();
        size--;
        list[left] = null;
        left = prevIndex(left);
        return value;
    }



    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int prevIndex(int index) {
        index--;
        if(index<0)return list.length+index;
        return (index) % list.length;
    }

    private void outOfBoundsCheck(){
        if (isFull()) {
            throw new StackOverflowError();
        }
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
