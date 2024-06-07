package array;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            minFreq[i] = Integer.MAX_VALUE;
        }

        for (String s : words) {
            int[] charCount = new int[26];
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charCount[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindCommonCharacters solution = new FindCommonCharacters();

        String[] A1 = {"bella", "label", "roller"};
        System.out.println(solution.commonChars(A1)); // Output: [e, l, l]

        String[] A2 = {"cool", "lock", "cook"};
        System.out.println(solution.commonChars(A2)); // Output: [c, o]
    }
}

