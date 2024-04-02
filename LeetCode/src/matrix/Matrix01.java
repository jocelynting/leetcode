package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> queue = new LinkedList<>();

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] result = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int distance = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : directions) {
                    int row = cur[0] + dir[0];
                    int col = cur[1]  + dir[1];
                    if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]) {
                        result[row][col] = distance;
                        visited[row][col] = true;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Matrix01 solution = new Matrix01();
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] result = solution.updateMatrix(matrix);
        for (int[] row : result) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
