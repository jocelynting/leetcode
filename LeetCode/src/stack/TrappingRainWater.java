package stack;

import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int rightIndex = stack.pop();
                if (stack.isEmpty()) break; // has left index
                int distance = i - stack.peek() - 1; // stack.peek() is the left index
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[rightIndex];
                water += distance * boundedHeight;
            }
            stack.push(i);
        }

        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Test case
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Amount of trapped rainwater: " + solution.trap(heights)); // Output: 6
    }
}

