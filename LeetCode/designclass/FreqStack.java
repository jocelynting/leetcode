package designclass;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {

    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> freqStack;
    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (!freqStack.containsKey(f)) {
            freqStack.put(f, new Stack<>());
        }
        freqStack.get(f).push(val);

        if (f > maxFreq) {
            maxFreq = f;
        }
    }

    public int pop() {
        Stack<Integer> stack = freqStack.get(maxFreq);
        int val = stack.pop();
        freq.put(val, freq.get(val) - 1);

        if (stack.isEmpty()) {
            maxFreq--;
        }

        return val;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop()); // Output: 5
        System.out.println(freqStack.pop()); // Output: 7
        System.out.println(freqStack.pop()); // Output: 5
        System.out.println(freqStack.pop()); // Output: 4
    }
}
