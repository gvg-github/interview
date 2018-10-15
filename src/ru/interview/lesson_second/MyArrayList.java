package ru.interview.lesson_second;

import java.util.*;

/**
 * @author Valeriy Gyrievskikh
 * Реализация ArrayList.
 * @since 15.10.2018
 */
public class MyArrayList<T> {

    private T[] values;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int modCount;

    public MyArrayList() {
        this.values = ((T[]) new Object[DEFAULT_CAPACITY]);
    }

    public void add(T value) {
        values[size] = value;
        size++;
        if (size == values.length) {
            addLength();
        }
    }

    public void add(int index, T value) {
        T[] newValues = ((T[]) new Object[values.length]);
        System.arraycopy(values, 0, newValues, 0, index);
        newValues[index] = value;
        System.arraycopy(values, index, newValues, index + 1, values.length - index);
        values = newValues;
        size++;
        if (size == values.length) {
            addLength();
        }
    }

    public T get(int index) {
        return values[index];
    }

    public int get(T value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void remove(T value) {
        if (contain(value)) {
            int index = get(value);
            T[] newValues = ((T[]) new Object[values.length]);
            System.arraycopy(values, 0, newValues, 0, index);
            if (index < size - 1){
                System.arraycopy(values, index + 1, newValues, index, size - index);
            }
            values = newValues;
            size--;
        }
    }

    public void trimToSize() {
        if (size < values.length) {
            Arrays.copyOf(values, size);
        }
    }

    public boolean contain(T value) {
        boolean contain = false;
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                contain = true;
                break;
            }
        }
        return contain;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void addLength() {
        T[] newValues = ((T[]) new Object[values.length + DEFAULT_CAPACITY]);
        System.arraycopy(values, 0, newValues, 0, values.length);
        values = newValues;
        modCount++;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentSize;
            private final int currentModCount = modCount;

            @Override
            public boolean hasNext() {
                if (currentModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return currentSize < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return values[currentSize++];
            }
        };
    }
}
