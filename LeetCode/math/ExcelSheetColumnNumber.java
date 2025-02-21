package math;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (char ch : columnTitle.toCharArray()) {
            result *= 26;
            result += ch - 'A' + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber solution = new ExcelSheetColumnNumber();
        System.out.println(solution.titleToNumber("A"));// Output: 1
        System.out.println(solution.titleToNumber("AB"));// Output: 28
        System.out.println(solution.titleToNumber("ZY"));// Output: 701
    }
}
