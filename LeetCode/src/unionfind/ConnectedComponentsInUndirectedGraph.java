package unionfind;

public class ConnectedComponentsInUndirectedGraph {

    public int countComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.getCount();
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = size;

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

        public void union(int p, int q) {
            int rootP = parent[p];
            int rootQ = parent[q];

            if (rootQ != rootP) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    rank[rootP]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        ConnectedComponentsInUndirectedGraph solution = new ConnectedComponentsInUndirectedGraph();

        int n1 = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(solution.countComponents(n1, edges1)); // Output: 2

        int n2 = 5;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution.countComponents(n2, edges2)); // Output: 1

        int n3 = 4;
        int[][] edges3 = {{2, 3}, {1, 2}, {1, 3}};
        System.out.println(solution.countComponents(n3, edges3)); // Output: 2
    }
}
