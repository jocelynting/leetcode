package graph.dijkstra;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, w});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];

            if (d > distance[u]) {
                continue;
            }

            if (graph.containsKey(u)) {
                for (int[] edge : graph.get(u)) {
                    int v = edge[0];
                    int w = edge[1];
                    if (distance[u] + w < distance[v]) {
                        distance[v] = distance[u] + w;
                        pq.offer(new int[]{v, distance[v]});
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, distance[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        System.out.println(solution.networkDelayTime(times, n, k)); // Output: 2
    }
}
