package designclass;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // Test case
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Minimum Element in the Stack: " + minStack.getMin()); // Output: -3

        minStack.pop();

        System.out.println("Top Element in the Stack: " + minStack.top()); // Output: 0
        System.out.println("Minimum Element in the Stack: " + minStack.getMin()); // Output: -2
    }
}
