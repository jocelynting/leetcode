package twopoint;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String oddString = palindromeFromCenter(s, i, i); // Odd length palindrome
            String evenString = palindromeFromCenter(s, i, i + 1); // Even length palindrome

            result = result.length() > oddString.length() ? result : oddString;
            result = result.length() > evenString.length() ? result : evenString;
        }

        return result;
    }

    private String palindromeFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // left + 1 because when the chars are same, left--, so need to +1 to the right spot
        // right stay the same because substring is [ )
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

        // Test case
        String s = "babad";
        System.out.println("Longest palindromic substring: " + solution.longestPalindrome(s)); // Output: "bab" or "aba"
    }
}

