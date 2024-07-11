package stack;

import java.util.Stack;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String log : logs) {
            if (log.equals("./")) {

            } else if (log.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {
                stack.push(log);
            }
        }

        return stack.size();
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
