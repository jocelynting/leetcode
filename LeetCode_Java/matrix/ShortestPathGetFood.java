package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathGetFood {
    public int getFood(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }

        }

        int result = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                if (grid[row][col] == '#') {
                    return result;
                }

                for (int[] dir : directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] != 'X' && !visited[r][c]) {
                        queue.offer(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }
            }
            result++;
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathGetFood solution = new ShortestPathGetFood();

        char[][] grid1 = {
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'X', '#', 'X'}
        };
        System.out.println(solution.getFood(grid1));  // Output: 6

        char[][] grid2 = {
                {'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'X', 'O', 'X'},
                {'X', 'O', 'X', '#', 'X'},
                {'X', 'X', 'X', 'X', 'X'}
        };
        System.out.println(solution.getFood(grid2));  // Output: -1
    }
}
