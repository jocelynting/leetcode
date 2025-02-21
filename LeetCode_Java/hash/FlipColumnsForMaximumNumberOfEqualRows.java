package hash;

import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberOfEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;

        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();

            for (int n : row) {
                sb.append(n == row[0] ? 0 : 1);
            }

            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
            result = Math.max(result, map.get(s));
        }

        return result;
    }

    public static void main(String[] args) {
        FlipColumnsForMaximumNumberOfEqualRows solution = new FlipColumnsForMaximumNumberOfEqualRows();
        int[][] matrix1 = {{0, 1}, {1, 1}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix1)); // Output: 1

        int[][] matrix2 = {{0, 1}, {1, 0}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix2)); // Output: 2

        int[][] matrix3 = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix3)); // Output: 2
    }
}
