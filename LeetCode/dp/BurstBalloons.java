package dp;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] points = new int[n + 2];
        points[0] = 1;
        points[n + 1] = 1;
        for (int i = 1; i < points.length - 1; i++) {
            points[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]);
                }
            }
        }

        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        BurstBalloons solution = new BurstBalloons();
        int[] nums1 = {3, 1, 5, 8};
        System.out.println(solution.maxCoins(nums1)); // Output: 167

        int[] nums2 = {1, 5};
        System.out.println(solution.maxCoins(nums2)); // Output: 10
    }
}
