class BuddyStrings:
    def buddyStrings(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False

        if s == goal:
            return len(set(s)) < len(s)

        diff = []
        for i in range(len(s)):
            if s[i] != goal[i]:
                diff.append(i)

        return (
            len(diff) == 2
            and s[diff[0]] == goal[diff[1]]
            and s[diff[1]] == goal[diff[0]]
        )


# Time Complexity: O(n), where n is the length of the strings.
# Space Complexity: O(1), since we are using a fixed amount of space for the diff list.

if __name__ == "__main__":
    solution = BuddyStrings()

    print("Expected Output: True")
    print("Actual Output:", solution.buddyStrings("ab", "ba"))

    print("Expected Output: False")
    print("Actual Output:", solution.buddyStrings("ab", "ab"))

    print("Expected Output: True")
    print("Actual Output:", solution.buddyStrings("aa", "aa"))

    print("Expected Output: True")
    print("Actual Output:", solution.buddyStrings("aaaaaaabc", "aaaaaaacb"))
