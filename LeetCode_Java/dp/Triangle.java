package dp;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Create an array to store the minimum path sum for each position in the triangle
        int[] dp = new int[n];

        // Initialize the dp array with the values from the bottom row of the triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Bottom-up approach to find the minimum path sum
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // Update the dp array with the minimum sum for each position
                dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
            }
        }

        // The minimum path sum will be stored at dp[0], which represents the top of the triangle
        return dp[0];
    }

    public static void main(String[] args) {
        Triangle solution = new Triangle();
        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        System.out.println(solution.minimumTotal(triangle)); // Output: 11
    }
}

