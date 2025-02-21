package matrix;

import java.util.Arrays;
import java.util.List;

public class MaximumDifferenceScore {

    public int maxScore(List<List<Integer>> grid) {
        int result = Integer.MIN_VALUE;

        int rows = grid.size(), cols = grid.get(0).size();
        int[][] minMatrix = new int[rows + 1][cols + 1];

        Arrays.fill(minMatrix[0], Integer.MAX_VALUE);

        for (int i = 0; i < rows; i++) {
            minMatrix[i + 1][0] = Integer.MAX_VALUE;
            List<Integer> row = grid.get(i);
            for (int j = 0; j < cols; j++) {
                int min = Math.min(minMatrix[i + 1][j], minMatrix[i][j + 1]);
                int r = row.get(j);
                result = Math.max(result, r - min);
                minMatrix[i + 1][j + 1] = Math.min(min, r);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumDifferenceScore solution = new MaximumDifferenceScore();
        List<List<Integer>> grid1 = Arrays.asList(
                Arrays.asList(9, 5, 7, 3),
                Arrays.asList(8, 9, 6, 1),
                Arrays.asList(6, 7, 14, 3),
                Arrays.asList(2, 5, 3, 1)
        );
        System.out.println(solution.maxScore(grid1));// Output: 9

        List<List<Integer>> grid2 = Arrays.asList(
                Arrays.asList(4,3,2),
                Arrays.asList(3,2,1)
        );
        System.out.println(solution.maxScore(grid2));// Output: -1
    }
}
