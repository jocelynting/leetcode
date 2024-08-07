package backtracking;

import java.util.Arrays;

public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }

        int sum = 0;
        for (int m : matchsticks) {
            sum += m;
        }

        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        Arrays.sort(matchsticks);
        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - i - 1];
            matchsticks[matchsticks.length - i - 1] = temp;
        }

        int[] sides = new int[4];

        return backtracking(matchsticks, sides, 0, target);
    }

    private boolean backtracking(int[] matchsticks, int[] sides, int index, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > target) continue;

            sides[i] += matchsticks[index];
            if (backtracking(matchsticks, sides, index + 1, target)) {
                return true;
            }
            sides[i] -= matchsticks[index];

            if (sides[i] == 0) break;
        }

        return false;
    }

    public static void main(String[] args) {
        MatchsticksToSquare solution = new MatchsticksToSquare();

        int[] matchsticks1 = {1, 1, 2, 2, 2};
        System.out.println(solution.makesquare(matchsticks1)); // Output: true

        int[] matchsticks2 = {3, 3, 3, 3, 4};
        System.out.println(solution.makesquare(matchsticks2)); // Output: false
    }
}
