package math;

public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {

        int count = numBottles;
        int result = numBottles;

        while (count >= numExchange) {
            result += count / numExchange;
            count = count / numExchange + count % numExchange;
        }

        return result;
    }

    public static void main(String[] args) {
        WaterBottles solution = new WaterBottles();

        int numBottles1 = 9;
        int numExchange1 = 3;
        System.out.println(solution.numWaterBottles(numBottles1, numExchange1)); // Expected output: 13

        int numBottles2 = 15;
        int numExchange2 = 4;
        System.out.println(solution.numWaterBottles(numBottles2, numExchange2)); // Expected output: 19

        int numBottles3 = 5;
        int numExchange3 = 5;
        System.out.println(solution.numWaterBottles(numBottles3, numExchange3)); // Expected output: 6
    }
}
