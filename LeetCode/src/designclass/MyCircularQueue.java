package designclass;

public class MyCircularQueue {
    private int[] queue;
    private int capacity;

    private int first;

    private  int size;
    public MyCircularQueue(int k) {
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

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1)); // return true
        System.out.println(circularQueue.enQueue(2)); // return true
        System.out.println(circularQueue.enQueue(3)); // return true
        System.out.println(circularQueue.enQueue(4)); // return false, the queue is full
        System.out.println(circularQueue.Rear()); // return 3
        System.out.println(circularQueue.isFull()); // return true
        System.out.println(circularQueue.deQueue()); // return true
        System.out.println(circularQueue.enQueue(4)); // return true
        System.out.println(circularQueue.Rear()); // return 4
    }
}
