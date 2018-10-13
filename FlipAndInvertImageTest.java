import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class FlipAndInvertImageTest {
    public int[][] flipAndInvertImage(int[][] A) {
        Queue<Integer> q = new ArrayDeque<>();
        if(A == null || A.length == 0) return A;
        for(int row = 0; row < A.length; row++ ) {
            for(int col = 0; col < A[row].length; col++) {
                if(A[row][col] == 1) A[row][col] = 0;
                else {
                    A[row][col] = 1;
                }
            }

            int leftCol = 0, rightCol = A[row].length-1;
            while(leftCol < rightCol) {
                int temp = A[row][leftCol];
                A[row][leftCol++] = A[row][rightCol];
                A[row][rightCol--] = temp;
            }

        }
        return A;
    }
}