class CanMakeArithmeticProgressionFromSequence:
    def canMakeArithmeticProgression(self, arr: list[int]) -> bool:
        arr.sort()
        diff = arr[1] - arr[0]
        for i in range(2, len(arr)):
            if arr[i] - arr[i - 1] != diff:
                return False
        return True


# Time Complexity: O(n log n), where n is the length of the arr list due to sorting
# Space Complexity: O(1), since we are using a constant amount of space

if __name__ == "__main__":
    solution = CanMakeArithmeticProgressionFromSequence()

    print("Expected Output: True")
    print("Actual Output:", solution.canMakeArithmeticProgression([3, 5, 1]))

    print("Expected Output: False")
    print("Actual Output:", solution.canMakeArithmeticProgression([1, 2, 4]))
