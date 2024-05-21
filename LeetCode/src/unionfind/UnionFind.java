package unionfind;

public class UnionFind {
    private final int[] parent;
    private final int[] rank;

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
        }
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);

        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(2, 4);

        System.out.println(uf.connected(1, 3)); // true, because 1-2-4-3 are connected.
        System.out.println(uf.connected(1, 5)); // false, because 5 is not connected to 1.

        uf.union(5, 6);
        uf.union(4, 5);

        System.out.println(uf.connected(1, 6)); // true, because 1-2-4-3-5-6 are connected.
        System.out.println(uf.connected(7, 8)); // false, 7 and 8 are not connected.

        uf.union(7, 8);
        System.out.println(uf.connected(7, 8)); // true, because now 7 and 8 are connected.
    }
}

