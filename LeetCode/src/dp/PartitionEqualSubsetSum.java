package dp;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, cannot partition
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        boolean[][] dp = new boolean[n][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                //如果某个物品单独的重量恰好就等于背包的重量，那么也是满足dp数组的定义的
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                //如果某个物品的重量小于j，那就可以看该物品是否放入背包
                //dp[i - 1][j]表示该物品不放入背包，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
                //dp[i - 1][j - nums[i]]表示该物品放入背包。如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]。
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[n - 1][target];

        //一维DP数组
//        int[] dp = new int[target + 1];
//        for(int i = 0; i < n; i++) {
//            for(int j = target; j >= nums[i]; j--) {
//                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
//                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
//            }
//
//            //剪枝一下，每一次完成內層的for-loop，立即檢查是否dp[target] == target，優化時間複雜度（26ms -> 20ms）
//            if(dp[target] == target)
//                return true;
//        }
//        return dp[target] == target;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();

        // Test cases
        int[] nums1 = {1, 5, 11, 5};
        System.out.println(solution.canPartition(nums1)); // Output: true

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(solution.canPartition(nums2)); // Output: false

        int[] nums3 = {1, 2, 5};
        System.out.println(solution.canPartition(nums3)); // Output: false
    }
}

