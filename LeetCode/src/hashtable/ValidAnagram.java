package hashtable;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        Map<Character,Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) - 1);
        }

        for (int value: map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        // Test cases
        String s1 = "anagram", t1 = "nagaram";
        String s2 = "rat", t2 = "car";
        String s3 = "aacc", t3 = "ccac";

        System.out.println("Is \"" + s1 + "\" an anagram of \"" + t1 + "\"? " + solution.isAnagram(s1, t1)); // Output: true
        System.out.println("Is \"" + s2 + "\" an anagram of \"" + t2 + "\"? " + solution.isAnagram(s2, t2)); // Output: false
        System.out.println("Is \"" + s3 + "\" an anagram of \"" + t3 + "\"? " + solution.isAnagram(s3, t3)); // Output: false
    }

}
