package array;

public class TakingMaximumEnergyFromMysticDungeon {
    public int maximumEnergy(int[] energy, int k) {

        int ans = Integer.MIN_VALUE;
        int n = energy.length;

        for (int i = n - k; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j -= k) {
                sum += energy[j];
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TakingMaximumEnergyFromMysticDungeon solution = new TakingMaximumEnergyFromMysticDungeon();
        int[] energy1 = {5,2,-10,-5,1};
        int k1 = 3;
        System.out.println(solution.maximumEnergy(energy1, k1)); // Output: 3
        int[] energy2 = {-2,-3,-1};
        int k2 = 2;
        System.out.println(solution.maximumEnergy(energy2, k2)); // Output: -1
    }
}
