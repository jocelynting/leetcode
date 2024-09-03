package matrix;

public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid2.length, cols = grid2[0].length;
        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int row, int col) {
        if (row < 0 || col < 0 || row >= grid2.length || col >= grid2[0].length || grid2[row][col] == 0) {
            return true;
        }

        grid2[row][col] = 0;

        boolean sub = true;
        if (grid1[row][col] == 0) {
            sub = false;
        }

        boolean up = dfs(grid1, grid2, row - 1, col);
        boolean down = dfs(grid1, grid2, row + 1, col);
        boolean left = dfs(grid1, grid2, row, col - 1);
        boolean right = dfs(grid1, grid2, row, col + 1);

        return sub && up && down && left && right;
    }

    public static void main(String[] args) {
        CountSubIslands solution = new CountSubIslands();
        int[][] grid1 = {
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}
        };
        int[][] grid2 = {
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
        };
        System.out.println(solution.countSubIslands(grid1, grid2));// Output: 3

        int[][] grid1_2 = {
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0}
        };
        int[][] grid2_2 = {
                {1, 0, 0, 0, 1},
                {0, 1, 1, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };
        System.out.println(solution.countSubIslands(grid1_2, grid2_2));// Output: 4
    }
}
