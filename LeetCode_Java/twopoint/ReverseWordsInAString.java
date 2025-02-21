package twopoint;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int right = s.length() - 1;

        while (right >= 0) {
            while (right >= 0 && s.charAt(right) == ' ') {
                right--;
            }
            if (right < 0) break;

            int left = right;
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }

            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(s.substring(left + 1, right + 1));

            right = left - 1;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString solution = new ReverseWordsInAString();
        System.out.println(solution.reverseWords("the sky is blue")); // blue is sky the
        System.out.println(solution.reverseWords("  hello world  ")); // world hello
        System.out.println(solution.reverseWords("a good   example")); // example good a
    }
}
