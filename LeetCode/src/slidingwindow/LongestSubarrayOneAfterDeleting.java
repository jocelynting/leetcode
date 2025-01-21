package slidingwindow;

public class LongestSubarrayOneAfterDeleting {
    public int longestSubarray(int[] nums) {
        int result = 0, count = 0;
        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[right] != 1) {
                count++;
            }
            right++;

            while (count > 1) {
                if (nums[left] != 1) {
                    count--;
                }
                left++;

            }

            result = Math.max(result, right - left);
        }

        return result - 1;
    }

    public static void main(String[] args) {
        LongestSubarrayOneAfterDeleting solution = new LongestSubarrayOneAfterDeleting();
        System.out.println(solution.longestSubarray(new int[]{1, 1, 0, 1})); // Output: 3
        System.out.println(solution.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1})); // Output: 5
        System.out.println(solution.longestSubarray(new int[]{1, 1, 1})); // Output: 2
    }
}
