package hash;

public class IntegerToRoman {

    public String intToRoman(int num) {
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(romanSymbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();

        System.out.println(solution.intToRoman(3));    // Output: "III"
        System.out.println(solution.intToRoman(4));    // Output: "IV"
        System.out.println(solution.intToRoman(9));    // Output: "IX"
        System.out.println(solution.intToRoman(58));   // Output: "LVIII"
        System.out.println(solution.intToRoman(1994)); // Output: "MCMXCIV"
    }
}

