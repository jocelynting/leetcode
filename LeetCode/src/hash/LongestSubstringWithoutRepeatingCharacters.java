package hash;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = -1;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            map.put(c,end);
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

        // Test cases
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println("Length of Longest Substring Without Repeating Characters in s1: " + solution.lengthOfLongestSubstring(s1)); // Output: 3
        System.out.println("Length of Longest Substring Without Repeating Characters in s2: " + solution.lengthOfLongestSubstring(s2)); // Output: 1
        System.out.println("Length of Longest Substring Without Repeating Characters in s3: " + solution.lengthOfLongestSubstring(s3)); // Output: 3
    }
}

