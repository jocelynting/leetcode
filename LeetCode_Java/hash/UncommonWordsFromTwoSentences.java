package hash;

import java.util.*;

public class UncommonWordsFromTwoSentences {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();

        String[] sen1 = s1.split(" ");
        String[] sen2 = s2.split(" ");

        for (String s : sen1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : sen2) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                result.add(s);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        UncommonWordsFromTwoSentences solution = new UncommonWordsFromTwoSentences();
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(solution.uncommonFromSentences(s1, s2)));
        // Output: ["sweet", "sour"]

        String s3 = "apple apple";
        String s4 = "banana";
        System.out.println(Arrays.toString(solution.uncommonFromSentences(s3, s4)));
        // Output: ["banana"]
    }
}
