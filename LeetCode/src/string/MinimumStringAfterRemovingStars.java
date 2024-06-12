package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumStringAfterRemovingStars {
    public String clearStars(String s) {
        char[] letters = s.toCharArray();
        int n = letters.length;

        List<Integer>[] letterList = new ArrayList[26];
        Arrays.setAll(letterList, i -> new ArrayList<>());

        for (int i = 0; i < n; i++) {
            char ch = letters[i];
            if (ch != '*') {
                letterList[ch - 'a'].add(i);
                continue;
            }

            for (List<Integer> list: letterList) {
                if (!list.isEmpty()) {
                    int index = list.remove(list.size() - 1);
                    letters[index] = '*';
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char l: letters) {
            if (l != '*') {
                sb.append(l);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MinimumStringAfterRemovingStars solution = new MinimumStringAfterRemovingStars();
        String s1 = "aaba*";
        System.out.println(solution.clearStars(s1));// Output: "aab"
        String s2 = "de*";
        System.out.println(solution.clearStars(s2));// Output: "abc"
    }
}
