class IntersectionOfTwoArrays:
    def intersection(self, nums1: list[int], nums2: list[int]) -> list[int]:
        set1 = set(nums1)
        set2 = set(nums2)
        return list(set2 & set1)


if __name__ == "__main__":
    solution = IntersectionOfTwoArrays()

    print("Expected Output : [2]")
    print("Actual Output : ", solution.intersection([1, 2, 2, 1], [2, 2]))

    print("Expected Output : [9,4]")
    print("Actual Output : ", solution.intersection([4, 9, 5], [9, 4, 9, 8, 4]))
