package bit;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubstringContainingVowelsEven {

    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int bitmask = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a') {
                bitmask ^= (1 << 0);
            } else if (ch == 'e') {
                bitmask ^= (1 << 1);
            } else if (ch == 'i') {
                bitmask ^= (1 << 2);
            } else if (ch == 'o') {
                bitmask ^= (1 << 3);
            } else if (ch == 'u') {
                bitmask ^= (1 << 4);
            }

            if (map.containsKey(bitmask)) {
                int index = map.get(bitmask);
                maxLength = Math.max(maxLength, i - index);
            } else {
                map.put(bitmask, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        FindLongestSubstringContainingVowelsEven solution = new FindLongestSubstringContainingVowelsEven();
        String s1 = "eleetminicoworoep";
        System.out.println(solution.findTheLongestSubstring(s1)); // Output: 13

        String s2 = "leetcodeisgreat";
        System.out.println(solution.findTheLongestSubstring(s2)); // Output: 5

        String s3 = "bcbcbc";
        System.out.println(solution.findTheLongestSubstring(s3)); // Output: 6
    }
}
