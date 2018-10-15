package ru.interview.lesson_second;

import java.util.*;

/**
 * @author Valeriy Gyrievskikh
 * @since 15.10.2018
 */
public class MyLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;
    private int modCount;

    public MyLinkedList() {

    }

    public boolean add(T value) {
        Node<T> node = new Node<>(value, last);
        if (first == null) {
            first = node;
        }
        if (last != null){
            last.setNext(node);
        }
        last = node;
        size++;
        modCount++;
        return true;
    }

    public void remove(T value) {
        for (Node<T> x = first; x != null; x = x.next) {
            if (value.equals(x.value)) {
                Node<T> prevNode = x.getPrev();
                Node<T> nextNode = x.getNext();
                if (prevNode != null) {
                    prevNode.setNext(nextNode);
                }
                if (nextNode != null) {
                    nextNode.setPrev(prevNode);
                }
                size--;
                break;
            }
        }
    }

    public T get(int index) {
        int count = 0;
        T value = null;
        for (Node<T> x = first; x != null; x = x.next) {
            if (count == index) {
                value = x.getValue();
            }
            count++;
        }
        return value;
    }

    public boolean contain(T value) {
        boolean contain = false;
        for (Node<T> x = first; x != null; x = x.next) {
            if (value.equals(x.value)) {
                contain = true;
                break;
            }
        }
        return contain;
    }

    public void set(int index, T value) {
        int count = 0;
        Node<T> prevNode = null;
        for (Node<T> x = first; x != null; x = x.next) {
            if (count == index) {
                Node<T> newNode = new Node<>(value, prevNode);
                newNode.setNext(x);
                x.setPrev(newNode);
                break;
            }
            prevNode = x;
            count++;
        }
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T value;

        public Node(T value, Node<T> node) {
            this.value = value;
            this.prev = node;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }

        public void setPrev(Node<T> node) {
            this.prev = node;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public T getValue() {
            return value;
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> lastReturned;
            private Node<T> next = first;
            private int nextIndex;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount){
                    throw new ConcurrentModificationException();
                }
                return nextIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturned = next;
                next = next.next;
                nextIndex++;
                return lastReturned.value;
            }
        };
    }
}
