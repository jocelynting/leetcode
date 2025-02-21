package string;

public class StringCompressionIII {
    public String compressedString(String word) {

        StringBuilder comp = new StringBuilder();
        int i = 0;
        int n = word.length();

        while (i < n) {
            char c = word.charAt(i);
            int count = 0;

            while (i < n && word.charAt(i) == c && count < 9) {
                i++;
                count++;
            }

            comp.append(count).append(c);
        }

        return comp.toString();

    }

    public static void main(String[] args) {
        StringCompressionIII solution = new StringCompressionIII();
        String word1 = "abcde";
        String word2 = "aaaaaaaaaaaaaabb";
        System.out.println(solution.compressedString(word1));// Output: "1a1b1c1d1e"
        System.out.println(solution.compressedString(word2));// Output: "9a5a2b"
    }
}
