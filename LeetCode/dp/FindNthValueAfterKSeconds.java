package dp;

import java.util.Arrays;

public class FindNthValueAfterKSeconds {
    private static final int MOD = 1000000007;
    public int valueAfterKSeconds(int n, int k) {

        long[] dp = new long[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < k; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }

        return (int)dp[n - 1];

    }

    public static void main(String[] args) {
        FindNthValueAfterKSeconds solution = new FindNthValueAfterKSeconds();
        int n1 = 4, k1 = 5;
        System.out.println(solution.valueAfterKSeconds(n1, k1));// Output: 56
        int n2 = 5, k2 = 3;
        System.out.println(solution.valueAfterKSeconds(n2, k2));// Output: 35
    }
}
