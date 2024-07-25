package heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringFromKLists {

    static class Element {
        int value, row, index;

        Element(int value, int row, int index) {
            this.value = value;
            this.row = row;
            this.index = index;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            pq.offer(new Element(value, i, 0));
            max = Math.max(max, value);
        }

        while (pq.size() == nums.size()) {
            Element cur = pq.poll();
            int min = cur.value;

            if (max - min < end - start) {
                start = min;
                end = max;
            }

            if (cur.index + 1 < nums.get(cur.row).size()) {
                int next = nums.get(cur.row).get(cur.index + 1);
                pq.offer(new Element(next, cur.row, cur.index + 1));
                max = Math.max(max, next);
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        SmallestRangeCoveringFromKLists solution = new SmallestRangeCoveringFromKLists();
        List<List<Integer>> nums = Arrays.asList(
                Arrays.asList(4, 10, 15, 24, 26),
                Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30)
        );
        System.out.println(Arrays.toString(solution.smallestRange(nums)));// Output: [20,24]
    }
}
