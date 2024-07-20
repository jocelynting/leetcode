package graph;

import java.util.*;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] r = routes[i];
            for (int stop : r) {
                graph.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoute = new HashSet<>();
        queue.offer(source);
        visitedStops.add(source);

        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                for (int route : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (visitedRoute.contains(route))
                        continue;
                    visitedRoute.add(route);

                    for (int stop : routes[route]) {
                        if (stop == target)
                            return result;
                        if (!visitedStops.contains(stop)) {
                            queue.offer(stop);
                            visitedStops.add(stop);
                        }
                    }
                }
            }

            result++;

        }

        return -1;
    }

    public static void main(String[] args) {
        BusRoutes solution = new BusRoutes();

        int[][] routes1 = {{1, 2, 7}, {3, 6, 7}};
        int source1 = 1;
        int target1 = 6;
        System.out.println(solution.numBusesToDestination(routes1, source1, target1)); // Expected: 2

        int[][] routes2 = {{1, 2, 3}, {3, 4, 5}, {5, 6, 7}};
        int source2 = 1;
        int target2 = 7;
        System.out.println(solution.numBusesToDestination(routes2, source2, target2)); // Expected: 3

        int[][] routes3 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {10, 11, 12, 13, 14}};
        int source3 = 1;
        int target3 = 14;
        System.out.println(solution.numBusesToDestination(routes3, source3, target3)); // Expected: -1
    }
}
