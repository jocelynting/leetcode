class FindDifferenceOfTwoArrays:
    def findTheDifference(self, nums1: list[int], nums2: list[int]) -> list[list[int]]:
        set1 = set(nums1)
        set2 = set(nums2)
        return [list(set1 - set2), list(set2 - set1)]


# Time Complexity: O(m + n), where m is the length of nums1 and n is the length of nums2
# The time complexity is O(m + n) because we are iterating through both arrays once to create sets.
# Space Complexity: O(m + n), where m is the length of nums1 and n is the length of nums2
# The space complexity is O(m + n) because we are storing the elements of both arrays in sets.

if __name__ == "__main__":
    solution = FindDifferenceOfTwoArrays()

    nums1 = [1, 2, 3]
    nums2 = [2, 4, 6]
    print("Expected Output: [[1, 3], [4, 6]]")
    print("Actual Output:", solution.findTheDifference(nums1, nums2))

    nums1 = [1, 2, 3, 3]
    nums2 = [1, 1, 2, 2]
    print("Expected Output: [[3], []]")
    print("Actual Output:", solution.findTheDifference(nums1, nums2))
