package designclass;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    private Queue<Integer> hits;

    public HitCounter() {
        hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hits.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while (!hits.isEmpty() && hits.peek() <= timestamp - 300) {
            hits.poll();
        }

        return hits.size();
    }

    /*
    private Queue<Integer> hits;
    private Map<Integer, Integer> hitCount;

    public HitCounter() {
        hits = new LinkedList<>();
        hitCount = new HashMap<>();
    }

    public void hit(int timestamp) {
        hits.offer(timestamp);
        hitCount.put(timestamp, hitCount.getOrDefault(timestamp, 0) + 1);
    }

    public int getHits(int timestamp) {
        while (!hits.isEmpty() && hits.peek() <= timestamp - 300) {
            int outdated = hits.poll();
            hitCount.put(outdated, hitCount.get(outdated) - 1);
            if (hitCount.get(outdated) == 0) {
                hitCount.remove(outdated);
            }
        }

        int result = 0;
        for (int count : hitCount.values()) {
            result += count;
        }

        return result;
    }
     */

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4)); // Expected output: 3

        counter.hit(300);
        System.out.println(counter.getHits(300)); // Expected output: 4
        System.out.println(counter.getHits(301)); // Expected output: 3

        counter.hit(300);
        counter.hit(301);
        counter.hit(302);
        counter.hit(303);
        System.out.println(counter.getHits(304)); // Expected output: 5
    }
}
