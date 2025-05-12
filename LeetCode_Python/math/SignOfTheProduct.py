class SignOfTheProduct:
    def arraySign(self, nums: list[int]) -> int:
        sign = 1

        for num in nums:
            if num == 0:
                return 0
            elif num < 0:
                sign *= -1

        return sign


# Time Complexity: O(n), where n is the length of the nums list
# Space Complexity: O(1), since we are using a constant amount of space

if __name__ == "__main__":
    solution = SignOfTheProduct()

    print("Expected Output: 1")
    print("Actual Output:", solution.arraySign([-1, -2, -3, -4, 3, 2, 1]))

    print("Expected Output: 0")
    print("Actual Output:", solution.arraySign([-1, 1, 0]))
