package dp;

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1; // 1*1

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
            }
        }
        return dp[n];
     }

    public static void main(String[] args) {
        IntegerBreak solution = new IntegerBreak();
        // Test case
        int n = 10;
        System.out.println(solution.integerBreak(n)); // Output: 36
    }

}
