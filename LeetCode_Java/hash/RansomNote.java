package hash;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c: magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c: ransomNote.toCharArray()) {
            if (map.get(c) == null) {
                return false;
            }
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote solution = new RansomNote();

        // Test case
        String ransomNote1 = "aabb";
        String magazine1 = "abbaaab";

        String ransomNote2 = "aa";
        String magazine2 = "ab";

        String ransomNote3 = "ac";
        String magazine3 = "ab";

        System.out.println("Can ransom note be constructed? " + solution.canConstruct(ransomNote1, magazine1));// true
        System.out.println("Can ransom note be constructed? " + solution.canConstruct(ransomNote2, magazine2));// false
        System.out.println("Can ransom note be constructed? " + solution.canConstruct(ransomNote3, magazine3));// false

    }
}
