package com.example;

import java.util.Stack;

public class MinStackQuestion {


    static class MinStack {

        private Stack<Long> stack;
        private long minElement;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            long longX = (long) x;
            if (stack.isEmpty()) {
                stack.push(longX);
                minElement = longX;
                return;
            }

            if (longX < minElement) { // 2 < 3
                stack.push(2 * longX - minElement); // 4 - 3 = 1
                minElement = longX; // 2
            } else {
                stack.push(longX);
            }
        }

        public void pop() {
            long result = stack.pop();
            if (result < minElement) {
                minElement = minElement * 2 - result;
            }
        }

        public int top() {
            if (stack.peek() < minElement) {
                return (int) minElement;
            }
            return stack.peek().intValue();
        }

        public int getMin() {
            return (int) minElement;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


}
