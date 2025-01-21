package twopoint;

public class StringCompression {
    public int compress(char[] chars) {
        int n = chars.length;
        int read = 0, write = 0;

        while (read < n) {
            char ch = chars[read];
            int count = 0;

            while (read < n && chars[read] == ch) {
                count++;
                read++;
            }

            chars[write++] = ch;

            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }

    public static void main(String[] args) {
        StringCompression solution = new StringCompression();
        char[] chars1 = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(solution.compress(chars1)); // Output: 6

        char[] chars2 = new char[]{'a'};
        System.out.println(solution.compress(chars2)); // Output: 1

        char[] chars3 = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(solution.compress(chars3)); // Output: 4
    }
}
