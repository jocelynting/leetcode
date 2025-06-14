class MedianOfTwoSortedArrays:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        m, n = len(nums1), len(nums2)
        left, right = 0, m

        while left <= right:
            i = (left + right) // 2
            j = (m + n + 1) // 2 - i

            nums1_left_max = float("-inf") if i == 0 else nums1[i - 1]
            nums1_right_min = float("inf") if i == m else nums1[i]
            nums2_left_max = float("-inf") if j == 0 else nums2[j - 1]
            nums2_right_min = float("inf") if j == n else nums2[j]

            if nums1_left_max <= nums2_right_min and nums2_left_max <= nums1_right_min:
                if (m + n) % 2 == 0:
                    return (
                        max(nums1_left_max, nums2_left_max)
                        + min(nums1_right_min, nums2_right_min)
                    ) / 2
                else:
                    return max(nums1_left_max, nums2_left_max)
            elif nums1_left_max > nums2_right_min:
                right = i - 1
            else:
                left = i + 1

        return 0


# Time Complexity: O(log(min(n1, n2))), where n1 and n2 are the lengths of the two input arrays.
# This is because we are performing a binary search on the smaller array.
# The binary search will take at most log(min(n1, n2)) iterations.
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = MedianOfTwoSortedArrays()

    print("Expected Output: 2")
    print("Actual Output:", solution.findMedianSortedArrays([1, 3], [2]))

    print("Expected Output: 2.5")
    print("Actual Output:", solution.findMedianSortedArrays([1, 2], [3, 4]))
