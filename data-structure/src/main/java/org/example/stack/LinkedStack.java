package org.example.stack;

import org.example.list.Node;

public class LinkedStack<E> implements StackInterface<E> {

    private Node<E> topNode;
    private final E ERROR = null;

    public LinkedStack() {
        topNode = null;
    }

    @Override
    public void push(E newItem) {
        topNode = new Node<>(newItem, topNode);
    }

    @Override
    public E pop() {
        if(isEmpty()) throw new RuntimeException();
        Node<E> temp = topNode;
        topNode = topNode.next;
        return temp.item;
    }

    @Override
    public E top() {
        if(isEmpty()) throw new RuntimeException();
        return topNode.item;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void popAll() {
        topNode = null;
    }
}
