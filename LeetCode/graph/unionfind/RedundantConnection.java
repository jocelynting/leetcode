package graph.unionfind;

import java.util.Arrays;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {

        UnionFind uf = new UnionFind(edges.length + 1);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (uf.find(u) == uf.find(v)) {
                return edge;
            } else {
                uf.union(u, v);
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        RedundantConnection solution = new RedundantConnection();

        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(solution.findRedundantConnection(edges1))); // Output: [2, 3]

        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(solution.findRedundantConnection(edges2))); // Output: [2, 3]
    }
}
