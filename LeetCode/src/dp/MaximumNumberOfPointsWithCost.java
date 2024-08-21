package dp;

public class MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] prev = new long[n];

        for (int j = 0; j < n; j++) {
            prev[j] = points[0][j];
        }

        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];
            long[] cur = new long[n];

            left[0] = prev[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1] - 1, prev[j]);
            }

            right[n - 1] = prev[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, prev[j]);
            }

            for (int j = 0; j < n; j++) {
                cur[j] = points[i][j] + Math.max(left[j], right[j]);
            }

            prev = cur;
        }

        long max = prev[0];
        for (int j = 1; j < n; j++) {
            max = Math.max(max, prev[j]);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumNumberOfPointsWithCost solution = new MaximumNumberOfPointsWithCost();

        int[][] points1 = {
                {1, 2, 3},
                {3, 4, 5},
                {5, 6, 7}
        };
        System.out.println(solution.maxPoints(points1)); // Output: 15

        int[][] points2 = {
                {5, 5, 5},
                {5, 5, 5},
                {5, 5, 5}
        };
        System.out.println(solution.maxPoints(points2)); // Output: 15
    }
}
