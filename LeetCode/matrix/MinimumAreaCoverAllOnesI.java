package matrix;

public class MinimumAreaCoverAllOnesI {

    public int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int minRow = rows, maxRow = 0, minCol = cols, maxCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((grid[i][j] & 1) == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        int width = maxRow - minRow + 1;
        int height = maxCol - minCol + 1;

        return width * height;
    }

    public static void main(String[] args) {
        MinimumAreaCoverAllOnesI solution = new MinimumAreaCoverAllOnesI();
        int[][] grid1 = {{0, 1, 0}, {1, 0, 1}};
        System.out.println(solution.minimumArea(grid1));// Output: 6
        int[][] grid2 = {{0, 0}, {1, 0}};
        System.out.println(solution.minimumArea(grid2));// Output: 1
    }
}
