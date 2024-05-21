package dp;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

public class FindNumberWaysReachKthStair {

    Map<String, Integer> memo;
    public int waysToReachStair(int k) {
        memo = new HashMap<>();
        return dfs(1, 0, k, false);
    }

    private int dfs(int i, int j, int k, boolean down) {
        if (i > k + 1) {
            return 0;
        }

        String key = i + "," + j + "," + down;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = 0;
        if (i == k) {
            result = 1;
        }

        result += dfs(i + (1 << j), j + 1, k, false);
        if (!down && i > 0) {
            result += dfs(i - 1, j, k, true);
        }

        memo.put(key, result);

        return result;
    }

    public static void main(String[] args) {
        FindNumberWaysReachKthStair solution = new FindNumberWaysReachKthStair();
        int k1 = 0;
        int k2 = 1;
        System.out.println(solution.waysToReachStair(k1));// Output: 2
        System.out.println(solution.waysToReachStair(k2));// Output: 4
    }
}
