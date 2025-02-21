package greedy;

import java.util.Arrays;

public class MinimumNumberPushesToTypeWordII {
    public int minimumPushes(String word) {
        int[] count = new int[26];

        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }

        Arrays.sort(count);

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += count[26 - i - 1] * (i / 8 + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumNumberPushesToTypeWordII solution = new MinimumNumberPushesToTypeWordII();
        System.out.println(solution.minimumPushes("abcde"));// Output: 5
        System.out.println(solution.minimumPushes("xyzxyzxyzxyz"));// Output: 12
        System.out.println(solution.minimumPushes("aabbccddeeffgghhiiiiii"));// Output: 24
    }
}
