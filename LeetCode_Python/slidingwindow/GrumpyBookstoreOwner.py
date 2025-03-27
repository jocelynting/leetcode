class GrumpyBookstoreOwner:
    def maxSatisfied(
        self, customers: list[int], grumpy: list[int], minutes: int
    ) -> int:
        n = len(customers)
        total = 0

        for i in range(n):
            if grumpy[i] == 0:
                total += customers[i]

        maxIncrease = 0
        increase = 0
        for i in range(minutes):
            if grumpy[i] == 1:
                increase += customers[i]

        maxIncrease = increase
        for i in range(minutes, n):
            if grumpy[i] == 1:
                increase += customers[i]
            if grumpy[i - minutes] == 1:
                increase -= customers[i - minutes]
            maxIncrease = max(maxIncrease, increase)

        return total + maxIncrease


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = GrumpyBookstoreOwner()

    customers = [1, 0, 1, 2, 1, 1, 7, 5]
    grumpy = [0, 1, 0, 1, 0, 1, 0, 1]
    minutes = 3
    print("Expected Output : 16")
    print("Actual Output :", solution.maxSatisfied(customers, grumpy, minutes))

    customers = [4, 10, 10]
    grumpy = [1, 1, 0]
    minutes = 2
    print("Expected Output : 24")
    print("Actual Output :", solution.maxSatisfied(customers, grumpy, minutes))
