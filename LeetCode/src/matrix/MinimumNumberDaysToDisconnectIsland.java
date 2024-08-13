package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberDaysToDisconnectIsland {
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (numOfIsland(grid) != 1) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (numOfIsland(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private int numOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                count++;
                visited[i][j] = true;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});

                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for (int[] dir : directions) {
                        int row = cur[0] + dir[0];
                        int col = cur[1] + dir[1];

                        if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1 && !visited[row][col]) {
                            visited[row][col] = true;
                            queue.offer(new int[]{row, col});
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MinimumNumberDaysToDisconnectIsland solution = new MinimumNumberDaysToDisconnectIsland();
        int[][] grid = {
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
        };
        System.out.println(solution.minDays(grid)); // Output: 0
    }
}
