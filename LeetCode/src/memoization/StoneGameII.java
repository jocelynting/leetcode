package memoization;

public class StoneGameII {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        int[][] memo = new int[n][n + 1];
        return dfs(piles, suffixSum, memo, 0, 1);
    }

    private int dfs(int[] piles, int[] suffixSum, int[][] memo, int index, int M) {
        if (index >= piles.length) {
            return 0;
        }

        if (index + 2 * M >= piles.length) {
            return suffixSum[index];
        }

        if (memo[index][M] > 0) {
            return memo[index][M];
        }

        int max = 0;
        for (int x = 1; x <= 2 * M; x++) {
            int cur = suffixSum[index] - dfs(piles, suffixSum, memo, index + x, Math.max(x, M));
            max = Math.max(max, cur);
        }

        memo[index][M] = max;

        return max;
    }

    public static void main(String[] args) {
        StoneGameII solution = new StoneGameII();
        int[] piles1 = {2, 7, 9, 4, 4};
        System.out.println(solution.stoneGameII(piles1));// Output: 10

        int[] piles2 = {1, 2, 3, 4, 5, 100};
        System.out.println(solution.stoneGameII(piles2));// Output: 104
    }
}

