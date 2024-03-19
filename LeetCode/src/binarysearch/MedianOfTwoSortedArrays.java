package binarysearch;

public class MedianOfTwoSortedArrays {

    private int p1 = 0;
    private int p2 = 0;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;

        if (length % 2 == 0){
            for (int i = 0; i < length / 2 - 1; i++) {
                moveKthElement(nums1,nums2);
            }
            return (moveKthElement(nums1,nums2) + moveKthElement(nums1,nums2)) / 2.0;
        } else {
            for (int i = 0; i < length / 2; i++) {
                moveKthElement(nums1,nums2);
            }
            return moveKthElement(nums1,nums2);
        }
    }

    private int moveKthElement(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length){
            if (nums1[p1] < nums2[p2]){
                return nums1[p1++];
            } else {
                return nums2[p2++];
            }
        } else if (p1 < nums1.length){
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
