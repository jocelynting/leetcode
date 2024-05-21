package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramInString {

    public List<Integer> findAnagrams(String s, String p) {

        int sn = s.length();
        int pn = p.length();

        List<Integer> result = new ArrayList<>();

        if (sn < pn) {
            return  result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char ch: p.toCharArray()) {
            pCount[ch - 'a']++;
        }

        int left = 0, right = 0;

        while (right < sn) {
            char r = s.charAt(right);
            sCount[r - 'a']++;

            if (right - left + 1 == pn) {
                if (Arrays.equals(pCount, sCount)) {
                    result.add(left);
                }

                char l = s.charAt(left);
                sCount[l - 'a']--;
                left++;
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramInString solution = new FindAllAnagramInString();
        String s1 = "cbaebabacd";
        String p1 = "abc";

        String s2 = "abab";
        String p2 = "ab";

        System.out.println(solution.findAnagrams(s1, p1));// Output: [0,6]
        System.out.println(solution.findAnagrams(s2, p2));// Output: [0,1,2]
    }
}
