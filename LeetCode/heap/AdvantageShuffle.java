package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffle {

    public int[] advantageCount(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int[] result = new int[n];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);

        int left = 0, right = n - 1;
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            int index = cur[0], value = cur[1];

            if (nums1[right] > value) {
                result[index] = nums1[right];
                right--;
            } else {
                result[index] = nums1[left];
                left++;
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
