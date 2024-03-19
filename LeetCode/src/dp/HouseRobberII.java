package dp;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null){
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int first = robRange(nums, 0, nums.length - 2);
        int second = robRange(nums, 1, nums.length - 1);

        return Math.max(first,second);
    }

    private int robRange(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start],nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[end];
    }

    public static void main(String[] args) {
        HouseRobberII solution = new HouseRobberII();

        // Test case
        int[] nums = {2, 3, 2};
        System.out.println(solution.rob(nums)); // Output: 3
    }
}

