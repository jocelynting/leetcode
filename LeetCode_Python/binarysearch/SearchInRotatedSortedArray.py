class SearchInRotatedSortedArray:
    def search(self, nums: list[int], target: int) -> int:
        n = len(nums)
        left, right = 0, n - 1

        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[n - 1]:
                left = mid + 1
            else:
                right = mid

        def binarySearch(left: int, right: int) -> int:
            while left < right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid + 1
                elif nums[mid] > target:
                    right = mid
                else:
                    return mid
            return -1

        res = binarySearch(0, left)

        return res if res != -1 else binarySearch(left, n)


if __name__ == "__main__":
    solution = SearchInRotatedSortedArray()

    print("Expected Output : 4")
    print("Actual Output :", solution.search([4, 5, 6, 7, 0, 1, 2], 0))

    print("Expected Output : -1")
    print("Actual Output :", solution.search([4, 5, 6, 7, 0, 1, 2], 3))

    print("Expected Output : -1")
    print("Actual Output :", solution.search([1], 0))
