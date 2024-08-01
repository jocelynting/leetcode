package greedy;

import java.util.Arrays;

public class AdvantageShuffle {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);

        int n = nums1.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i, j) -> nums2[i] - nums2[j]);

        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int num : nums1) {
            if (num > nums2[index[left]]) {
                result[index[left]] = num;
                left++;
            } else {
                result[index[right]] = num;
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        AdvantageShuffle solution = new AdvantageShuffle();

        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {1, 10, 4, 11};
        System.out.println(Arrays.toString(solution.advantageCount(nums1, nums2)));// Output: [2,11,7,15]

        int[] nums3 = {12, 24, 8, 32};
        int[] nums4 = {13, 25, 32, 11};
        System.out.println(Arrays.toString(solution.advantageCount(nums3, nums4)));// Output: [24,32,8,12]
    }
}
