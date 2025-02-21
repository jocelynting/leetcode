package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindowMap(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // Create frequency maps for characters in strings s and t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int requiredChars = tMap.size();
        int formedChars = 0;

        // Sliding window approach
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (tMap.containsKey(rightChar)) {
                tMap.put(rightChar, tMap.get(rightChar) - 1);
                if (tMap.get(rightChar) == 0) {
                    formedChars++;
                }
            }

            // Check if all required characters are present in the current window
            while (formedChars == requiredChars) {
                // Update the minimum window length and left index
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                if (tMap.containsKey(leftChar)) {
                    tMap.put(leftChar, tMap.get(leftChar) + 1);
                    if (tMap.get(leftChar) > 0) {
                        formedChars--;
                    }
                }

                // Move the left pointer to shrink the window
                left++;
            }

            // Move the right pointer to expand the window
            right++;
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public String minWindowArray(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] tFreq = new int[128]; // Assuming ASCII characters
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int requiredChars = t.length();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (tFreq[rightChar] > 0) {
                requiredChars--;
            }
            tFreq[rightChar]--;

            while (requiredChars == 0) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                tFreq[leftChar]++;
                if (tFreq[leftChar] > 0) {
                    requiredChars++;
                }
                left++;
            }

            right++;
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindowMap(s, t));
        System.out.println(solution.minWindowArray(s, t));
    }
}
