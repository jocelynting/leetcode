package string;

public class SumDigitsStringAfterConvert {
    public int getLucky(String s, int k) {

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += String.valueOf(s.charAt(i) - 'a' + 1);
        }

        while (k > 0) {
            int sum = 0;
            for (char ch : result.toCharArray()) {
                sum += (ch - '0');
            }
            k--;
            result = String.valueOf(sum);
        }

        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        SumDigitsStringAfterConvert solution = new SumDigitsStringAfterConvert();
        System.out.println(solution.getLucky("iiii", 1));// Output: 36
        System.out.println(solution.getLucky("leetcode", 2));// Output: 6
        System.out.println(solution.getLucky("zbax", 2));// Output: 8
    }
}
