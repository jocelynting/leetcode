package string;

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String reverse = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reverse;

        int[] lps = computeKMPTable(combined);
        int palindromeLength = lps[combined.length() - 1];
        String suffix = s.substring(palindromeLength);

        return new StringBuilder(suffix).reverse().toString() + s;
    }

    private int[] computeKMPTable(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int length = 0;
        for (int i = 1; i < n; i++) {
            while (length > 0 && s.charAt(i) != s.charAt(length)) {
                length = lps[length - 1];
            }

            if (s.charAt(i) == s.charAt(length)) {
                length++;
            }
            lps[i] = length;
        }

        return lps;
    }

    public static void main(String[] args) {
        ShortestPalindrome solution = new ShortestPalindrome();
        String s1 = "aacecaaa";
        System.out.println(solution.shortestPalindrome(s1)); // Output: "aaacecaaa"

        // Test case 2
        String s2 = "abcd";
        System.out.println(solution.shortestPalindrome(s2)); // Output: "dcbabcd"

        // Test case 3
        String s3 = "racecar";
        System.out.println(solution.shortestPalindrome(s3)); // Output: "racecar" (already a palindrome)
    }
}
