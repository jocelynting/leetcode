package slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int left = 0, right = 0, index = 0;

        while (right < nums.length) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
                queue.pollLast();
            }
            queue.offer(right);

            if (left > queue.peekFirst()) {
                queue.pollFirst();
            }

            if ((right + 1) >= k) {
                result[index++] = nums[queue.peekFirst()];
                left++;
            }
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxInWindow = solution.maxSlidingWindow(nums, k);
        System.out.println("Maximum elements in each window: " + Arrays.toString(maxInWindow));// output: [3,3,5,5,6,7]
        /*
            Window position                Max
            ---------------               -----
            [1  3  -1] -3  5  3  6  7       3
            1 [3  -1  -3] 5  3  6  7        3
            1  3 [-1  -3  5] 3  6  7        5
            1  3  -1 [-3  5  3] 6  7        5
            1  3  -1  -3 [5  3  6] 7        6
            1  3  -1  -3  5 [3  6  7]       7
         */
    }
}
