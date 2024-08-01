package greedy;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int a : answers) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int color = entry.getKey();
            int count = entry.getValue();

            int groups = (color + count) / (color + 1);
            result += groups * (color + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        RabbitsInForest solution = new RabbitsInForest();

        int[] answers1 = {1, 1, 2};
        System.out.println(solution.numRabbits(answers1));  // Output: 5

        int[] answers2 = {10, 10, 10};
        System.out.println(solution.numRabbits(answers2));  // Output: 11
    }
}
