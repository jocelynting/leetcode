package designclass;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        while (!outputStack.isEmpty()) {
            inputStack.push(outputStack.pop());
        }
        outputStack.push(x);
        while (!inputStack.isEmpty()){
            outputStack.push(inputStack.pop());
        }
    }

    public int pop() {
        return outputStack.pop();
    }

    public int peek() {
        return outputStack.peek();
    }

    public boolean empty() {
        return outputStack.isEmpty();
    }

    public static void main(String[] args) {
        // Create a queue instance
        MyQueue queue = new MyQueue();

        // Push elements into the queue
        queue.push(1);
        queue.push(2);
        queue.push(3);

        // Test peek operation
        System.out.println("Front element of the queue: " + queue.peek()); // Output: 1

        // Test pop operation
        System.out.println("Removed element from the front of the queue: " + queue.pop()); // Output: 1

        // Test empty operation
        System.out.println("Is the queue empty? " + queue.empty()); // Output: false
    }
}
