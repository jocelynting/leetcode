package matrix;

import java.util.Arrays;

public class ValidMatrixGivenRowColumnSums {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] maxtrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                maxtrix[i][j] = min;

                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }

        return maxtrix;
    }

    public static void main(String[] args) {
        ValidMatrixGivenRowColumnSums solution = new ValidMatrixGivenRowColumnSums();
        int[] rowSum = {3, 8};
        int[] colSum = {4, 7};

        int[][] result = solution.restoreMatrix(rowSum, colSum);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
