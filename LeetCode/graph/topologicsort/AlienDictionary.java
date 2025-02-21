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
            String s1 = words[i];
            String s2 = words[i + 1];

             /*
            words = ["abc", "ab"]
            If “abc” comes before “ab”, it implies that “abc” should come before any word
            starting with “ab”, which is impossible because “abc” itself starts with “ab”.
             */
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                char ch1 = s1.charAt(j);
                char ch2 = s2.charAt(j);
                if (ch1 != ch2) {
                    if (!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
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

        return sb.length() == indegree.size() ? sb.toString() : "";
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
