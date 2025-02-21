package memoization;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {

    public int integerReplacement(int n) {
        Map<Long, Integer> memo = new HashMap<>();
        return dfs(n, memo);
    }

    private int dfs(long n, Map<Long, Integer> memo) {
        if (n == 1) return 0;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = 0;

        if (n % 2 == 0) {
            result = dfs(n / 2, memo) + 1;
        } else {
            result = Math.min(dfs(n + 1, memo), dfs(n - 1, memo)) + 1;
        }

        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        IntegerReplacement solution = new IntegerReplacement();

        System.out.println(solution.integerReplacement(8));  // Output: 3
        System.out.println(solution.integerReplacement(7));  // Output: 4
        System.out.println(solution.integerReplacement(4));  // Output: 2
    }
}
