package matrix;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }

        int original = image[sr][sc];
        if (original == color) {
            return image;
        }

        dfs(image, sr, sc, original, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        int row = image.length;
        int col = image[0].length;

        if (r < 0 || r >= row || c < 0 || c >= col || image[r][c] != originalColor) {
            return;
        }

        image[r][c] = newColor;

        dfs(image,r + 1, c, originalColor, newColor);
        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
    }

    public static void main(String[] args) {
        FloodFill solution = new FloodFill();

        // Test case
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = solution.floodFill(image, sr, sc, newColor);
        System.out.println("Modified Image:");
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
        /*
        2 2 2
        2 2 0
        2 0 1
         */
    }
}


