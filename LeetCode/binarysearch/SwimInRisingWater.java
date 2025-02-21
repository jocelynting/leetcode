package binarysearch;

import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0], right = n * n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReachEnd(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReachEnd(int[][] grid, int t) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int row = cur[0], col = cur[1], height = cur[2];

            if (row == n - 1 && col == n - 1) {
                return true;
            }

            for (int[] dir : directions) {
                int r = row + dir[0], c = col + dir[1];
                if (r >= 0 && r < n && c >= 0 && c < n && !visited[r][c] && grid[r][c] <= t) {
                    pq.offer(new int[]{r, c, grid[r][c]});
                    visited[r][c] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SwimInRisingWater solution = new SwimInRisingWater();
        int[][] grid1 = {
                {0, 2, 1, 3},
                {3, 2, 3, 4},
                {2, 3, 2, 1},
                {3, 4, 4, 0}
        };
        System.out.println(solution.swimInWater(grid1)); // Output: 3

        int[][] grid2 = {
                {0, 2},
                {1, 3}
        };
        System.out.println(solution.swimInWater(grid2)); // Output: 3
    }
}
