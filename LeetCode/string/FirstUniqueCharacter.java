package string;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter solution = new FirstUniqueCharacter();
        System.out.println(solution.firstUniqChar("leetcode"));// Output: 0
        System.out.println(solution.firstUniqChar("loveleetcode"));// Output: 2
        System.out.println(solution.firstUniqChar("aabb"));// Output: -1
    }
}
