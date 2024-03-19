package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {
    class Project {
        int profit;
        int capital;
        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < profits.length; i++){
            Project p = new Project(profits[i],capital[i]);
            projects.add(p);
        }
        //profit 最大
        PriorityQueue<Project> maxHeap = new PriorityQueue<>((project1, project2) -> project2.profit - project1.profit);

        //capital 最小
        PriorityQueue<Project> minHeap = new PriorityQueue<>((project1, project2) -> project1.capital - project2.capital);

        for (int i = 0; i < projects.size(); i++){
            int c = projects.get(i).capital;
            if (c <= w){
                maxHeap.offer(projects.get(i));
            } else {
                minHeap.offer(projects.get(i));
            }
        }

        for (int i = 0; i < k; i++) {
            Project p = maxHeap.poll();
            if (p == null) break;
            w += p.profit;
            while(minHeap.size() > 0 && minHeap.peek().capital <= w){
                maxHeap.offer(minHeap.poll());
            }
        }

        return w;

    }

    /*
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = capital[i];
            pairs[i][1] = profits[i];
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int ans = w;
        int proj = 0;
        for (int i = 0; i < k; i++) {
            while (proj < n && pairs[proj][0] <= ans) {
                heap.offer(pairs[proj][1]);
                proj++;
            }
            if (!heap.isEmpty()) {
                ans += heap.poll();
            }

        }
        return ans;
    }
    */

    public static void main(String[] args) {
        IPO solution = new IPO();

        // Example usage:
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        System.out.println(solution.findMaximizedCapital(k, w, profits, capital)); // Output: 4
    }
}

