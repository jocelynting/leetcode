package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
//        return bfs(grid);
        return dfs(grid);
    }

    private int dfs(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid,i,j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid,row + 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    private int bfs(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int result = 0;

        for (int i = 0 ; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int[] dir: directions) {
                            int row = cur[0] + dir[0];
                            int col = cur[1] + dir[1];
                            if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == '1') {
                                grid[row][col] = '0';
                                queue.offer(new int[]{row, col});
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of islands: " + solution.numIslands(grid));// Output: 3
    }
}
