package dp;

public class CoinChangeII {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeII solution = new CoinChangeII();
        // Test case
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(solution.change(amount, coins)); // Output: 4
    }
}
