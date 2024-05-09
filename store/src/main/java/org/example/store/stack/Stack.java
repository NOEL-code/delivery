package org.example.store.stack;

import java.util.ArrayList;

public class Stack {
    public static void main(String[] args) {
        MyStack<String> stackStr = new MyStack<>();

        System.out.println(stackStr.isEmpty());
        stackStr.push("a"); // 1
        stackStr.push("b"); // 2
        stackStr.push("c"); // 3

        System.out.println(stackStr.pop());
        System.out.println(stackStr.peek());

        System.out.println(stackStr.isEmpty());

        stackStr.printElements();
    }
}

class MyStack<T> {
    public MyStack() {}

    ArrayList<T> elements = new ArrayList<>();

    public void push(T t) {
        elements.add(t);
    }

    public T pop() {
        return elements.remove(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void printElements() {
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i));
        }
    }

    public int size() {
        return elements.size();
    }

    public T peek() {
        return elements.get(elements.size() - 1);
    }

}
