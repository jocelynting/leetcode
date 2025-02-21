package hash;

import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words.length < 2) {
            return result;
        }

        Map<String, Integer> reverseMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            String reverse = sb.reverse().toString();
            reverseMap.put(reverse, i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int length = word.length();

            for (int j = 0; j <= length; j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);

                if (isPalindrome(prefix)) {
                    Integer suffixIndex = reverseMap.get(suffix);
                    if (suffixIndex != null && suffixIndex != i) {
                        result.add(Arrays.asList(suffixIndex, i));
                    }
                }

                if (j != length && isPalindrome(suffix)) {
                    Integer prefixIndex = reverseMap.get(prefix);
                    if (prefixIndex != null && prefixIndex != i) {
                        result.add(Arrays.asList(i, prefixIndex));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        PalindromePairs solution = new PalindromePairs();
        String[] words1 = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(solution.palindromePairs(words1));// Output: [[0,1],[1,0],[3,2],[2,4]]

        String[] words2 = {"bat", "tab", "cat"};
        System.out.println(solution.palindromePairs(words2));// Output: [[0,1],[1,0]]
    }

}
