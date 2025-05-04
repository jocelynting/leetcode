from collections import Counter


class UniqueNumberOfOccurrences:
    def uniqueOccurrences(self, arr: list[int]) -> bool:
        count = Counter(arr)
        c_set = set(count.values())
        return len(count) == len(c_set)


# Time Complexity: O(n), where n is the number of elements in the input list.
# Counting the occurrences of each element takes O(n) time, and creating a set from the counts also takes O(n) time in the worst case.
# Space Complexity: O(n), where n is the number of unique elements in the input list.


if __name__ == "__main__":
    solution = UniqueNumberOfOccurrences()

    print("Expected Output: True")
    print("Actual Output:", solution.uniqueOccurrences([1, 2, 2, 1, 1, 3]))

    print("Expected Output: False")
    print("Actual Output:", solution.uniqueOccurrences([1, 2]))

    print("Expected Output: True")
    print(
        "Actual Output:", solution.uniqueOccurrences([-3, 0, 1, -3, 1, 1, 1, -3, 10, 0])
    )
