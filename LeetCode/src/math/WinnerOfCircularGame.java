package math;

import java.util.LinkedList;
import java.util.Queue;

public class WinnerOfCircularGame {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        WinnerOfCircularGame solution = new WinnerOfCircularGame();
        System.out.println(solution.findTheWinner(5, 2)); // Expected output: 3
        System.out.println(solution.findTheWinner(6, 5)); // Expected output: 1
    }
}
