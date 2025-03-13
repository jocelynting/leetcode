class CheckIfArrayIsSortedAndRotated:
    def check(self, nums: list[int]) -> bool:
        n = len(nums)
        count = 0

        for i in range(n):
            if nums[i] > nums[(i + 1) % n]:
                count += 1

        return count <= 1


if __name__ == "__main__":
    solution = CheckIfArrayIsSortedAndRotated()

    print("Expected Output : True")
    print("Actual Output : ", solution.check([3, 4, 5, 1, 2]))

    print("Expected Output : False")
    print("Actual Output : ", solution.check([2, 1, 3, 4]))

    print("Expected Output : True")
    print("Actual Output : ", solution.check([1, 2, 3]))
