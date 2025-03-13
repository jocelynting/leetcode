class FindAllNumbersDisappearedInAnArray:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        num_set = set(nums)
        n = len(nums)
        res = []

        for i in range(1, n + 1):
            if i not in num_set:
                res.append(i)

        return res


if __name__ == "__main__":
    solution = FindAllNumbersDisappearedInAnArray()

    print("Expected Output: [5, 6]")
    print("Actual Output:", solution.findDisappearedNumbers([4, 3, 2, 7, 8, 2, 3, 1]))

    print("Expected Output: [2]")
    print("Actual Output:", solution.findDisappearedNumbers([1, 1]))

    print("Expected Output: []")
    print("Actual Output:", solution.findDisappearedNumbers([]))
