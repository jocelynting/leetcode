package graph.unionfind;

public class RemoveEdgesKeepGraphFullTraversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufAlice = new UnionFind(n);
        UnionFind ufBob = new UnionFind(n);

        int edgesRequired = 0;

        // First, add all type 3 edges
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean addedAlice = ufAlice.union(edge[1] - 1, edge[2] - 1);
                boolean addedBob = ufBob.union(edge[1] - 1, edge[2] - 1);
                if (addedAlice || addedBob) {
                    edgesRequired++;
                }
            }
        }

        // Next, add type 1 and type 2 edges
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (ufAlice.union(edge[1] - 1, edge[2] - 1)) {
                    edgesRequired++;
                }
            } else if (edge[0] == 2) {
                if (ufBob.union(edge[1] - 1, edge[2] - 1)) {
                    edgesRequired++;
                }
            }
        }

        // Check if both Alice and Bob can traverse the entire graph
        if (ufAlice.count != 1 || ufBob.count != 1) {
            return -1;
        }

        return edges.length - edgesRequired;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        RemoveEdgesKeepGraphFullTraversable solution = new RemoveEdgesKeepGraphFullTraversable();

        int n1 = 4;
        int[][] edges1 = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
        System.out.println(solution.maxNumEdgesToRemove(n1, edges1)); // Output: 2

        int n2 = 4;
        int[][] edges2 = {{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}};
        System.out.println(solution.maxNumEdgesToRemove(n2, edges2)); // Output: 0

        int n3 = 4;
        int[][] edges3 = {{3, 2, 3}, {1, 1, 2}, {2, 3, 4}};
        System.out.println(solution.maxNumEdgesToRemove(n3, edges3)); // Output: -1
    }
}
