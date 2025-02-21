package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumNumberOfMovesInGrid {

    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 0, 0});
            visited[i][0] = true;
        }

        int[][] directions = {{-1, 1}, {0, 1}, {1, 1}};
        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0], col = cur[1], count = cur[2];

                result = Math.max(result, count);

                for (int[] dir : directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && grid[r][c] > grid[row][col]) {
                        queue.offer(new int[]{r, c, count + 1});
                        visited[r][c] = true;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        MaximumNumberOfMovesInGrid solution = new MaximumNumberOfMovesInGrid();
        int[][] grid = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };

        System.out.println(solution.maxMoves(grid));// Output: 3
    }
}
