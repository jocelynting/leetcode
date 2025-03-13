class StockSpanner:
    def __init__(self):
        self.stack = []

    def next(self, price: int) -> int:
        count = 1

        while self.stack and self.stack[-1][0] <= price:
            count += self.stack.pop()[1]
        self.stack.append((price, count))

        return count


if __name__ == "__main__":
    solution = StockSpanner()

    print("Expected Output: 1")
    print("Actual Output  :", solution.next(100))

    print("Expected Output: 1")
    print("Actual Output  :", solution.next(80))

    print("Expected Output: 1")
    print("Actual Output  :", solution.next(60))

    print("Expected Output: 2")
    print("Actual Output  :", solution.next(70))

    print("Expected Output: 1")
    print("Actual Output  :", solution.next(60))

    print("Expected Output: 4")
    print("Actual Output  :", solution.next(75))
