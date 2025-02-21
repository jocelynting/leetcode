package matrix;

public class SubmatricesWithEqualFrequency {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] countX = new int[cols];
        int[] countY = new int[cols];

        int result = 0;

        for (int i = 0; i < rows; i++) {
            int x = 0, y = 0;
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'X') {
                    x++;
                }
                countX[j] += x;

                if (grid[i][j] == 'Y') {
                    y++;
                }
                countY[j] += y;

                if (countX[j] >= 1 && countX[j] == countY[j]) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubmatricesWithEqualFrequency solution = new SubmatricesWithEqualFrequency();

        char[][] grid1 = {{'X', 'Y', '.'}, {'Y', '.', '.'}};
        System.out.println(solution.numberOfSubmatrices(grid1));// Output: 3

        char[][] grid2 = {{'X', 'X'}, {'X', 'Y'}};
        System.out.println(solution.numberOfSubmatrices(grid2));// Output: 0

        char[][] grid3 = {{'.', '.'}, {'.', '.'}};
        System.out.println(solution.numberOfSubmatrices(grid3));// Output: 0
    }
}
