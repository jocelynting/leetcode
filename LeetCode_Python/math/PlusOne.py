class PlusOne:
    def plusOne(self, digits: list[int]) -> list[int]:
        n = len(digits)

        for i in range(n - 1, -1, -1):
            if digits[i] == 9:
                digits[i] = 0
            else:
                digits[i] += 1
                return digits

        return [1] + digits


# Time Complexity: O(n), where n is the length of the digits list
# Space Complexity: O(1), since we are modifying the input list in place

if __name__ == "__main__":
    solution = PlusOne()

    print("Expected Output: [1, 0, 0, 0]")
    print("Actual Output:", solution.plusOne([9, 9, 9]))

    print("Expected Output: [1, 2, 3]")
    print("Actual Output:", solution.plusOne([1, 2, 2]))
