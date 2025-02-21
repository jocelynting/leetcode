package dp;

import java.util.Arrays;

public class FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int width = 0, height = 0;
            for (int j = i - 1; j >= 0; j--) {
                width += books[j][0];
                if (width > shelfWidth) break;
                height = Math.max(height, books[j][1]);
                dp[i] = Math.min(dp[i], dp[j] + height);
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        FillingBookcaseShelves solution = new FillingBookcaseShelves();

        int[][] books1 = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelfWidth1 = 4;
        System.out.println(solution.minHeightShelves(books1, shelfWidth1)); // Output: 6

        int[][] books2 = {{1, 3}, {2, 4}, {3, 2}};
        int shelfWidth2 = 6;
        System.out.println(solution.minHeightShelves(books2, shelfWidth2)); // Output: 4
    }
}
