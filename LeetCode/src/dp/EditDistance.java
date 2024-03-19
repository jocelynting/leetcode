package dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a DP table to store the minimum edit distance
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first row and first column of the DP table
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Minimum edit distance to convert word1[0...i-1] to an empty string
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Minimum edit distance to convert an empty string to word2[0...j-1]
        }

        // Fill in the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Choose the minimum of three operations: insert, delete, or substitute
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }

        // Return the minimum edit distance
        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();

        // Test case
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(solution.minDistance(word1, word2)); // Output: 3
    }
}

