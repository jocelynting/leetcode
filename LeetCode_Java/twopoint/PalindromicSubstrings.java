package twopoint;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += countPalindromic(s, i, i);
            result += countPalindromic(s, i, i + 1);
        }

        return result;
    }

    private int countPalindromic(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings solution = new PalindromicSubstrings();
        System.out.println(solution.countSubstrings("abc")); // Output: 3
        System.out.println(solution.countSubstrings("aaa")); // Output: 6
        System.out.println(solution.countSubstrings("abacdfgdcaba")); // Output: 14
    }
}
