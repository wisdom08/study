package org.example.stack;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Test Seq 12345";
        String reversedInput = reverse(input);

        System.out.println("input = " + input);
        System.out.println("reversedInput = " + reversedInput);
    }

    private static String reverse(String input) {
        ArrayStack<Character> arrayStack = new ArrayStack<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            arrayStack.push(input.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!arrayStack.isEmpty()) {
            sb.append(arrayStack.pop());
        }
        return sb.toString();
    }
}
