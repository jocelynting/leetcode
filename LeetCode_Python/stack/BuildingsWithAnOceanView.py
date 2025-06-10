class BuildingsWithAnOceanView:
    def findBuildings(self, heights: list[int]) -> list[int]:
        n = len(heights)
        stack = []

        for i in range(n):
            while stack and heights[stack[-1]] <= heights[i]:
                stack.pop()
            stack.append(i)

        return stack


# Time Complexity: O(n), where n is the number of buildings.
# Space Complexity: O(n), for the stack to store indices of buildings.

if __name__ == "__main__":
    solution = BuildingsWithAnOceanView()

    print("Expected Output: [0, 2, 3]")
    print("Actual Output:", solution.findBuildings([4, 2, 3, 1]))

    print("Expected Output: [0, 1, 2, 3]")
    print("Actual Output:", solution.findBuildings([4, 3, 2, 1]))

    print("Expected Output: [3]")
    print("Actual Output:", solution.findBuildings([1, 3, 2, 4]))
