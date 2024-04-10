package designclass;

import java.util.Deque;
import java.util.LinkedList;

public class FrontMiddleBackQueue {

    private Deque<Integer> left;
    private Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    public void pushFront(int val) {
        left.offerFirst(val);
        update();
    }

    public void pushMiddle(int val) {
        left.offerLast(val);
        update();
    }

    public void pushBack(int val) {
        right.offerLast(val);
        update();
    }

    public int popFront() {
        if (left.size() + right.size() == 0) {
            return -1;
        }
        int val = left.size() != 0 ? left.pollFirst() : right.pollFirst();
        update();
        return val;
    }

    public int popMiddle() {
        if (left.size() + right.size() == 0) {
            return -1;
        }
        int val = left.size() == right.size() ? left.pollLast() : right.pollFirst();
        update();
        return val;
    }

    public int popBack() {
        if (left.size() + right.size() == 0) {
            return -1;
        }
        int val = right.pollLast();
        update();
        return val;
    }

    private void update() {
        while (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }

        while (right.size() - left.size() > 1) {
            left.offerLast(right.pollFirst());
        }
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
        queue.pushFront(1); // [1]
        queue.pushBack(2); // [1, 2]
        queue.pushMiddle(3); // [1, 3, 2]
        queue.pushMiddle(4); // [1, 4, 3, 2]
        System.out.println(queue.popFront()); // Output: 1
        System.out.println(queue.popMiddle()); // Output: 3
        System.out.println(queue.popMiddle()); // Output: 4
        System.out.println(queue.popBack()); // Output: 2
        System.out.println(queue.popFront()); // Output: -1
    }
}
