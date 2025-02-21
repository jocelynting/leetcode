package array;

import java.util.Arrays;

public class DetermineTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char ch : word1.toCharArray()) {
            count1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            count2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((count1[i] == 0 && count2[i] > 0) || (count1[i] > 0 && count2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }

    public static void main(String[] args) {
        DetermineTwoStringsAreClose solution = new DetermineTwoStringsAreClose();
        String word1_1 = "abc";
        String word2_1 = "bca";
        System.out.println(solution.closeStrings(word1_1, word2_1)); // Output: true

        String word1_2 = "a";
        String word2_2 = "aa";
        System.out.println(solution.closeStrings(word1_2, word2_2)); // Output: false

        String word1_3 = "cabbba";
        String word2_3 = "abbccc";
        System.out.println(solution.closeStrings(word1_3, word2_3)); // Output: true
    }
}
