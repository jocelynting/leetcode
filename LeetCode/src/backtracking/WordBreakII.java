package backtracking;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        backtracking(s, words, result, 0, new StringBuilder());
        return result;
    }

    private void backtracking(String s, Set<String> words, List<String> result, int start, StringBuilder cur){
        if (start == s.length()) {
            result.add(cur.toString().trim());
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (words.contains(word)) {
                int curLength = cur.length();
                cur.append(word).append(" ");
                backtracking(s, words, result, end, cur);
                cur.setLength(curLength);
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII solution = new WordBreakII();
        String s1 = "catsanddog";
        List<String> wordDict1 = new ArrayList<>(Arrays.asList("cat","cats","and","sand","dog"));
        System.out.println(solution.wordBreak(s1, wordDict1));
        // Output: ["cats and dog","cat sand dog"]

        String s2 = "pineapplepenapple";
        List<String> wordDict2 = new ArrayList<>(Arrays.asList("apple","pen","applepen","pine","pineapple"));
        System.out.println(solution.wordBreak(s2, wordDict2));
        // Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
    }
}
