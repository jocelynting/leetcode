package matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LuckyNumbersInMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {

        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < cols; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            set.add(min);
        }

        for (int j = 0; j < cols; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            if (set.contains(max)) {
                result.add(max);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LuckyNumbersInMatrix solution = new LuckyNumbersInMatrix();

        int[][] matrix = {
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        };

        List<Integer> result = solution.luckyNumbers(matrix);

        System.out.println(result); // Output: [15]
    }
}
