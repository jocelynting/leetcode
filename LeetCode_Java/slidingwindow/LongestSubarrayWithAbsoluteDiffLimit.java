package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestSubarrayWithAbsoluteDiffLimit {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0, right = 0;
        int result = 0;

        while (right < nums.length) {
            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            right++;

            while (!minDeque.isEmpty() && !maxDeque.isEmpty() && maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (nums[left] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }
                if (nums[left] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }
                left++;
            }

            result = Math.max(result, right - left);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubarrayWithAbsoluteDiffLimit solution = new LongestSubarrayWithAbsoluteDiffLimit();
        int[] nums1 = {8, 2, 4, 7};
        int limit1 = 4;
        System.out.println(solution.longestSubarray(nums1, limit1));  // Output：2
        int[] nums2 = {10, 1, 2, 4, 7, 2};
        int limit2 = 5;
        System.out.println(solution.longestSubarray(nums2, limit2));  // Output：4
    }
}
