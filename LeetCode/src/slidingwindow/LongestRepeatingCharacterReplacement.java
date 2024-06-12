package slidingwindow;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxLength = 0;
        int maxCount = 0;
        int[] count = new int[26];

        while (right < s.length()) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            right++;

            if (right - left - maxCount > k) {
                count[s.charAt(left) - 'A']--;
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
