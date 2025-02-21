package string;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean down = false;

        for (char ch : s.toCharArray()) {
            rows[row].append(ch);
            if (row == 0 || row == numRows - 1) {
                down = !down;
            }
            row += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion solution = new ZigzagConversion();
        String result1 = solution.convert("PAYPALISHIRING", 3);
        System.out.println(result1);  // Output: "PAHNAPLSIIGYIR"

        String result2 = solution.convert("PAYPALISHIRING", 4);
        System.out.println(result2);  // Output: "PINALSIGYAHRPI"
    }
}
