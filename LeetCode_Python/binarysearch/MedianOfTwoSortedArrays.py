class MedianOfTwoSortedArrays:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        n1, n2 = len(nums1), len(nums2)
        left, right = 0, n1

        while left <= right:
            p1 = (left + right) // 2
            p2 = (n1 + n2 + 1) // 2 - p1

            p1_left = nums1[p1 - 1] if p1 > 0 else float("-inf")
            p1_right = nums1[p1] if p1 < n1 else float("inf")
            p2_left = nums2[p2 - 1] if p2 > 0 else float("-inf")
            p2_right = nums2[p2] if p2 < n2 else float("inf")

            if p1_left <= p2_right and p2_left <= p1_right:
                if (n1 + n2) % 2 == 0:
                    return (max(p1_left, p2_left) + min(p1_right, p2_right)) / 2
                else:
                    return max(p1_left, p2_left)
            elif p1_left > p2_right:
                right = p1 - 1
            else:
                left = p1 + 1

        return 0.0


# Time Complexity: O(log(min(n1, n2))), where n1 and n2 are the lengths of the two input arrays.
# This is because we are performing a binary search on the smaller array.
# The binary search will take at most log(min(n1, n2)) iterations.
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = MedianOfTwoSortedArrays()

    print("Expected Output: 2.0")
    print("Actual Output:", solution.findMedianSortedArrays([1, 3], [2]))

    print("Expected Output: 2.5")
    print("Actual Output:", solution.findMedianSortedArrays([1, 2], [3, 4]))
