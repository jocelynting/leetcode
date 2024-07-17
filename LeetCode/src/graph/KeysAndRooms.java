package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        return canVisitAllRoomsByBFS(rooms);
        return canVisitAllRoomsByDFS(rooms);
    }

    private boolean canVisitAllRoomsByBFS(List<List<Integer>> rooms) {
        int n = rooms.size();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            for (Integer key : rooms.get(cur)) {
                if (!visited[key]) {
                    queue.offer(key);
                    visited[key] = true;
                }
            }
        }

        for (boolean r : visited) {
            if (!r) {
                return false;
            }
        }

        return true;
    }

    private boolean canVisitAllRoomsByDFS(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(rooms, 0, visited);

        for (boolean r : visited) {
            if (!r) {
                return false;
            }
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        visited[room] = true;

        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(rooms, key, visited);
            }
        }
    }

    public static void main(String[] args) {
        KeysAndRooms solution = new KeysAndRooms();

        List<List<Integer>> rooms1 = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        );
        System.out.println(solution.canVisitAllRooms(rooms1)); // Output: true

        List<List<Integer>> rooms2 = List.of(
                List.of(1, 3),
                List.of(3, 0, 1),
                List.of(2),
                List.of(0)
        );
        System.out.println(solution.canVisitAllRooms(rooms2)); // Output: false
    }
}
