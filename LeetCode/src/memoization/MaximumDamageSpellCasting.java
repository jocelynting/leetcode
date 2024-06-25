package memoization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumDamageSpellCasting {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : power) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int n = map.size();
        int[] count = new int[n];
        int index = 0;
        for (int num : map.keySet()) {
            count[index] = num;
            index++;
        }
        Arrays.sort(count);

        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(count, map, memo, n - 1);
    }

    private long dfs(int[] count, Map<Integer, Integer> map, long[] memo, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int num = count[i];
        int j = i;
        while (j > 0 && count[j - 1] >= num - 2) {
            j--;
        }
        return memo[i] = Math.max(dfs(count, map, memo, i - 1), dfs(count, map, memo, j - 1) + (long) num * map.get(num));
    }

    public static void main(String[] args) {
        MaximumDamageSpellCasting solution = new MaximumDamageSpellCasting();

        int[] power1 = {1, 1, 3, 4};
        System.out.println(solution.maximumTotalDamage(power1)); // Output: 6

        int[] power2 = {7, 1, 6, 6};
        System.out.println(solution.maximumTotalDamage(power2)); // Output: 13
    }
}
