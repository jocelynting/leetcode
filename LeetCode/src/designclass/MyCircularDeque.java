package designclass;

public class MyCircularDeque {
    public static void main(String[] args) {
        MyCircularDequeByLinkedList circularDeque1 = new MyCircularDequeByLinkedList(3);
        System.out.println(circularDeque1.insertLast(1)); // return true
        System.out.println(circularDeque1.insertLast(2)); // return true
        System.out.println(circularDeque1.insertFront(3)); // return true
        System.out.println(circularDeque1.insertFront(4)); // return false, the queue is full
        System.out.println(circularDeque1.getRear()); // return 2
        System.out.println(circularDeque1.isFull()); // return true
        System.out.println(circularDeque1.deleteLast()); // return true
        System.out.println(circularDeque1.insertFront(4)); // return true
        System.out.println(circularDeque1.getFront()); // return 4

        MyCircularDequeByArray circularDeque2 = new MyCircularDequeByArray(3);
        System.out.println(circularDeque2.insertLast(1)); // return true
        System.out.println(circularDeque2.insertLast(2)); // return true
        System.out.println(circularDeque2.insertFront(3)); // return true
        System.out.println(circularDeque2.insertFront(4)); // return false, the queue is full
        System.out.println(circularDeque2.getRear()); // return 2
        System.out.println(circularDeque2.isFull()); // return true
        System.out.println(circularDeque2.deleteLast()); // return true
        System.out.println(circularDeque2.insertFront(4)); // return true
        System.out.println(circularDeque2.getFront()); // return 4
    }
}

class MyCircularDequeByLinkedList {

    private class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private int capacity;
    private int size;
    private ListNode head;
    private ListNode tail;

    public MyCircularDequeByLinkedList(int k) {
        capacity = k;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            ListNode node = new ListNode(value);
            if (size == 0) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            ListNode node = new ListNode(value);
            if (size == 0) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
            size--;
            return true;
        }
    }

    public int getFront() {
        return isEmpty() ? -1 : head.val;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
class MyCircularDequeByArray {
    private int[] deque;
    private int capacity;
    private int first;
    private int last;

    public MyCircularDequeByArray(int k) {
        deque = new int[k + 1];
        capacity = k + 1;
        first = 0;
        last = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            first = (first - 1 + capacity) % capacity;
            deque[first] = value;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            deque[last] = value;
            last = (last + 1) % capacity;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            first = (first + 1) % capacity;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            last = (last - 1 + capacity) % capacity;
            return true;
        }
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[first];
    }

    public int getRear() {
        return isEmpty() ? -1 : deque[(last - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return first == last;
    }

    public boolean isFull() {
        return (last + 1) % capacity == first;
    }
}
