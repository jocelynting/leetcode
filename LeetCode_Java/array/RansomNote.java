package array;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char c: magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c: ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false;
            }
            count[c - 'a']--;
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
