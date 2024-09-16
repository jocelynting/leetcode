package array;

public class CountNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] count = new int[26];
        for (char ch : allowed.toCharArray()) {
            count[ch - 'a']++;
        }

        int result = 0;
        for (String word : words) {
            boolean match = true;
            for (char ch : word.toCharArray()) {
                if (count[ch - 'a'] == 0) {
                    match = false;
                    continue;
                }
            }

            result += match ? 1 : 0;
        }

        return result;
    }

    public static void main(String[] args) {
        CountNumberOfConsistentStrings solution = new CountNumberOfConsistentStrings();
        String allowed1 = "ab";
        String[] words1 = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println(solution.countConsistentStrings(allowed1, words1));  // Output: 2

        String allowed2 = "abc";
        String[] words2 = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        System.out.println(solution.countConsistentStrings(allowed2, words2));  // Output: 7
    }
}
