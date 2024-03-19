package dp;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        for (String str: strs ) {
            int oneCount = 0;
            int zeroCount = 0;

            for (char s : str.toCharArray()) {
                if (s == '0'){
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            for (int i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount ; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }

        return dp[m][n];
    }

    private int countZeroes(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        OnesAndZeroes solution = new OnesAndZeroes();

        // Test case
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(solution.findMaxForm(strs, m, n)); // Output: 4
    }
}

