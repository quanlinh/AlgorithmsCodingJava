import java.util.Scanner;

public class PointsAndSegmentsAlgorithmToolBox {
    /**
     * Sweep-Line Algorithms
     * Sweep vertical line from left to right
     * => x-coordinates defines event
     * => horizontal-segments (left endpoint): insert y-coordinate into BST.
     * It means we need to create a insert for BST
     * => horizontal-segments (right endpoint): remove y-coordinate form BST.
     * It means we need to implement remove for BST.
     * => vertical-segments: range search for interval of y-endpoints
     * It means we need to implement range search in BST.
     *
     * Procedure: sweep from left to right based on the order of x coordinate
     * This order can be build by two ways: sorted the x inputs, or keep it in a
     * priority queue binary heap in the min value is remove first.
     *
     * @param starts
     * @param ends
     * @param points
     * @return
     */
    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = naiveCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

