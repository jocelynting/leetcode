package dp;

public class DecodeWays {
    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int num = s.charAt(i - 1) - '0';
            if (num > 0 && num <= 9) {
                dp[i] = dp[i - 1];
            }

            int pre = s.charAt(i - 2) - '0';
            int total = pre * 10 + num;
            if (total >= 10 && total <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();

        String s1 = "12";
        System.out.println(solution.numDecodings(s1)); // Output: 2

        String s2 = "226";
        System.out.println(solution.numDecodings(s2)); // Output: 3

        String s3 = "0";
        System.out.println(solution.numDecodings(s3)); // Output: 0

        String s4 = "06";
        System.out.println(solution.numDecodings(s4)); // Output: 0

        String s5 = "2101";
        System.out.println(solution.numDecodings(s5)); // Output: 1
    }
}
