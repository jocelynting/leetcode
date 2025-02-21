package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;

        Queue<int[]> queue = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }

                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] directions = {{0, 1},{1, 0}, {0, -1}, {-1, 0}};
        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] direction: directions) {
                    int row = cur[0] + direction[0];
                    int col = cur[1] + direction[1];
                    if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        fresh--;
                        queue.offer(new int[]{row, col});
                    }
                }
            }

            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();

        // Test Case 1
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("Test Case 1:");
        System.out.println("Minutes to rot all oranges: " + solution.orangesRotting(grid1));// 4

        // Test Case 2
        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println("\nTest Case 2:");
        System.out.println("Minutes to rot all oranges: " + solution.orangesRotting(grid2));// -1

        // Test Case 3
        int[][] grid3 = {
                {0, 2}
        };
        System.out.println("\nTest Case 3:");
        System.out.println("Minutes to rot all oranges: " + solution.orangesRotting(grid3));// 0
    }
}
