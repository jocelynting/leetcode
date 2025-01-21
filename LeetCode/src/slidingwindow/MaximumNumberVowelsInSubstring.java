package slidingwindow;

public class MaximumNumberVowelsInSubstring {
    public int maxVowels(String s, int k) {
        int max = 0, count = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            if (isVowel(r)) {
                count++;
            }
            right++;

            if (right - left == k) {
                max = Math.max(max, count);

                char l = s.charAt(left);
                if (isVowel(l)) {
                    count--;
                }
                left++;
            }
        }

        return max;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        MaximumNumberVowelsInSubstring solution = new MaximumNumberVowelsInSubstring();
        System.out.println(solution.maxVowels("abciiidef", 3)); // Output: 3
        System.out.println(solution.maxVowels("aeiou", 2)); // Output: 2
        System.out.println(solution.maxVowels("leetcode", 3)); // Output: 2
    }
}
