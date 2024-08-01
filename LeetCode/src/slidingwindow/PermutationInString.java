package slidingwindow;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length(), length2 = s2.length();
        if (length1 > length2) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < length1; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            count1[ch1 - 'a']++;
            count2[ch2 - 'a']++;
        }

        if (Arrays.equals(count1, count2)) {
            return true;
        }

        for (int i = length1; i < length2; i++) {
            char cur = s2.charAt(i);
            count2[cur - 'a']++;
            char pre = s2.charAt(i - length1);
            count2[pre - 'a']--;

            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();
        System.out.println(solution.checkInclusion("ab", "eidbaooo")); // true
        System.out.println(solution.checkInclusion("ab", "eidboaoo")); // false
    }
}
