package dp;

import java.util.Arrays;

public class MaximumTotalRewardUsingOperationsI {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        int max = 2 * rewardValues[n - 1] - 1;
        int result = rewardValues[n - 1];

        // 0-1 knapsack problem
        // [1,2,3,4,6]
        // [0...4]
        // [0...11]
        boolean[] dp = new boolean[max + 1];

        // init dp
        // not pick 0th element
        dp[0] = true;
        // pick 0th element
        dp[rewardValues[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < max + 1; j++) {
                if (dp[j]) {
                    // not pick ith element
                    dp[j] = true;
                    // pick ith element
                    // rewardValues[i] is greater than your current total reward x
                    if (j < rewardValues[i]) {
                        dp[rewardValues[i] + j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < max + 1; i++) {
            if (dp[i] && i > result) {
                result = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumTotalRewardUsingOperationsI solution = new MaximumTotalRewardUsingOperationsI();
        int[] rewardValues1 = {1,1,3,3};
        System.out.println(solution.maxTotalReward(rewardValues1));// Output: 4
        int[] rewardValues2 = {1,6,4,3,2};
        System.out.println(solution.maxTotalReward(rewardValues2));// Output: 11
    }
}
