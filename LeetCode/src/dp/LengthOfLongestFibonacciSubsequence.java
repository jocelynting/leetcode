package dp;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        int max = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int k = map.getOrDefault(arr[j] - arr[i], -1);
                if (k >= 0 && k < i) {
                    dp[i][j] = dp[k][i] + 1;
                    max = Math.max(max, dp[i][j] + 2);
                }
            }
        }

        return max;// max >= 3 ? max : 0
    }

    public static void main(String[] args) {
        LengthOfLongestFibonacciSubsequence solution = new LengthOfLongestFibonacciSubsequence();
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solution.lenLongestFibSubseq(arr1));  // Output: 5 (1, 2, 3, 5, 8)

        int[] arr2 = {1, 3, 7, 11, 12, 14, 18};
        System.out.println(solution.lenLongestFibSubseq(arr2));  // Output: 3 (1, 11, 12)
    }
}
