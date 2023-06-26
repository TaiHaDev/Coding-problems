package leetcode.stack;

import java.util.Stack;

public class MinStack155 {
    /**
     * The idea is to use another stack that have a corresponding min to a number in the main stack so that when we pop
     * the current value out of the main stack, we still have the min value available
     */
    class MinStack {
        Stack<Integer> minStack = new Stack();
        Stack<Integer> stack = new Stack();
        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
                return;
            }
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

}
