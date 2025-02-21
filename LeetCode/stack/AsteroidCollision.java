package stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            boolean explode = false;
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                int cur = stack.peek();
                if (cur < -a) {
                    stack.pop();
                } else if (cur == -a) {
                    stack.pop();
                    explode = true;
                    break;
                } else {
                    explode = true;
                    break;
                }
            }

            if (!explode) {
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision solution = new AsteroidCollision();
        int[] asteroids1 = {5, 10, -5};
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids1))); // Output: [5, 10]

        int[] asteroids2 = {8, -8};
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids2))); // Output: []

        int[] asteroids3 = {10, 2, -5};
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids3))); // Output: [10]
    }
}
