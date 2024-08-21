package memoization;

import java.util.Arrays;

public class StrangePrinter {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(s, 0, n - 1, memo);
    }

    private int dfs(String s, int i, int j, int[][] memo) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (memo[i][j] != -1) return memo[i][j];

        int res = dfs(s, i, j - 1, memo) + 1;

        for (int k = i; k < j; k++) {
            if (s.charAt(k) == s.charAt(j)) {
                res = Math.min(res, dfs(s, i, k, memo) + dfs(s, k + 1, j - 1, memo));
            }
        }

        memo[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        StrangePrinter solution = new StrangePrinter();
        System.out.println(solution.strangePrinter("aaabbb"));// Output: 2
        System.out.println(solution.strangePrinter("aba"));// Output: 2
    }
}
