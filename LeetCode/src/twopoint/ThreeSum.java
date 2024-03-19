package twopoint;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = -nums[i];
                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {
                    if (nums[l] + nums[r] < target){
                        l++;
                    } else if (nums[l] + nums[r] > target){
                        r--;
                    } else {
                        result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // Test case
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println("Unique triplets: " + result); // Output: [[-1,-1,2],[-1,0,1]]
    }
}
