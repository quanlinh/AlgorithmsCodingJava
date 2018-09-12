import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KsmallestInMatrixTest {
    @Test
    void testSimple() {
        KsmallestInMatrix ksmallestInMatrix = new KsmallestInMatrix();
        int[][] matrix1 = {{1,5,9},
                {10,11,13},
                {12,13,15}};
        assertEquals(ksmallestInMatrix.kthSmallest(matrix1,8),13);
        assertEquals(ksmallestInMatrix.kthSmallest(matrix1,1),13);
    }

}