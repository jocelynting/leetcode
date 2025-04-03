class ContainsDuplicate:
    def containsDuplicate(self, nums: list[int]) -> bool:
        num_set = set()

        for num in nums:
            if num in num_set:
                return True
            num_set.add(num)

        return False


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = ContainsDuplicate()

    print("Expected Output: True")
    print("Actual Output:", solution.containsDuplicate([1, 2, 3, 1]))

    print("Expected Output: False")
    print("Actual Output:", solution.containsDuplicate([1, 2, 3, 4]))

    print("Expected Output: True")
    print("Actual Output:", solution.containsDuplicate([1, 2, 3, 4, 5, 1]))
