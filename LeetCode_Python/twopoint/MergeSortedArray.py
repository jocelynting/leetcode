class MergeSortedArray:
    def merge(self, nums1: list[int], m: int, nums2: list[int], n: int) -> None:
        n1, n2 = m - 1, n - 1
        i = m + n - 1

        while n1 >= 0 and n2 >= 0:
            if nums1[n1] > nums2[n2]:
                nums1[i] = nums1[n1]
                n1 -= 1
            else:
                nums1[i] = nums2[n2]
                n2 -= 1
            i -= 1

        while n2 >= 0:
            nums1[i] = nums2[n2]
            n2 -= 1
            i -= 1


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = MergeSortedArray()

    nums1 = [1, 2, 3, 0, 0, 0]
    m = 3
    nums2 = [2, 5, 6]
    n = 3
    solution.merge(nums1, m, nums2, n)
    print("Expected Output: [1, 2, 2, 3, 5, 6]")
    print("Actual Output:", nums1)

    nums1 = [1]
    m = 1
    nums2 = []
    n = 0
    solution.merge(nums1, m, nums2, n)
    print("Expected Output: [1]")
    print("Actual Output:", nums1)

    nums1 = [0]
    m = 0
    nums2 = [1]
    n = 1
    solution.merge(nums1, m, nums2, n)
    print("Expected Output: [1]")
    print("Actual Output:", nums1)
