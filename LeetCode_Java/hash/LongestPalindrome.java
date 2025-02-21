package hash;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s.length();
        }

        Map<Character,Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int maxLength = 0;

        boolean hasOdd = false;

        for (int value: map.values()) {
            maxLength = maxLength + (value / 2) * 2;

            if (value % 2 == 1) {
                hasOdd = true;
            }
        }

        if (hasOdd) {
            maxLength++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();

        // Test case
        String s = "abccccdd";
        System.out.println("Longest palindrome length: " + solution.longestPalindrome(s));// 7
    }
}
