package graph;

import java.util.*;

public class FindRecipesFromSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        int n = recipes.length;
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (String recipe : recipes) {
            indegree.put(recipe, 0);
        }

        for (int i = 0; i < n; i++) {
            for (String in : ingredients.get(i)) {
                if (!graph.containsKey(in)) {
                    graph.put(in, new ArrayList<>());
                }
                graph.get(in).add(recipes[i]);
                indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0) + 1);
            }
        }

        Queue<String> queue = new LinkedList<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            if (graph.containsKey(cur)) {
                for (String r : graph.get(cur)) {
                    indegree.put(r, indegree.get(r) - 1);
                    if (indegree.get(r) == 0) {
                        queue.add(r);
                        result.add(r);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindRecipesFromSupplies solution = new FindRecipesFromSupplies();

        String[] recipes = {"bread", "sandwich"};
        List<List<String>> ingredients = Arrays.asList(
                Arrays.asList("yeast", "flour"),
                Arrays.asList("bread", "ham")
        );
        String[] supplies = {"yeast", "flour", "ham"};

        List<String> result = solution.findAllRecipes(recipes, ingredients, supplies);
        System.out.println(result); // Output: ["bread", "sandwich"]
    }
}
