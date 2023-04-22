package org.example.stack;

import org.example.list.LinkedList;

public class InheritedStack<E> extends LinkedList<E> implements StackInterface<E> {

    public InheritedStack() {
        super(); // 상위 클래스의 생성자를 수행
    }

    @Override
    public void push(E newItem) {
        add(0, newItem);
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            return remove(0);
        }
        return null;
    }

    @Override
    public E top() {
        return get(0);
    }

    @Override
    public void popAll() {
        clear();
    }
}
