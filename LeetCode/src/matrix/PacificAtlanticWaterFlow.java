package matrix;

import java.util.*;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
//        return pacificAtlanticByDFS(heights);
        return pacificAtlanticByBFS(heights);
    }

    private List<List<Integer>> pacificAtlanticByDFS(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0);
            dfs(heights, atlantic, r, cols - 1);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c);
            dfs(heights, atlantic, rows - 1, c);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int row, int col) {
        ocean[row][col] = true;
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && r < rows && c >= 0 && c < cols && !ocean[r][c] && heights[r][c] >= heights[row][col]) {
                dfs(heights, ocean, r, c);
            }
        }
    }

    private List<List<Integer>> pacificAtlanticByBFS(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            pacificQueue.offer(new int[]{r, 0});
            atlanticQueue.offer(new int[]{r, cols - 1});
        }
        for (int c = 0; c < cols; c++) {
            pacificQueue.offer(new int[]{0, c});
            atlanticQueue.offer(new int[]{rows - 1, c});
        }

        bfs(heights, pacific, pacificQueue);
        bfs(heights, atlantic, atlanticQueue);

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, boolean[][] ocean, Queue<int[]> queue) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            ocean[row][col] = true;

            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= 0 && r < rows && c >= 0 && c < cols && !ocean[r][c]
                        && heights[r][c] >= heights[row][col]) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(solution.pacificAtlantic(heights));
        // Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
    }
}
