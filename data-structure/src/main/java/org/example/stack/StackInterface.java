package org.example.stack;

import javax.naming.SizeLimitExceededException;

public interface StackInterface<E> {
    void push(E newItem) throws SizeLimitExceededException;
    E pop();
    E top();
    boolean isEmpty();
    void popAll();
}
