package dp;

public class MaximumEnergyBoostFromTwoDrinks {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] dp = new long[n][2];
        dp[0][0] = energyDrinkA[0];
        dp[0][1] = energyDrinkB[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + energyDrinkA[i], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1] + energyDrinkB[i], dp[i - 1][0]);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);

        /*
                int n = energyDrinkA.length;
                long maxA = energyDrinkA[0];
                long maxB = energyDrinkB[0];

                for (int i = 1; i < n; i++) {
                    long curA = Math.max(maxA + energyDrinkA[i], maxB);
                    long curB = Math.max(maxB + energyDrinkB[i], maxA);
                    maxA = curA;
                    maxB = curB;
                }

                return Math.max(maxA, maxB);
         */
    }

    public static void main(String[] args) {
        MaximumEnergyBoostFromTwoDrinks solution = new MaximumEnergyBoostFromTwoDrinks();
        int[] energyDrinkA1 = {1, 3, 1};
        int[] energyDrinkB1 = {3, 1, 1};
        System.out.println(solution.maxEnergyBoost(energyDrinkA1, energyDrinkB1));// Output: 5

        int[] energyDrinkA2 = {4, 1, 1};
        int[] energyDrinkB2 = {1, 1, 3};
        System.out.println(solution.maxEnergyBoost(energyDrinkA2, energyDrinkB2));// Output: 7
    }
}
