package stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        Stack<Double> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty() || cars[i][1] > stack.peek()) {
                stack.push(cars[i][1]);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        CarFleet solution = new CarFleet();
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(solution.carFleet(target, position, speed)); // Output: 3
    }
}
