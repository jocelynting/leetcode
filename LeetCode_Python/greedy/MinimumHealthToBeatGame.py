class MinimumHealthToBeatGame:
    def minimumHealth(self, damage: list[int], armor: int) -> int:
        total_damage = sum(damage)
        max_damage = max(damage)
        return total_damage - min(max_damage, armor) + 1


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = MinimumHealthToBeatGame()

    print("Expected Output: 5")
    print("Actual Output:", solution.minimumHealth([1, 2, 3], 2))

    print("Expected Output: 4")
    print("Actual Output:", solution.minimumHealth([1, 2, 3], 3))

    print("Expected Output: 4")
    print("Actual Output:", solution.minimumHealth([1, 2, 3], 4))
