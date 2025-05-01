class IncreasingTripletSubsequence:
    def increasingTriplet(self, nums: list[int]) -> bool:
        if len(nums) < 3:
            return False

        first = second = float("inf")

        for n in nums:
            if n <= first:
                first = n
            elif n <= second:
                second = n
            else:
                return True

        return False


# Time Complexity: O(n), where n is the length of the input list
# Space Complexity: O(1), since we are using only a constant amount of space

if __name__ == "__main__":
    solution = IncreasingTripletSubsequence()

    print("Expected Output: True")
    print("Actual Output:", solution.increasingTriplet([1, 2, 3, 4, 5]))

    print("Expected Output: False")
    print("Actual Output:", solution.increasingTriplet([5, 4, 3, 2, 1]))

    print("Expected Output: True")
    print("Actual Output:", solution.increasingTriplet([2, 1, 5, 0, 4, 6]))
