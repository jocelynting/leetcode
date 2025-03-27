from collections import defaultdict
from itertools import combinations
from collections import Counter


class AnalyzeUserWebsiteVisitPattern:
    def mostVisitedPattern(
        self, username: list[str], timestamp: list[int], website: list[str]
    ) -> list[str]:
        records = sorted(zip(timestamp, username, website))
        user_websites = defaultdict(list)
        for _, user, site in records:
            user_websites[user].append(site)

        pattern_count = Counter()
        for user, sites in user_websites.items():
            if len(sites) < 3:
                continue

            patterns = set(combinations(sites, 3))
            for pattern in patterns:
                pattern_count[pattern] += 1

        res = sorted(pattern_count.items(), key=lambda x: (-x[1], x[0]))
        return list(res[0][0])


# Time Complexity: O(n^3)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = AnalyzeUserWebsiteVisitPattern()

    username1 = [
        "joe",
        "joe",
        "joe",
        "james",
        "james",
        "james",
        "james",
        "mary",
        "mary",
        "mary",
    ]
    timestamp1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    website1 = [
        "home",
        "about",
        "career",
        "home",
        "cart",
        "maps",
        "home",
        "home",
        "about",
        "career",
    ]

    print("Expected Output: ['home', 'about', 'career']")
    print(
        "Actual Output:", solution.mostVisitedPattern(username1, timestamp1, website1)
    )

    username2 = ["u1", "u1", "u1", "u2", "u2", "u2"]
    timestamp2 = [1, 2, 3, 4, 5, 6]
    website2 = ["a", "b", "a", "a", "b", "c"]
    print("Expected Output: ['a', 'b', 'a']")
    print(
        "Actual Output:", solution.mostVisitedPattern(username2, timestamp2, website2)
    )
