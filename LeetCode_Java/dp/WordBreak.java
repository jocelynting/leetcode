package dp;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty string is always breakable

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int wordLen = word.length();
                if (i >= wordLen && dp[i - wordLen] && s.substring(i - wordLen, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(solution.wordBreak(s, wordDict)); // Output: true
    }
}
