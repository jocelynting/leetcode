package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> currentCount = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String currentWord = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordCount.containsKey(currentWord)) {
                    currentCount.put(currentWord, currentCount.getOrDefault(currentWord, 0) + 1);
                    count++;

                    while (currentCount.get(currentWord) > wordCount.getOrDefault(currentWord, 0)) {
                        String leftWord = s.substring(left, left + wordLength);
                        left += wordLength;
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        count--;
                    }

                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    currentCount.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubstringConcatenation solution = new SubstringConcatenation();
//        String s = "barfoofoobarthefoobarman";
//        String[] words = {"bar","foo","the"};
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo","barr","wing","ding","wing"};
        System.out.println(solution.findSubstring(s, words)); // Output: [0,9]
    }
}
