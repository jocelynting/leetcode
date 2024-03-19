package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n]; // dp[i] stores the length of the longest increasing subsequence ending at index i
        Arrays.fill(dp, 1); // Initialize each element as a subsequence of length 1

        int maxLen = 1; // Initialize the maximum length to 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Update the length of LIS ending at index i
                    maxLen = Math.max(maxLen, dp[i]); // Update the maximum length
                }
            }
        }

        return maxLen;

    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {4,10,4,3,8,9};
        System.out.println(solution.lengthOfLIS(nums)); // Output: 4
    }
}
