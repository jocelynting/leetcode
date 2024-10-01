package designclass;

public class CustomStack {
    private int[] stack;
    private int count;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        count = -1;
    }

    public void push(int x) {
        if (count < stack.length - 1) {
            count++;
            stack[count] = x;
        }
    }

    public int pop() {
        if (count < 0) {
            return -1;
        }

        return stack[count--];
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, count + 1);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);     // Stack becomes [1]
        customStack.push(2);     // Stack becomes [1, 2]
        System.out.println(customStack.pop());   // return 2, Stack becomes [1]
        customStack.push(2);     // Stack becomes [1, 2]
        customStack.push(3);     // Stack becomes [1, 2, 3]
        customStack.push(4);     // Stack stays [1, 2, 3], maxSize is 3
        customStack.increment(5, 100); // Stack becomes [101, 102, 103]
        customStack.increment(2, 100); // Stack becomes [201, 202, 103]
        System.out.println(customStack.pop());   // return 103, Stack becomes [201, 202]
        System.out.println(customStack.pop());   // return 202, Stack becomes [201]
        System.out.println(customStack.pop());   // return 201, Stack becomes []
        System.out.println(customStack.pop());   // return -1, Stack is empty
    }
}
