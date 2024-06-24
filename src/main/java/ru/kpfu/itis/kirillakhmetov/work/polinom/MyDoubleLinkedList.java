package ru.kpfu.itis.kirillakhmetov.work.polinom;

public class MyDoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> current;
    private int size;

    public void add(T elem) {
        if (head == null) {
            head = new Node<>(elem);
            current = head;
        } else {
            Node<T> node = new Node<>(elem);
            node.setPrev(current);
            current.setNext(node);
            current = node;
        }
        size++;
    }

    public void remove(int index) {
        Node<T> currentNew = head;
        for (int i = 0; i < index; i++) {
            currentNew = currentNew.getNext();
        }
        if (currentNew.getPrev() == null) {
            head = currentNew.getNext();
        } else if (currentNew.getNext() == null) {
            currentNew.getPrev().setNext(null);
        } else {
            currentNew.getPrev().setNext(currentNew.getNext());
            currentNew.getNext().setPrev(currentNew.getPrev());
        }
        size--;
    }

    public T get(int index) {
        Node<T> currentNew = head;
        for (int i = 0; i < index; i++) {
            currentNew = currentNew.getNext();
        }
        return currentNew.getValue();
    }

    public int size() {
        return size;
    }

    public void printed() {
        Node<T> currentNew = head;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNew.getValue() + ", ");
            currentNew = currentNew.getNext();
        }
    }
}
