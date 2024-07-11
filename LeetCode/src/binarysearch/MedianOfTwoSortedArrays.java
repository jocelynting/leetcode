package binarysearch;

public class MedianOfTwoSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArraysByBinarySearch(nums1, nums2);
//        return findMedianSortedArraysByMergeSort(nums1, nums2);
    }

    public double findMedianSortedArraysByBinarySearch(int[] nums1, int[] nums2) {
        // 保证nums1是较短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m, half = (m + n + 1) / 2;

        while (left <= right) {
            int part1 = (left + right) / 2;
            int part2 = half - part1;

            int part1left = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            int part1right = (part1 == m) ? Integer.MAX_VALUE : nums1[part1];
            int part2left = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            int part2right = (part2 == n) ? Integer.MAX_VALUE : nums2[part2];

            if (part1left <= part2right && part2left <= part1right) {
                if ((m + n) % 2 == 0) {
                    return ((Math.max(part1left, part2left) +
                            Math.min(part1right, part2right)) /
                            2.0);
                } else {
                    return Math.max(part1left, part2left);
                }
            } else if (part1left > part2right) {
                right = part1 - 1;
            } else {
                left = part1 + 1;
            }

        }

        return 0.0;
    }

    private int p1 = 0;
    private int p2 = 0;

    public double findMedianSortedArraysByMergeSort(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;

        if (length % 2 == 0) {
            for (int i = 0; i < length / 2 - 1; i++) {
                moveKthElement(nums1, nums2);
            }
            return (moveKthElement(nums1, nums2) + moveKthElement(nums1, nums2)) / 2.0;
        } else {
            for (int i = 0; i < length / 2; i++) {
                moveKthElement(nums1, nums2);
            }
            return moveKthElement(nums1, nums2);
        }
    }

    private int moveKthElement(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                return nums1[p1++];
            } else {
                return nums2[p2++];
            }
        } else if (p1 < nums1.length) {
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            return nums2[p2++];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Output: 2.0
    }
}
