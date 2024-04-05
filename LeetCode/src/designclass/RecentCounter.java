package designclass;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    private Queue<Integer> counter;
    public RecentCounter() {
        counter = new LinkedList<>();
    }

    public int ping(int t) {

        while (!counter.isEmpty() && t - counter.peek() > 3000) {
            counter.poll();
        }

        counter.offer(t);

        return counter.size();
    }


    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1)); // Returns 1, no recent calls
        System.out.println(counter.ping(100)); // Returns 2, one recent call within 3000 ms
        System.out.println(counter.ping(3001)); // Returns 3, one recent call within 3000 ms
        System.out.println(counter.ping(3002)); // Returns 3, two recent calls within 3000 ms
    }
}
