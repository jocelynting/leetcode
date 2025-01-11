package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int m1 = 0, m2 = 0;
        int c1 = 0, c2 = 0;

        for (int n : nums) {
            if (n == m1) {
                c1++;
            } else if (n == m2) {
                c2++;
            } else if (c1 == 0) {
                m1 = n;
                c1 = 1;
            } else if (c2 == 0) {
                m2 = n;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;

        for (int n : nums) {
            if (n == m1) {
                c1++;
            } else if (n == m2) {
                c2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (c1 > nums.length / 3) {
            result.add(m1);
        }

        if (c2 > nums.length / 3) {
            result.add(m2);
        }

        return result;
    }

    public static void main(String[] args) {
        MajorityElementII solution = new MajorityElementII();
        int[] nums1 = {3, 2, 3};
        System.out.println(solution.majorityElement(nums1)); // Output: [3]
        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(solution.majorityElement(nums2)); // Output: [1, 2]
    }
}
