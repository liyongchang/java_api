package com.leetcode;

import java.util.Stack;

public class No30MinStack {
    Stack<Long> stack;
    Long min;

    /**
     * initialize your data structure here.
     */
    public void MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0l);
            min = Long.valueOf(x);
        } else {
            stack.push((long) (x - min));
            min = Math.min(x, min);
        }
    }

    public void pop() {
        if (stack.peek() < 0) {
            min = min - stack.pop();
            return;
        }
        stack.pop();
    }

    public int top() {
        if (stack.peek() > 0) {
            return (int) (min + stack.peek());
        } else {
            return Math.toIntExact(min);
        }
    }

    public int min() {
        return Math.toIntExact(min);
    }
}
