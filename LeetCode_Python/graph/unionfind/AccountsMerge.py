from UnionFind import UnionFind


class AccountsMerge:
    def accountsMerge(self, accounts: list[list[str]]) -> list[list[str]]:
        n = len(accounts)
        uf = UnionFind(n)
        email_to_index = {}

        for i, account in enumerate(accounts):
            for email in account[1:]:
                if email not in email_to_index:
                    email_to_index[email] = i
                else:
                    uf.union(i, email_to_index[email])

        groups = {}
        for email, index in email_to_index.items():
            root = uf.find(index)
            if root not in groups:
                groups[root] = []
            groups[root].append(email)

        res = []
        for index, emails in groups.items():
            res.append([accounts[index][0]] + sorted(emails))

        return res


# Time Complexity: O(n * m log m)
# where n is the number of accounts and m is the maximum number of emails in an account.
# The union-find operations are nearly constant time, and sorting the emails takes O(m log m).
# Space Complexity: O(n + m)
# where n is the number of accounts and m is the number of unique emails.

if __name__ == "__main__":
    solution = AccountsMerge()

    accounts = [
        ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
        ["John", "johnsmith@mail.com", "john00@mail.com"],
        ["Mary", "mary@mail.com"],
        ["John", "johnnybravo@mail.com"],
    ]

    print(
        "Expected Output: [['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'], ['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com']]"
    )
    print("Actual Output:", solution.accountsMerge(accounts))
