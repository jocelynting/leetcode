package binarysearch;

public class SmallestRectangleEnclosingBlackPixels {

    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;

        int top = binarySearch(image, 0, x, 0, n, true, true);
        int bottom = binarySearch(image, x + 1, m, 0, n, true, false);
        int left = binarySearch(image, 0, y, top, bottom, false, true);
        int right = binarySearch(image, y + 1, n, top, bottom, false, false);

        return (bottom - top) * (right - left);
    }

    private int binarySearch(char[][] image, int left, int right, int min, int max, boolean isRow, boolean goLower) {
        while (left < right) {
            int mid = (left + right) / 2;
            boolean black = false;

            for (int i = min; i < max; i++) {
                if ((isRow ? image[mid][i] : image[i][mid]) == '1') {
                    black = true;
                    break;
                }
            }

            if (black == goLower) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SmallestRectangleEnclosingBlackPixels solution = new SmallestRectangleEnclosingBlackPixels();
        char[][] image = {
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '1', '0', '0'}
        };
        System.out.println(solution.minArea(image, 0, 2)); // Output: 6
    }
}
