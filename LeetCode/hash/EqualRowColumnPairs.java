package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowColumnPairs {
    public int equalPairs(int[][] grid) {
        int result = 0;
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();

        for (int[] row : grid) {
            String key = Arrays.toString(row);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int c = 0; c < n; c++) {
            int[] cols = new int[n];
            for (int r = 0; r < n; r++) {
                cols[r] = grid[r][c];
            }
            result += map.getOrDefault(Arrays.toString(cols), 0);
        }

        return result;
    }

    public static void main(String[] args) {
        EqualRowColumnPairs solution = new EqualRowColumnPairs();
        int[][] grid1 = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(solution.equalPairs(grid1)); // Output: 1

        int[][] grid2 = {{11, 1}, {1, 11}};
        System.out.println(solution.equalPairs(grid2)); // Output: 2
    }
}
