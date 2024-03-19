package dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int j = 0; j < dp.length; j++) {
            dp[j] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 0; i < coins.length; i++){
            for (int j = coins[i]; j <= amount; j++){
                if (dp[j - coins[i]] != Integer.MAX_VALUE ){
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(solution.coinChange(coins, amount)); // Output: 3
    }
}
