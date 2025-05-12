class RichestCustomerWealth:
    def maximumWealth(self, accounts: list[list[int]]) -> int:
        res = 0

        for account in accounts:
            res = max(res, sum(account))

        return res


# Time Complexity: O(n * m), where n is the number of customers and m is the number of accounts.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = RichestCustomerWealth()

    print("Expected Output: 6")
    print("Actual Output:", solution.maximumWealth([[1, 2, 3], [3, 2, 1]]))

    print("Expected Output: 10")
    print("Actual Output:", solution.maximumWealth([[1, 5], [7, 3], [3, 5]]))

    print("Expected Output: 17")
    print("Actual Output:", solution.maximumWealth([[2, 8, 7], [7, 1, 3], [1, 9, 5]]))
