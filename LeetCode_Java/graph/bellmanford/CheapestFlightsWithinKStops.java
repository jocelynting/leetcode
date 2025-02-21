package graph.bellmanford;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(price, n);
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                if (price[u] != Integer.MAX_VALUE && price[u] + w < temp[v]) {
                    temp[v] = price[u] + w;
                }
            }
            price = temp;
        }

        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
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
