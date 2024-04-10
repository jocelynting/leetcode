package designclass;

public class MyCircularQueue {
    public static void main(String[] args) {
        MyCircularQueueByLinkedList circularQueue1 = new MyCircularQueueByLinkedList(3); // set the size to be 3
        System.out.println(circularQueue1.enQueue(1)); // return true
        System.out.println(circularQueue1.enQueue(2)); // return true
        System.out.println(circularQueue1.enQueue(3)); // return true
        System.out.println(circularQueue1.enQueue(4)); // return false, the queue is full
        System.out.println(circularQueue1.Rear()); // return 3
        System.out.println(circularQueue1.isFull()); // return true
        System.out.println(circularQueue1.deQueue()); // return true
        System.out.println(circularQueue1.enQueue(4)); // return true
        System.out.println(circularQueue1.Rear()); // return 4

        MyCircularQueueByArray circularQueue2 = new MyCircularQueueByArray(3); // set the size to be 3
        System.out.println(circularQueue2.enQueue(1)); // return true
        System.out.println(circularQueue2.enQueue(2)); // return true
        System.out.println(circularQueue2.enQueue(3)); // return true
        System.out.println(circularQueue2.enQueue(4)); // return false, the queue is full
        System.out.println(circularQueue2.Rear()); // return 3
        System.out.println(circularQueue2.isFull()); // return true
        System.out.println(circularQueue2.deQueue()); // return true
        System.out.println(circularQueue2.enQueue(4)); // return true
        System.out.println(circularQueue2.Rear()); // return 4
    }
}

class MyCircularQueueByLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    private int capacity;
    private int size;
    private ListNode head;
    private ListNode tail;

    public MyCircularQueueByLinkedList(int k) {
        capacity = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            ListNode node = new ListNode(value);
            if (size == 0) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            head = head.next;
            size--;
            return true;
        }
    }

    public int Front() {
        return isEmpty() ? -1 : head.val;
    }

    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

class MyCircularQueueByArray {
    private int[] queue;
    private int capacity;

    private int first;

    private  int size;
    public MyCircularQueueByArray(int k) {
        queue = new int[k];
        capacity = k;
        first = 0;
        size = 0;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        } else {
            queue[(first + size) % capacity] = value;
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            first = (first + 1) % capacity;
            size--;
            return true;
        }
    }

    public int Front() {
        return isEmpty() ? -1 : queue[first];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[(first + size - 1) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

}
