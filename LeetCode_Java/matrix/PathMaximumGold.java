package matrix;

public class PathMaximumGold {
    private int maxGold = 0;

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(grid, i, j, 0);
            }
        }

        return maxGold;

    }

    private void dfs(int[][] grid, int row, int col, int total) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0 || grid[row][col] == -1) {
            maxGold = Math.max(maxGold, total);
            return;
        }

        int origin = grid[row][col];
        grid[row][col] = -1;

        dfs(grid, row + 1, col, origin + total);
        dfs(grid, row - 1, col, origin + total);
        dfs(grid, row, col + 1, origin + total);
        dfs(grid, row, col - 1, origin + total);

        grid[row][col] = origin;
    }

    public static void main(String[] args) {
        PathMaximumGold solution = new PathMaximumGold();
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(solution.getMaximumGold(grid)); // Output: 24
    }
}
