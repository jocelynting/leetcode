package dp;

public class CountingBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }

        return dp;
    }

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();

        // Test case
        int num = 5;
        int[] result = solution.countBits(num);
        System.out.println("Counting bits for numbers up to " + num + ":");
        for (int i = 0; i <= num; i++) {
            System.out.print(result[i] + " ");
        }
        // Output: 0 1 1 2 1 2
    }
}
