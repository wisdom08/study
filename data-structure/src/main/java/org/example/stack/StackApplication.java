package org.example.stack;

public class StackApplication {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(10);
        stack.push(300);
        stack.push(200);
        stack.push(100);

        stack.pop();

        boolean empty = stack.isEmpty();
        System.out.println("empty = " + empty);
        Integer top = stack.top();
        System.out.println("top = " + top);
    }
}
