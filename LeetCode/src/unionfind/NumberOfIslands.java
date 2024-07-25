package unionfind;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        int[][] directions = {{0, 1}, {1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    int curIndex = i * cols + j;
                    for (int[] dir : directions) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (row < rows && col < cols && grid[row][col] == '1') {
                            int neiIndex = row * cols + col;
                            uf.union(curIndex, neiIndex);
                        }
                    }
                }
            }
        }

        return uf.getCount();
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            parent = new int[rows * cols];
            rank = new int[rows * cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        int index = i * cols + j;
                        parent[index] = index;
                        rank[index] = 0;
                        count++;
                    }
                }
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

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of islands: " + solution.numIslands(grid));// Output: 3
    }
}
