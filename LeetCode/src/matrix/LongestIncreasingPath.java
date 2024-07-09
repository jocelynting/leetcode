package matrix;

public class LongestIncreasingPath {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];
        int longest = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longest = Math.max(longest, dfs(matrix, i, j));
            }
        }

        return longest;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int max = 1;
        for (int[] direction : directions) {
            int r = row + direction[0];
            int c = col + direction[1];
            if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] > matrix[row][col]) {
                max = Math.max(max, 1 + dfs(matrix, r, c));
            }
        }

        memo[row][col] = max;

        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingPath solution = new LongestIncreasingPath();

        int[][] matrix1 = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(solution.longestIncreasingPath(matrix1)); // Output: 4

        int[][] matrix2 = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        System.out.println(solution.longestIncreasingPath(matrix2)); // Output: 4

        int[][] matrix3 = {
                {1}
        };
        System.out.println(solution.longestIncreasingPath(matrix3)); // Output: 1
    }
}
