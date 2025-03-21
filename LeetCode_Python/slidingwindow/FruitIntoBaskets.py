class FruitIntoBaskets:
    def totalFruit(self, fruits: list[int]) -> int:
        res = 0
        count = {}
        left = 0

        for right, fruit in enumerate(fruits):
            count[fruit] = count.get(fruit, 0) + 1

            while len(count) > 2:
                count[fruits[left]] -= 1
                if count[fruits[left]] == 0:
                    del count[fruits[left]]
                left += 1

            res = max(res, right - left + 1)

        return res


# Time Complexity: O(n)
# Space Complexity: O(1) since the number of elements in the hashmap is at most 2

if __name__ == "__main__":
    solution = FruitIntoBaskets()

    print("Expected Output: 3")
    print("Actual Output:", solution.totalFruit([1, 2, 1]))

    print("Expected Output: 3")
    print("Actual Output:", solution.totalFruit([0, 1, 2, 2]))

    print("Expected Output: 4")
    print("Actual Output:", solution.totalFruit([1, 2, 3, 2, 2]))
