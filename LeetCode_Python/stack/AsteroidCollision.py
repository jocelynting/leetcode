class AsteroidCollision:
    def asteroidCollision(self, asteroids: list[int]) -> list[int]:
        stack = []

        for a in asteroids:
            while stack and a < 0 < stack[-1]:
                if stack[-1] < -a:
                    stack.pop()
                elif stack[-1] == -a:
                    stack.pop()
                    break
                else:
                    break
            else:
                stack.append(a)

        return stack


# Time Complexity: O(n), where n is the number of asteroids.
# Space Complexity: O(n), in the worst case, all asteroids are moving in the same direction.

if __name__ == "__main__":
    solution = AsteroidCollision()

    print("Expected Output: [5, 10]")
    print("Actual Output:", solution.asteroidCollision([5, 10, -5]))

    print("Expected Output: []")
    print("Actual Output:", solution.asteroidCollision([8, -8]))

    print("Expected Output: [10]")
    print("Actual Output:", solution.asteroidCollision([10, 2, -5]))
