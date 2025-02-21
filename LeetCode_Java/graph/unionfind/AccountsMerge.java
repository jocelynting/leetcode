package graph.unionfind;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        Map<String, Integer> emailIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> info = accounts.get(i);
            for (int j = 1; j < info.size(); j++) {
                String email = info.get(j);
                if (emailIndex.containsKey(email)) {
                    uf.union(i, emailIndex.get(email));
                } else {
                    emailIndex.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> emailMap = new HashMap<>();
        for (String email : emailIndex.keySet()) {
            int index = emailIndex.get(email);
            int root = uf.find(index);
            emailMap.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> merge = new ArrayList<>();
        for (int root : emailMap.keySet()) {
            List<String> emails = emailMap.get(root);
            Collections.sort(emails);
            emails.add(0, accounts.get(root).get(0));
            merge.add(emails);
        }

        return merge;
    }

    public static void main(String[] args) {
        AccountsMerge solution = new AccountsMerge();

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        List<List<String>> mergedAccounts = solution.accountsMerge(accounts);
        for (List<String> account : mergedAccounts) {
            System.out.println(account);
        }
        /*
        Output:
        [Mary, mary@mail.com]
        [John, john00@mail.com, john_newyork@mail.com, johnsmith@mail.com]
        [John, johnnybravo@mail.com]
         */
    }
}
