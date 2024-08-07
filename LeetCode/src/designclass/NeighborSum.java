package designclass;

public class NeighborSum {
    private int[][] adjacentDirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] diagonalDirs = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private int n;
    private int[][] grid;
    private int[][] indexs;

    public NeighborSum(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        this.indexs = new int[n * n][];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                indexs[grid[i][j]] = new int[]{i, j};
            }
        }
    }

    public int adjacentSum(int value) {
        int sum = 0;
        int[] index = indexs[value];
        for (int[] dir : adjacentDirs) {
            int r = index[0] + dir[0], c = index[1] + dir[1];
            if (r >= 0 && r < n && c >= 0 && c < n) {
                sum += grid[r][c];
            }
        }
        return sum;
    }

    public int diagonalSum(int value) {
        int sum = 0;
        int[] index = indexs[value];
        for (int[] dir : diagonalDirs) {
            int r = index[0] + dir[0], c = index[1] + dir[1];
            if (r >= 0 && r < n && c >= 0 && c < n) {
                sum += grid[r][c];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2}, {3, 4, 5,}, {6, 7, 8}};
        NeighborSum solution = new NeighborSum(grid);
        System.out.println(solution.adjacentSum(1));// Output: 6
        System.out.println(solution.adjacentSum(4));// Output: 16
        System.out.println(solution.diagonalSum(4));// Output: 16
        System.out.println(solution.diagonalSum(8));// Output: 4
    }
}
