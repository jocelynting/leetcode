package twopoint;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            int h = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, h * (r - l));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Test case
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum area: " + solution.maxArea(heights)); // Output: 49
    }
}
