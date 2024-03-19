package heap;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for (int stone: stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first - second > 0) {
                maxHeap.offer(first - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();

    }

    public static void main(String[] args) {
        LastStoneWeight solution = new LastStoneWeight();

        // Test cases
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        int[] stones2 = {1, 1, 1, 1, 1};

        System.out.println("Last stone weight (stones1): " + solution.lastStoneWeight(stones1)); // Output: 1
        System.out.println("Last stone weight (stones2): " + solution.lastStoneWeight(stones2)); // Output: 1
    }
}
