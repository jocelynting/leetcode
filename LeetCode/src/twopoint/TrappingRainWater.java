package twopoint;

public class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxHeightLeft = 0, maxHeightRight = 0;
        int water = 0;

        while (l < r) {
            if (height[l] <= height[r]) {
                maxHeightLeft = Math.max(maxHeightLeft, height[l]);
                water += maxHeightLeft - height[l];
                l++;
            } else {
                maxHeightRight = Math.max(maxHeightRight,height[r]);
                water += maxHeightRight - height[r];
                r--;
            }
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
