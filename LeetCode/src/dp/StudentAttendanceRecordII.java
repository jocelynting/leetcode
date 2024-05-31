package dp;

public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        // dp[i][j][k]: number of sequences of length i with j 'A's and ending with k 'L's
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1; // One empty sequence

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    // Adding 'P'
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                    // Adding 'A'
                    if (j > 0) {
                        dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j - 1][k]) % MOD;
                    }
                    // Adding 'L'
                    if (k > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                    }
                }
            }
        }

        int result = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                result = (result + dp[n][j][k]) % MOD;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        StudentAttendanceRecordII solution = new StudentAttendanceRecordII();
        int n1 = 2;
        int n2 = 1;
        int n3 = 10101;
        System.out.println(solution.checkRecord(n1));// Output: 8
        System.out.println(solution.checkRecord(n2));// Output: 3
        System.out.println(solution.checkRecord(n3));// Output: 183236316
    }
}
