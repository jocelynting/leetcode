package graph.unionfind;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        Map<String, Integer> emailGroup = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            int accountSize = accounts.get(i).size();

            for (int j = 1; j < accountSize; j++) {
                String email = accounts.get(i).get(j);

                if (!emailGroup.containsKey(email)) {
                    emailGroup.put(email, i);
                } else {
                    uf.union(i, emailGroup.get(email));
                }
            }
        }

        Map<Integer, List<String>> components = new HashMap<Integer, List<String>>();
        for (String email : emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int groupRep = uf.find(group);

            if (!components.containsKey(groupRep)) {
                components.put(groupRep, new ArrayList<String>());
            }

            components.get(groupRep).add(email);
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int group : components.keySet()) {
            List<String> component = components.get(group);
            Collections.sort(component);
            component.add(0, accounts.get(group).get(0));
            mergedAccounts.add(component);
        }

        return mergedAccounts;
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
