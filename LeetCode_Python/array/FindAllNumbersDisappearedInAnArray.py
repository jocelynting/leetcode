class FindAllNumbersDisappearedInAnArray:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        n = len(nums)

        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = -nums[index]

        res = [i + 1 for i in range(n) if nums[i] > 0]
        return res


if __name__ == "__main__":
    solution = FindAllNumbersDisappearedInAnArray()

    print("Expected Output: [5, 6]")
    print("Actual Output:", solution.findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]))

    print("Expected Output: [2]")
    print("Actual Output:", solution.findDisappearedNumbers([1, 1]))

    print("Expected Output: []")
    print("Actual Output:", solution.findDisappearedNumbers([]))
