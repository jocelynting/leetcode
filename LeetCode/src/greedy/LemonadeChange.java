package greedy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
            } else {
                if (ten > 0) {
                    ten--;
                } else {
                    five -= 2;
                }
                five--;
            }

            if (five < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LemonadeChange solution = new LemonadeChange();
        int[] bills1 = {5, 5, 5, 10, 20};
        System.out.println(solution.lemonadeChange(bills1));// Output: true

        int[] bills2 = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        System.out.println(solution.lemonadeChange(bills2));// Output: true

        int[] bills3 = {5, 5, 5, 10, 5, 5, 10, 20, 20, 20};
        System.out.println(solution.lemonadeChange(bills3));// Output: false
    }
}
