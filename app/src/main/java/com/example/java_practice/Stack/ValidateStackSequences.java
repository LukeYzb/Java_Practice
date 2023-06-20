package com.example.java_practice.Stack;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length <= 0) {
            return true;
        }

        int k = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[k]) {
                stack.pop();
                k++;
            }
        }

        return stack.isEmpty();
    }
}
