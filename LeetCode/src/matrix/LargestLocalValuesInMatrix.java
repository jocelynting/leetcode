package matrix;

public class LargestLocalValuesInMatrix {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int[][] result = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                result[i][j] = findMax(grid, i, j);
            }
        }

        return result;
    }

    private int findMax(int[][] grid, int row, int col) {
        int max = 0;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        return  max;
    }

    public static void main(String[] args) {
        LargestLocalValuesInMatrix solution = new LargestLocalValuesInMatrix();
        int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] result = solution.largestLocal(grid);

        for (int[] row : result) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        //Output: [[9,9],[8,6]]
    }
}
