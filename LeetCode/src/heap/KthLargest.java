package heap;

import java.util.PriorityQueue;

public class KthLargest {

    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);
        for (int n: nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, nums);

        System.out.println("Kth largest after adding 3: " + kthLargest.add(3)); // Output: 4
        System.out.println("Kth largest after adding 5: " + kthLargest.add(5)); // Output: 5
        System.out.println("Kth largest after adding 10: " + kthLargest.add(10)); // Output: 5
        System.out.println("Kth largest after adding 9: " + kthLargest.add(9)); // Output: 8
        System.out.println("Kth largest after adding 4: " + kthLargest.add(4)); // Output: 8
    }
}
