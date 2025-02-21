package dp;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j]) {
                    result++;
                }
            }
        }

        return result;

        /*
        int n = s.length();
        int result = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            result++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                result++;
            }
        }

        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(j) == s.charAt(i) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    result++;
                }
            }
        }

        return result;
         */
    }

    public static void main(String[] args) {
        PalindromicSubstrings solution = new PalindromicSubstrings();
        System.out.println(solution.countSubstrings("abc")); // Output: 3
        System.out.println(solution.countSubstrings("aaa")); // Output: 6
        System.out.println(solution.countSubstrings("abacdfgdcaba")); // Output: 14
    }
}
