package dp;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(solution.rob(nums)); // Output: 12
    }
}
