from collections import Counter


class ValidAnagram:
    def isAnagram(self, s: str, t: str) -> bool:
        count1 = Counter(s)
        count2 = Counter(t)
        return count1 == count2


# Time Complexity: O(n), where n is the length of the string s or t
# Space Complexity: O(1), since the size of the counter is constant (26 letters)

if __name__ == "__main__":
    solution = ValidAnagram()

    print("Expected Output: True")
    print("Actual Output:", solution.isAnagram("anagram", "nagaram"))

    print("Expected Output: False")
    print("Actual Output:", solution.isAnagram("rat", "car"))
