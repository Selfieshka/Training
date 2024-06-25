package ru.kpfu.itis.kirillakhmetov.work.graphs;

public class MyLinkedList<T> {
    public int size;
    private Node<T> root;
    private Node<T> current;

    public MyLinkedList() {
    }

    public T get(int index) {
        Node<T> current1 = root;
        for (int i = 0; i < index; i++) {
            current1 = current1.getNext();
        }
        return current1.getValue();
    }

    public void add(T elem) {
        if (root == null) {
            root = new Node<>(elem);
            current = root;
            size++;
        } else {
            Node<T> node = new Node<>(elem);
            current.setNext(node);
            current = current.getNext();
            size++;
        }
    }

    public void remove(int index) {
        Node<T> current1 = root;
        if (index == 0) {
            root = root.getNext();
            size--;
        } else if (index <= size) {
            for (int i = 0; i < index - 1; i++) {
                current1 = current1.getNext();
            }
            current1.setNext(current1.getNext().getNext());
            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void printed() {
        Node<T> current1 = root;
        while (current1 != null) {
            System.out.println(current1.getValue());
            current1 = current1.getNext();
        }
    }

    public int size() {
        return size;
    }
}
