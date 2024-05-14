package matrix;

public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] != 1) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        for (int j = 1; j < n; j++) {
            int countZero = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) {
                    countZero++;
                }
            }

            if (countZero > m - countZero) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }

        }

        int score = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = grid[i][j] << (n - j - 1);
                score += cur;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix solution = new ScoreAfterFlippingMatrix();
        int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(solution.matrixScore(A)); // Output: 39
    }

}
