package array;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            if (log.equals("./")) {

            } else if (log.equals("../")) {
                depth = Math.max(0, depth - 1);
            } else {
                depth++;
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        CrawlerLogFolder solution = new CrawlerLogFolder();

        String[] logs1 = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(solution.minOperations(logs1));// Output: 2

        String[] logs2 = {"d1/", "d2/", "./", "d3/", "../", "d31/"};
        System.out.println(solution.minOperations(logs2));// Output: 3

        String[] logs3 = {"d1/", "../", "../", "../"};
        System.out.println(solution.minOperations(logs3));// Output: 0
    }
}
