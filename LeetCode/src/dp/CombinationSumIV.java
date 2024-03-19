package dp;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV solution = new CombinationSumIV();

        // Test case
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(solution.combinationSum4(nums, target)); // Output: 7
    }
}

