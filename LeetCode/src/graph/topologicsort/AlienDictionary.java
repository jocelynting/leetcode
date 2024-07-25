package graph.topologicsort;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            /*
            words = ["abc", "ab"]
            If “abc” comes before “ab”, it implies that “abc” should come before any word
            starting with “ab”, which is impossible because “abc” itself starts with “ab”.
             */
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }

            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    char out = first.charAt(j);
                    char in = second.charAt(j);
                    if (!graph.get(out).contains(in)) {
                        graph.get(out).add(in);
                        indegree.put(in, indegree.get(in) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Character ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character cur = queue.poll();
            sb.append(cur);

            for (Character nei : graph.get(cur)) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }

        if (sb.length() < indegree.size()) {
            return "";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AlienDictionary solution = new AlienDictionary();

        String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(solution.alienOrder(words1));  // Output: "wertf"

        String[] words2 = {"z", "x"};
        System.out.println(solution.alienOrder(words2));  // Output: "zx"

        String[] words3 = {"z", "x", "z"};
        System.out.println(solution.alienOrder(words3));  // Output: ""
    }
}
