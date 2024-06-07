package hash;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToMakeKPeriodic {

    public int minimumOperationsToMakeKPeriodic(String word, int k) {

        int length = word.length();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        while (index < length) {
            String substring = word.substring(index, Math.min(index + k, length));
            map.put(substring, map.getOrDefault(substring, 0) + 1);
            index += k;
        }

        int max = 0;
        for (int count: map.values()) {
            max = Math.max(count, max);
        }

        return length / k - max;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeKPeriodic solution = new MinimumOperationsToMakeKPeriodic();
        String word1 = "leetcodeleet";
        int k1 = 4;
        String word2 = "leetcoleet";
        int k2 = 2;

        System.out.println(solution.minimumOperationsToMakeKPeriodic(word1,k1)); // Output: 1
        System.out.println(solution.minimumOperationsToMakeKPeriodic(word2,k2)); // Output: 3
    }
}
