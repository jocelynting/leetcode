package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> stack = new Stack<>(); // index height
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] popped = stack.pop();
                int width = i - popped[0];
                int height = popped[1];
                maxArea = Math.max(maxArea, width * height);
                start = popped[0];
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] bar : stack) {
            int width = n - bar[0];
            int height = bar[1];
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        // Test case
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = solution.largestRectangleArea(heights);
        System.out.println("Largest rectangle area: " + result);  // Output: 10
    }

    /*
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;

    }
    */

    /*
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0; // Base Condition
        int maxArea = 0;
        int left[] = new int[n]; //fill left boundary
        int right[] = new int[n]; // fill right boundary

        left[0] = -1;
        right[n - 1] = n;

        for(int i = 1; i < n; i++){
            int prev = i - 1; // previous for comparing the heights
            while(prev >= 0 && heights[prev] >= heights[i]){
                prev = left[prev]; // we have done this to minimise the jumps we make to the left
            }
            left[i] = prev;
        }
        // Similarly we do for right
        for(int i = n - 2; i >= 0; i--){
            int prev = i + 1;
            while(prev < n && heights[prev] >= heights[i]){
                prev = right[prev];
            }
            right[i] = prev;
        }
        // once we have these two arrays fill we need width & area
        for(int i = 0; i < n; i++){
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;

    }
    */
}
