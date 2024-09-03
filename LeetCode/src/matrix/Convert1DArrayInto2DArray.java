package matrix;

import java.util.Arrays;

public class Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {

        if (m * n != original.length) {
            return new int[0][0];
        }

        int[][] result = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[index];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Convert1DArrayInto2DArray solution = new Convert1DArrayInto2DArray();
        int[] original1 = {1, 2, 3, 4};
        System.out.println(Arrays.deepToString(solution.construct2DArray(original1, 2, 2)));
        // Output: [[1,2],[3,4]]

        int[] original2 = {1, 2, 3};
        System.out.println(Arrays.deepToString(solution.construct2DArray(original1, 1, 3)));
        // Output: [[1,2,3]]
    }
}
