package string;

public class StringToInteger {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int index = 0;
        int sign = 1;
        int result = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int num = s.charAt(index) - '0';

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + num;
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        StringToInteger solution = new StringToInteger();

        // Test cases
        String s1 = "42";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";

        System.out.println("String: \"" + s1 + "\", Integer: " + solution.myAtoi(s1)); // Output: 42
        System.out.println("String: \"" + s2 + "\", Integer: " + solution.myAtoi(s2)); // Output: -42
        System.out.println("String: \"" + s3 + "\", Integer: " + solution.myAtoi(s3)); // Output: 4193
        System.out.println("String: \"" + s4 + "\", Integer: " + solution.myAtoi(s4)); // Output: 0
        System.out.println("String: \"" + s5 + "\", Integer: " + solution.myAtoi(s5)); // Output: -2147483648
    }
}
