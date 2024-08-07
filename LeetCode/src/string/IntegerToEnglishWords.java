package string;

public class IntegerToEnglishWords {

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        return helper(num);
    }

    private String helper(int num) {
        StringBuilder result = new StringBuilder();

        if (num < 20) {
            result.append(LESS_THAN_20[num]);
        } else if (num < 100) {
            result.append(TENS[num / 10]).append(" ").append(LESS_THAN_20[num % 10]);
        } else if (num < 1000) {
            result.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num < 1000000) {
            result.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num < 1000000000) {
            result.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else {
            result.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        IntegerToEnglishWords solution = new IntegerToEnglishWords();
        int num1 = 123;
        int num2 = 12345;
        int num3 = 1234567;
        System.out.println(solution.numberToWords(num1)); // Output: "One Hundred Twenty Three"
        System.out.println(solution.numberToWords(num2)); // Output: "Twelve Thousand Three Hundred Forty Five"
        System.out.println(solution.numberToWords(num3)); // Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    }
}
