package bit;

public class LongestSubarrayWithMaximumBitwiseAND {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }

        int maxLength = 0, curLength = 0;
        for (int n : nums) {
            if (n == max) {
                curLength++;
                maxLength = Math.max(maxLength, curLength);
            } else {
                curLength = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubarrayWithMaximumBitwiseAND solution = new LongestSubarrayWithMaximumBitwiseAND();
        int[] nums1 = {1, 2, 3, 3, 2, 2};
        System.out.println(solution.longestSubarray(nums1));  // Output: 2

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.longestSubarray(nums2));  // Output: 1

        int[] nums3 = {5, 5, 5, 5, 5};
        System.out.println(solution.longestSubarray(nums3));  // Output: 5
    }
}
