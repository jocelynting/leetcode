package memoization;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {

    Map<String, Boolean> memo;
    Set<Integer> set;
    int lastStone;

    public boolean canCross(int[] stones) {
        memo = new HashMap<>();
        set = new HashSet<>();
        lastStone = stones[stones.length - 1];

        for (int s : stones) {
            set.add(s);
        }

        return dfs(0, 0);
    }

    private boolean dfs(int position, int lastJump) {
        String key = position + "," + lastJump;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (position == lastStone) {
            return true;
        }

        for (int next = lastJump - 1; next <= lastJump + 1; next++) {
            if (next > 0 && set.contains(position + next)) {
                if (dfs(position + next, next)) {
                    memo.put(key, true);
                    return true;
                }
            }
        }

        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        FrogJump solution = new FrogJump();
        int[] stones1 = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(solution.canCross(stones1));  // Output: true

        int[] stones2 = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(solution.canCross(stones2));  // Output: false
    }
}
