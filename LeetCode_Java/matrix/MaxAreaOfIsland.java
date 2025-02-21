package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        return maxAreaOfIslandByDFS(grid);
//        return maxAreaOfIslandByBFS(grid);
    }

    private int maxAreaOfIslandByDFS(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs(grid, i, j, visited));
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != 1 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int area = 1;
        area += dfs(grid, row - 1, col, visited);
        area += dfs(grid, row + 1, col, visited);
        area += dfs(grid, row, col - 1, visited);
        area += dfs(grid, row, col + 1, visited);

        return area;
    }

    private int maxAreaOfIslandByBFS(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int max = 0;

        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        area++;

                        for (int[] dir : direction) {
                            int row = cur[0] + dir[0];
                            int col = cur[1] + dir[1];

                            if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1
                                    && !visited[row][col]) {
                                visited[row][col] = true;
                                queue.offer(new int[]{row, col});
                            }
                        }

                    }
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };
        System.out.println(solution.maxAreaOfIsland(grid));// Output: 6
    }
}
