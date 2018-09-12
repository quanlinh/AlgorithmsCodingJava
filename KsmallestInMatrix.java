import java.util.PriorityQueue;

public class KsmallestInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue(matrix.length*matrix.length);
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix.length; col++) {
                q.add(matrix[row][col]);
            }
        }
        int m = 0;
        int res = 0;
        while(m != k-2) {
            res = q.remove();
            m++;
        }
        if(q.size() > 0) return q.remove();
        else return res;
    }
}
