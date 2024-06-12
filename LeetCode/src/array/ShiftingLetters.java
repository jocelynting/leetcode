package array;

public class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        int[] shiftTotal = new int[n];

        shiftTotal[n - 1] = shifts[n - 1] % 26;
        for (int i = n - 2; i >= 0 ; i--) {
            shiftTotal[i] = (shiftTotal[i + 1] + shifts[i]) % 26;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = (ch - 'a' + shiftTotal[i]) % 26;
            sb.append((char) ('a' + count));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ShiftingLetters solution = new ShiftingLetters();

        String S1 = "abc";
        int[] shifts1 = {3, 5, 9};
        System.out.println(solution.shiftingLetters(S1, shifts1)); // Output: "rpl"

        String S2 = "aaa";
        int[] shifts2 = {1, 2, 3};
        System.out.println(solution.shiftingLetters(S2, shifts2)); // Output: "gfd"

        String S3 = "mkgfzkkuxownxvfvxasy";
        int[] shifts3 = {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
        System.out.println(solution.shiftingLetters(S3, shifts3)); // Output: "wqqwlcjnkphhsyvrkdod"
    }
}
