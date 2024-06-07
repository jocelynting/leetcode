package stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (char ch: s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                stringStack.push(sb.toString());
                count = 0;
                sb = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder decode = new StringBuilder(stringStack.pop());
                int curCount = countStack.pop();
                for (int i = 0; i < curCount ; i++) {
                    decode.append(sb);
                }
                sb = decode;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();

        String s1 = "3[a]2[bc]";
        String result1 = solution.decodeString(s1);
        System.out.println("Test Case 1: " + result1); // Output: aaabcbc

        String s2 = "3[a2[c]]";
        String result2 = solution.decodeString(s2);
        System.out.println("Test Case 2: " + result2); // Output: accaccacc

        String s3 = "2[abc]3[cd]ef";
        String result3 = solution.decodeString(s3);
        System.out.println("Test Case 3: " + result3); // Output: abcabccdcdcdef
    }
}
