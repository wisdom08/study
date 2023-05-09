package com.example.designpattern.iterator;

public interface Iterator<E> {
    public abstract boolean hasNext();

    public abstract E next();
}
