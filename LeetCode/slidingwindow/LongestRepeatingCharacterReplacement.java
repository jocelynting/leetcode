package slidingwindow;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0, maxLength = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            count[r - 'A']++;
            maxCount = Math.max(maxCount, count[r - 'A']);
            right++;

            if (right - left - maxCount > k) {
                char l = s.charAt(left);
                count[l - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();

        System.out.println(solution.characterReplacement("ABAB", 2)); // Output：4
        System.out.println(solution.characterReplacement("AABABBA", 1)); // Output：4
        System.out.println(solution.characterReplacement("AAAB", 0)); // Output：3
        System.out.println(solution.characterReplacement("AAAA", 2)); // Output：4
    }
}
