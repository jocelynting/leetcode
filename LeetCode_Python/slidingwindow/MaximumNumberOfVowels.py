class MaximumNumberOfVowels:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = set("aeiou")
        left = right = 0
        res = 0
        count = 0

        while right < len(s):
            if s[right] in vowels:
                count += 1

            if right - left + 1 == k:
                res = max(res, count)
                if s[left] in vowels:
                    count -= 1
                left += 1

            right += 1

        return res


# Time complexity: O(n), where n is the length of the string s.
# Space complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = MaximumNumberOfVowels()

    print("Expected Output: 3")
    print("Actual Output:", solution.maxVowels("abciiidef", 3))

    print("Expected Output: 2")
    print("Actual Output:", solution.maxVowels("aeiou", 2))

    print("Expected Output: 0")
    print("Actual Output:", solution.maxVowels("xyz", 1))
