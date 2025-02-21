package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SecondMinimumTimeToDestination {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Array to store the first and second minimum time to reach each node
        int[][] result = new int[n + 1][2];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        result[1][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int curTime = cur[1];

            for (int nei : graph.get(u)) {
                int travelTime = curTime + time;
                int waitTime = 0;

                // Calculate wait time if the signal is red
                if ((curTime / change) % 2 == 1) {
                    waitTime = change - (curTime % change);
                }

                int arrivalTime = travelTime + waitTime;

                if (arrivalTime < result[nei][0]) {
                    result[nei][1] = result[nei][0];
                    result[nei][0] = arrivalTime;
                    pq.add(new int[]{nei, arrivalTime});
                } else if (arrivalTime > result[nei][0] && arrivalTime < result[nei][1]) {
                    result[nei][1] = arrivalTime;
                    pq.add(new int[]{nei, arrivalTime});
                }
            }
        }

        return result[n][1];
    }

    public static void main(String[] args) {
        SecondMinimumTimeToDestination solution = new SecondMinimumTimeToDestination();

        int[][] edges1 = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        System.out.println(solution.secondMinimum(5, edges1, 3, 5));// Output: 13

        int[][] edges2 = {{1, 2}};
        System.out.println(solution.secondMinimum(2, edges2, 3, 2));// Output: 11
    }
}
