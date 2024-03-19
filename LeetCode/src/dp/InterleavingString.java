package dp;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int p = s3.length();

        // Check if the lengths of s1, s2, and s3 add up
        if (m + n != p) {
            return false;
        }

        // Define a DP array
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base cases
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            char a = s1.charAt(i - 1);
            char b = s3.charAt(i - 1);
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int j = 1; j <= n; j++) {
            char a = s2.charAt(j - 1);
            char b = s3.charAt(j - 1);
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill in the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        InterleavingString solution = new InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3)); // Output: true
    }
}

