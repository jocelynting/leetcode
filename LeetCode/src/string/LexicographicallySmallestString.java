package string;

public class LexicographicallySmallestString {
    public String getSmallestString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < n - 1; i++) {
            int x = chars[i] - '0';
            int y = chars[i + 1] - '0';
            if (x % 2 == y % 2 && x > y) {
                char temp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = temp;
                break;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        LexicographicallySmallestString solution = new LexicographicallySmallestString();
        System.out.println(solution.getSmallestString("45320"));// Output: "43520"
        System.out.println(solution.getSmallestString("001"));// Output: "001"
    }
}
