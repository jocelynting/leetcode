package graph.prim;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Integer> set = new HashSet<>();
        int result = 0;

        pq.offer(new int[]{0, 0});

        while (set.size() < n) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int point = cur[1];

            if (set.contains(point)) continue;

            set.add(point);
            result += cost;

            for (int i = 0; i < n; i++) {
                if (!set.contains(i)) {
                    int newCost = Math.abs(points[point][0] - points[i][0]) + Math.abs(points[point][1] - points[i][1]);
                    pq.offer(new int[]{newCost, i});
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinCostConnectAllPoints solution = new MinCostConnectAllPoints();
        int[][] points1 = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int[][] points2 = {{3, 12}, {-2, 5}, {-4, 1}};
        System.out.println(solution.minCostConnectPoints(points1)); // Output: 20
        System.out.println(solution.minCostConnectPoints(points2)); // Output: 18
    }
}
