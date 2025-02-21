package graph;

import java.util.*;

public class AccountsMerge {
    private Map<String, List<String>> graph;
    private HashSet<String> visited;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        graph = new HashMap<>();
        visited = new HashSet<>();

        buildGraph(accounts);

        List<List<String>> results = new ArrayList<>();

        for (List<String> account: accounts) {
            String name = account.get(0);
            String main = account.get(1);

            if (!visited.contains(main)) {
                List<String> merge = new ArrayList<>();

                merge.add(name);
                dfs(merge, main);
                Collections.sort(merge.subList(1, merge.size()));
                results.add(merge);
            }
        }

        return results;
    }

    private void buildGraph(List<List<String>> accounts) {

        for (List<String> account: accounts) {
            String main = account.get(1);
            int size = account.size();

            for (int i = 2; i < size; i++) {
                String email = account.get(i);
                if (!graph.containsKey(main)) {
                    graph.put(main, new ArrayList<>());
                }
                graph.get(main).add(email);

                if (!graph.containsKey(email)) {
                    graph.put(email, new ArrayList<>());
                }
                graph.get(email).add(main);
            }
        }
    }

    private void dfs(List<String> merge, String email) {
        merge.add(email);
        visited.add(email);

        if (!graph.containsKey(email)) {
            return;
        }

        for (String nei: graph.get(email)) {
            if (!visited.contains(nei)) {
                dfs(merge, nei);
            }
        }
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
