package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtracking(0, result, new ArrayList<>(), s);
        return result;
    }

    private void backtracking(int start, List<List<String>> result, List<String> cur, String s) {
        if (start == s.length()) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                cur.add(s.substring(start, i + 1));
                backtracking(i + 1, result, cur, s);
                cur.remove(cur.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s, int left, int right) {
        if (s.length() == 1) {
            return true;
        }

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        String s1 = "aab";
        String s2 = "a";
        System.out.println(solution.partition(s1));// Output: [["a","a","b"],["aa","b"]]
        System.out.println(solution.partition(s2));// Output: [["a"]]
    }
}
