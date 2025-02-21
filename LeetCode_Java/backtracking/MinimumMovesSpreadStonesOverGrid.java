package backtracking;

import java.util.ArrayList;
import java.util.List;

public class MinimumMovesSpreadStonesOverGrid {

    private int min;
    private List<int[]> more;
    private List<int[]> zero;
    private boolean[] used;

    public int minimumMoves(int[][] grid) {
        min = Integer.MAX_VALUE;
        more = new ArrayList<>();
        zero = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] > 1) {
                    for (int k = 1; k < grid[i][j]; k++) {
                        more.add(new int[]{i, j});
                    }
                }

                if (grid[i][j] == 0) {
                    zero.add(new int[]{i, j});
                }
            }
        }

        used = new boolean[more.size()];
        backtracking(grid, 0, 0);
        return min;
    }

    private void backtracking(int[][] grid, int index, int distance) {
        if (index == zero.size()) {
            min = Math.min(min, distance);
            return;
        }

        int[] z = zero.get(index);
        for (int i = 0; i < more.size(); i++) {
            if (used[i]) continue;
            int[] cur = more.get(i);
            int row = cur[0], col = cur[1];
            int zRow = z[0], zCol = z[1];
            if (grid[row][col] > 1) {
                grid[row][col]--;
                grid[zRow][zCol]++;
                used[i] = true;

                int d = Math.abs(row - zRow) + Math.abs(col - zCol);
                backtracking(grid, index + 1, distance + d);

                grid[row][col]++;
                grid[zRow][zCol]--;
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        MinimumMovesSpreadStonesOverGrid solution = new MinimumMovesSpreadStonesOverGrid();
        int[][] grid1 = {{1, 1, 0}, {1, 1, 1}, {1, 2, 1}};
        System.out.println(solution.minimumMoves(grid1));// Output: 3

        int[][] grid2 = {{1, 3, 0}, {1, 0, 0}, {1, 0, 3}};
        System.out.println(solution.minimumMoves(grid2));// Output: 4
    }
}
