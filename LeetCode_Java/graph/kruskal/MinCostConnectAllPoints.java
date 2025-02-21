package graph.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinCostConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, dist});
            }
        }

        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);
        int result = 0;
        int edgeCount = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (uf.union(u, v)) {
                result += weight;
                edgeCount++;
                if (edgeCount == n - 1) break;
            }
        }

        return result;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return false;
            }

            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        MinCostConnectAllPoints solution = new MinCostConnectAllPoints();
        int[][] points1 = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int[][] points2 = {{3, 12}, {-2, 5}, {-4, 1}};
        System.out.println(solution.minCostConnectPoints(points1)); // Output: 20
        System.out.println(solution.minCostConnectPoints(points2)); // Output: 18
    }
}
