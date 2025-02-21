package graph;

import java.util.*;

public class TimeWhenNetworkBecomesIdle {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (dist[neighbor] == Integer.MAX_VALUE) {
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int max = 0;

        for (int i = 1; i < n; i++) {
            int round = 2 * dist[i];
            int lastSent = (round - 1) / patience[i] * patience[i];
            int totalTime = lastSent + round;
            max = Math.max(max, totalTime);
        }

        return max + 1;
    }

    public static void main(String[] args) {
        TimeWhenNetworkBecomesIdle solution = new TimeWhenNetworkBecomesIdle();

        int[][] edges1 = {{0, 1}, {1, 2}};
        int[] patience1 = {0, 2, 1};
        System.out.println(solution.networkBecomesIdle(edges1, patience1)); // Output: 8

        int[][] edges2 = {{0, 1}, {0, 2}, {1, 2}};
        int[] patience2 = {0, 10, 10};
        System.out.println(solution.networkBecomesIdle(edges2, patience2)); // Output: 3
    }
}
