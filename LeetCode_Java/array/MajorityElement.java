package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];

//        Map<Integer,Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
//        }
//
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > nums.length / 2) {
//                return entry.getKey();
//            }
//        }
//
//        return 0;

        int major = 0;
        int count = 0;

        for (int n: nums) {
            if (count == 0) {
                major = n;
            }

            if (n == major) {
                count++;
            } else {
                count--;
            }
        }

        return major;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();

        // Test case
        int[] nums = {3, 2, 3};

        System.out.println("Majority Element: " + solution.majorityElement(nums)); // Output: 3
    }
}
