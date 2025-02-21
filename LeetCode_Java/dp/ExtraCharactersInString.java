package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtraCharactersInString {

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (set.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    dp[i] = Math.min(dp[i], dp[j] + (i - j));
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ExtraCharactersInString solution = new ExtraCharactersInString();
        String s1 = "leetscode";
        String[] dict1 = {"leet", "code", "leetcode"};
        System.out.println(solution.minExtraChar(s1, dict1)); // Output: 1

        String s2 = "sayhelloworld";
        String[] dict2 = {"hello", "world"};
        System.out.println(solution.minExtraChar(s2, dict2)); // Output: 3
    }
}
