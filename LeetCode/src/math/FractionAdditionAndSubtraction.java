package math;

public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;
        int n = expression.length();
        int index = 0;

        while (index < n) {
            int sign = 1;
            if (expression.charAt(index) == '+' || expression.charAt(index) == '-') {
                sign = expression.charAt(index) == '+' ? 1 : -1;
                index++;
            }

            int num = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                num = num * 10 + (expression.charAt(index) - '0');
                index++;
            }

            num *= sign;
            index++;

            int denom = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                denom = denom * 10 + (expression.charAt(index) - '0');
                index++;
            }

            numerator = numerator * denom + num * denominator;
            denominator *= denom;

            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        FractionAdditionAndSubtraction solution = new FractionAdditionAndSubtraction();
        System.out.println(solution.fractionAddition("-1/2+1/2")); // Output: "0/1"
        System.out.println(solution.fractionAddition("-1/2+1/2+1/3")); // Output: "1/3"
        System.out.println(solution.fractionAddition("1/3-1/2")); // Output: "-1/6"
        System.out.println(solution.fractionAddition("5/3+1/3")); // Output: "2/1"
    }
}
