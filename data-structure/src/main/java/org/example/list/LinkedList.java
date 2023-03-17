package org.example.list;

public class LinkedList<E> implements ListInterface<E> {

    private Node<E> head;
    private int numItems;

    @Override
    public void add(int index, E item) {
        if (index >= 0 && index <= numItems) {
            Node<E> preNode = getNode(index - 1);
            Node<E> newNode = new Node<>(item, preNode.next);
            preNode.next = newNode;
            numItems++;
        }
    }

    @Override
    public void append(E item) {
        Node<E> preNode = head;
        while (preNode.next != null) {
            preNode = preNode.next;
        }
        Node<E> newNode = new Node<>(item, null);
        preNode.next = newNode;
        numItems++;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < numItems) {
            Node<E> preNode = getNode(index - 1);
            Node<E> currentNode = preNode.next;
            preNode.next = currentNode.next;
            numItems--;
            return currentNode.item;
        }
        return null;
    }

    @Override
    public boolean removeItem(E x) {
        Node<E> currentNode = head;
        Node<E> preNode;
        for (int i = 0; i < numItems; i++) {
            preNode = currentNode;
            currentNode = currentNode.next;
            if (((Comparable) (currentNode.item)).compareTo(x) == 0) {
                preNode.next = currentNode.next;
                numItems--;
                return true;
            }
        }

        return false;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return getNode(index).item;
        }
        return null;
    }

    public Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            Node<E> currentNode = head;
            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        } else {
            return null;
        }
    }

    @Override
    public void set(int index, E x) {

    }

    private final int NOT_FOUND = -12345;
    @Override
    public int indexOf(E x) {
        Node<E> currentNode = head; // 더미 노드

        for (int i = 0; i < numItems; i++) {
            currentNode = currentNode.next;
            if(((Comparable)(currentNode.item)).compareTo(x) == 0){
                return i;
            }
        }

        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        head = new Node<>(null, null);
    }
}
