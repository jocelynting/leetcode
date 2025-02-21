package array;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }

        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        int maxLength = 0;
        boolean hasOdd = false;

        for (int c : count) {
            maxLength += c / 2 * 2;

            if (c % 2 == 1) {
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
        String s = "abccccddA";
        System.out.println("Longest palindrome length: " + solution.longestPalindrome(s)); // 7
    }
}

