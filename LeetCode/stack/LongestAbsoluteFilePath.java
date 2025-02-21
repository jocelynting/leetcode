package stack;

import java.util.Stack;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        Stack<String> stack = new Stack<>();

        int max = 0;
        int currLen = 0;
        String[] paths = input.split("\n");
        for(String line : paths) {
            String[] subPaths = line.split("\t");

            while(stack.size() >= subPaths.length) {
                currLen -= stack.pop().length();
            }

            String path = subPaths[subPaths.length - 1];
            stack.push(path + "/");
            currLen += path.length() + 1;

            if(path.contains(".")) {
                max = Math.max(max, currLen - 1);
            }
        }

        return max;
    }


    public static void main(String[] args) {
        LongestAbsoluteFilePath solution = new LongestAbsoluteFilePath();
        String input1 = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(solution.lengthLongestPath(input1)); // Output should be 20
        String input2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(solution.lengthLongestPath(input2)); // Output should be 32
    }
}
