package graph.dijkstra;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{src, 0, 0});

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int stop = cur[1];
            int price = cur[2];

            if (stop > stops[u] || stop > k + 1) continue;

            stops[u] = stop;

            if (u == dst) return price;

            if (!graph.containsKey(u)) continue;
            for (int[] nei : graph.get(u)) {
                pq.offer(new int[]{nei[0], stop + 1, price + nei[1]});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops solution = new CheapestFlightsWithinKStops();

        int n1 = 3;
        int[][] flights1 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src1 = 0;
        int dst1 = 2;
        int k1 = 1;
        System.out.println(solution.findCheapestPrice(n1, flights1, src1, dst1, k1)); // Expected output: 200

        int n2 = 3;
        int[][] flights2 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src2 = 0;
        int dst2 = 2;
        int k2 = 0;
        System.out.println(solution.findCheapestPrice(n2, flights2, src2, dst2, k2)); // Expected output: 500
    }
}
