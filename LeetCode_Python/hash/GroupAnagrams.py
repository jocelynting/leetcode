import collections


class GroupAnagrams:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        res = collections.defaultdict(list)

        for s in strs:
            key = tuple(sorted(s))
            res[key].append(s)

        return list(res.values())


if __name__ == "__main__":
    solution = GroupAnagrams()

    print('Expected Output: [["bat"],["nat","tan"],["ate","eat","tea"]]')
    print(
        "Actual Output:",
        solution.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]),
    )

    print('Expected Output: [[""]]')
    print("Actual Output:", solution.groupAnagrams([""]))

    print('Expected Output: [["a"]]')
    print("Actual Output:", solution.groupAnagrams(["a"]))
