package slidingwindow;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int[] letters = new int[128];

        int left = 0, right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            letters[r]++;
            right++;

            while (letters[r] > 1) {
                char l = s.charAt(left);
                letters[l]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left);
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
