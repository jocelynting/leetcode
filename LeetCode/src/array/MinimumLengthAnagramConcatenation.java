package array;

import java.util.Arrays;

public class MinimumLengthAnagramConcatenation {
    public int minAnagramLength(String s) {
        int n = s.length();

        for (int i = 1; i <= n / 2 + 1; i++) {
            if (n % i == 0) {
                if (isFactor(s, i)) {
                    return i;
                }
            }
        }

        return n;
    }

    private boolean isFactor(String s, int length) {

        int[] first = new int[26];
        for (int i = 0; i < length; i++) {
            first[s.charAt(i) - 'a']++;
        }

        for (int i = length; i < s.length(); i+=length) {
            int[] occurrence = new int[26];
            for (int j = i; j < i + length; j++) {
                occurrence[s.charAt(j) - 'a']++;
            }

            if (Arrays.compare(first, occurrence) != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MinimumLengthAnagramConcatenation solution = new MinimumLengthAnagramConcatenation();
        String word1 = "abba";
        String word2 = "cdef";
        String word3 = "aabb";
        String word4 = "xxe";
        String word5 = "jjj";

        System.out.println(solution.minAnagramLength(word1)); // Output: 2
        System.out.println(solution.minAnagramLength(word2)); // Output: 4
        System.out.println(solution.minAnagramLength(word3)); // Output: 4
        System.out.println(solution.minAnagramLength(word4)); // Output: 3
        System.out.println(solution.minAnagramLength(word5)); // Output: 1
    }
}
