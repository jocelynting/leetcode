class DailyTemperatures:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        res = [0] * n
        stack = []

        for i in range(n):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                index = stack.pop()
                res[index] = i - index
            stack.append(i)

        return res

if __name__ == '__main__':
    solution = DailyTemperatures()
    
    # Test Case 1:
    temps1 = [73, 74, 75, 71, 69, 72, 76, 73]
    print("Test Case 1: Input:", temps1)
    print("Expected Output: [1, 1, 4, 2, 1, 1, 0, 0]")
    print("Actual Output:", solution.dailyTemperatures(temps1))
    print()
    
    # Test Case 2: Strictly decreasing temperatures, no warmer day in future
    temps2 = [80, 79, 78, 77, 76]
    print("Test Case 2: Input:", temps2)
    print("Expected Output: [0, 0, 0, 0, 0]")
    print("Actual Output:", solution.dailyTemperatures(temps2))
    print()
    
    # Test Case 3: Strictly increasing temperatures
    temps3 = [60, 62, 64, 66, 68]
    print("Test Case 3: Input:", temps3)
    print("Expected Output: [1, 1, 1, 1, 0]")
    print("Actual Output:", solution.dailyTemperatures(temps3))
    print()
    
    # Test Case 4: All temperatures are equal
    temps4 = [70, 70, 70, 70]
    print("Test Case 4: Input:", temps4)
    print("Expected Output: [0, 0, 0, 0]")
    print("Actual Output:", solution.dailyTemperatures(temps4))
    print()