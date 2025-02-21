package heap;

import java.util.PriorityQueue;

public class RangeSumOfSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1_000_000_007;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{nums[i], i, i + 1});
        }

        long result = 0;
        for (int i = 1; i <= right; i++) {
            int cur[] = minHeap.poll();
            int sum = cur[0];
            int start = cur[1];
            int end = cur[2];

            if (i >= left) {
                result = (result + sum) % MOD;
            }

            if (end < n) {
                minHeap.offer(new int[]{sum + nums[end], start, end + 1});
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        RangeSumOfSortedSubarraySums sol = new RangeSumOfSortedSubarraySums();
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 1;
        int right = 5;
        System.out.println(sol.rangeSum(nums, n, left, right)); // Output: 13
    }
}
