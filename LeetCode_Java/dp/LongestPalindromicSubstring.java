package dp;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == s.charAt(i) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLength) {
                        start = i;
                        maxLength = j - i + 1;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s)); // Output: "bab" or "aba"
    }

//    public String longestPalindrome(String s) {
//        if (s.length() <= 1) {
//            return s;
//        }
//
//        int n = s.length();
//        boolean[][] dp = new boolean[n][n];
//
//        int start = 0, end = 0;
//        int maxLength = 0;
//
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = true;
//            start = i;
//            end = i;
//            maxLength = 1;
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            if (s.charAt(i) == s.charAt(i + 1)) {
//                dp[i][i + 1] = true;
//                start = i;
//                end = i + 1;
//                maxLength = 2;
//            }
//        }
//
//        for (int diff = 2; diff < n; diff++) {
//            for (int i = 0; i < n - diff; i++) {
//                int j = i + diff;
//                if (s.charAt(j) == s.charAt(i) && dp[i + 1][j - 1]) {
//                    dp[i][j] = true;
//
//                    if (j - i + 1 > maxLength) {
//                        start = i;
//                        end = j;
//                        maxLength = j - i + 1;
//                    }
//                }
//            }
//        }
//
//        return s.substring(start, end + 1);
//    }

}
