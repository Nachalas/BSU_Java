package com.company;

import java.sql.Statement;
import java.util.Stack;

public class MyStack {
    private Stack<Integer> stack = new Stack<>();

    public void push(Integer number) {
        stack.push(number);
    }

    public void pop() {
        stack.pop();
    }

    public Integer getLast() {
        return stack.peek();
    }

    public void set(Integer index, Integer changeTo) {
        stack.set(index, changeTo);
    }

    public Integer get(Integer index) {
        return stack.get(index);
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public void delete(Integer index) {
        stack.removeElementAt(index);
    }
}
