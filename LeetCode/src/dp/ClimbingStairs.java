package dp;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

//    public int climbStairs(int n) {
//        if (n <= 2) {
//            return n;
//        }
//
//        int dp1 = 2;
//        int dp2 = 1;
//
//        for (int i = 3; i <= n; i++) {
//            int dp = dp1 + dp2;
//            dp2= dp1;
//            dp1 = dp;
//        }
//
//        return dp1;
//    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        int n = 4;
        System.out.println(solution.climbStairs(n)); // Output: 5
    }
}
