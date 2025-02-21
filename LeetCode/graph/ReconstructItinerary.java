package graph;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        List<String> result = new ArrayList<>();
        dfs("JFK", graph, result);
        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> nextAirports = graph.get(airport);
        while (nextAirports != null && !nextAirports.isEmpty()) {
            dfs(nextAirports.poll(), graph, result);
        }
        result.add(0, airport);
    }

    public static void main(String[] args) {
        ReconstructItinerary solution = new ReconstructItinerary();

        List<List<String>> tickets1 = Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        );
        System.out.println(solution.findItinerary(tickets1)); // Output: [JFK, MUC, LHR, SFO, SJC]

        List<List<String>> tickets2 = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO")
        );
        System.out.println(solution.findItinerary(tickets2)); // Output: [JFK, ATL, JFK, SFO, ATL, SFO]
    }
}
