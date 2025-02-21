package graph.unionfind;

public class RegionsCutBySlashes {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n;
        UnionFind uf = new UnionFind(size);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int root = 4 * (i * n + j);
                char ch = grid[i].charAt(j);

                if (ch == '/') {
                    uf.union(root + 0, root + 3);
                    uf.union(root + 1, root + 2);
                } else if (ch == '\\') {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 2, root + 3);
                } else {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 1, root + 2);
                    uf.union(root + 2, root + 3);
                }

                if (i + 1 < n) {
                    uf.union(root + 2, (root + 4 * n) + 0);
                }

                if (j + 1 < n) {
                    uf.union(root + 1, (root + 4) + 3);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            if (uf.find(i) == i) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RegionsCutBySlashes solution = new RegionsCutBySlashes();
        String[] grid = {
                " /",
                "/ "
        };
        System.out.println(solution.regionsBySlashes(grid)); // Output: 2
    }
}
