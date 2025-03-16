class BrowserHistory:
    def __init__(self, homepage: str):
        self.stack = [homepage]
        self.index = 0

    def visit(self, url: str) -> None:
        self.stack = self.stack[: self.index + 1]
        self.stack.append(url)
        self.index += 1

    def back(self, steps: int) -> str:
        self.index = max(0, self.index - steps)
        return self.stack[self.index]

    def forward(self, steps: int) -> str:
        self.index = min(len(self.stack) - 1, self.index + steps)
        return self.stack[self.index]


if __name__ == "__main__":
    solution = BrowserHistory("leetcode.com")

    print("Expected Output : None")
    print("Actual Output : ", solution.visit("google.com"))
    print("Expected Output : None")
    print("Actual Output : ", solution.visit("facebook.com"))
    print("Expected Output : None")
    print("Actual Output : ", solution.visit("youtube.com"))
    print("Expected Output : facebook.com")
    print("Actual Output : ", solution.back(1))
    print("Expected Output : google.com")
    print("Actual Output : ", solution.back(1))
    print("Expected Output : facebook.com")
    print("Actual Output : ", solution.forward(1))
    print("Expected Output : None")
    print("Actual Output : ", solution.visit("linkedin.com"))
    print("Expected Output : linkedin.com")
    print("Actual Output : ", solution.forward(2))
    print("Expected Output : google.com")
    print("Actual Output : ", solution.back(2))
    print("Expected Output : leetcode.com")
    print("Actual Output : ", solution.back(7))
