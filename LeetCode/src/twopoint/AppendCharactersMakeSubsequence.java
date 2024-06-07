package twopoint;

public class AppendCharactersMakeSubsequence {

    public int appendCharacters(String s, String t) {
        int index = 0, prefix = 0;

        while (index < s.length() && prefix < t.length()) {
            if (s.charAt(index) == t.charAt(prefix)) {
                prefix++;
            }
            index++;
        }

        return t.length() - prefix;
    }

    public static void main(String[] args) {
        AppendCharactersMakeSubsequence solution = new AppendCharactersMakeSubsequence();

        String s1 = "coaching";
        String t1 = "coding";
        System.out.println(solution.appendCharacters(s1, t1));// Output: 4

        String s2 = "z";
        String t2 = "abcde";
        System.out.println(solution.appendCharacters(s2, t2));// Output: 5
    }
}
