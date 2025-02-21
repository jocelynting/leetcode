package graph.unionfind;

public class MostStonesRemoved {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i, j);
                }
            }
        }

        return n - uf.count;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        public int count;

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
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP != rootQ) {
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
    }

    public static void main(String[] args) {
        MostStonesRemoved solution = new MostStonesRemoved();
        int[][] stones1 = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(solution.removeStones(stones1)); // Output: 5

        int[][] stones2 = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        System.out.println(solution.removeStones(stones2)); // Output: 3

        int[][] stones3 = {{0, 0}};
        System.out.println(solution.removeStones(stones3)); // Output: 0
    }
}
