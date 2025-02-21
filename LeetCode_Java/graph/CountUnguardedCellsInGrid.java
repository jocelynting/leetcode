package graph;

public class CountUnguardedCellsInGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] visited = new int[m][n];
        int result = m * n;

        for (int[] g : guards) {
            visited[g[0]][g[1]] = 1;
            result--;
        }

        for (int[] w : walls) {
            visited[w[0]][w[1]] = 2;
            result--;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] g : guards) {
            for (int[] dir : directions) {
                int row = g[0];
                int col = g[1];

                while (true) {
                    row += dir[0];
                    col += dir[1];

                    if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] == 1 || visited[row][col] == 2) {
                        break;
                    }

                    if (visited[row][col] == 0) {
                        visited[row][col] = 3;
                        result--;
                    }

                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CountUnguardedCellsInGrid solution = new CountUnguardedCellsInGrid();
        int[][] guards1 = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls1 = {{0, 1}, {2, 2}, {1, 4}};
        System.out.println(solution.countUnguarded(4, 6, guards1, walls1)); // Output: 7

        int[][] guards2 = {{1, 1}};
        int[][] walls2 = {{0, 1}, {1, 0}, {2, 1}, {1, 2}};
        System.out.println(solution.countUnguarded(3, 3, guards2, walls2)); // Output: 4
    }
}
