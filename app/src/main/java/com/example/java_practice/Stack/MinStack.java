package com.example.java_practice.Stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1, stack2;

    public MinStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            //Integer, value > 127
            if (stack1.peek().intValue() == stack2.peek().intValue()) {
                stack2.pop();
            }
            stack1.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
