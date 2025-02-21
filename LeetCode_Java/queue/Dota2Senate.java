package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int rIndex = r.poll();
            int dIndex = d.poll();

            if (rIndex < dIndex) {
                r.offer(rIndex + n);
            } else {
                d.offer(dIndex + n);
            }
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Dota2Senate solution = new Dota2Senate();

        String senate1 = "RD";
        System.out.println(solution.predictPartyVictory(senate1));// Output: Radiant

        String senate2 = "RDD";
        System.out.println(solution.predictPartyVictory(senate2));// Output: Dire

        String senate3 = "DDRRR";
        System.out.println(solution.predictPartyVictory(senate3));// Output: Dire
    }
}
