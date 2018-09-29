import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReshapeMatrixTest {
    @Test
    void testReshapeMatrix() {
        ReshapeMatrix reshapeMatrix = new ReshapeMatrix();
        reshapeMatrix.matrixReshape(new int[][]{{1,2},{3,4}},4,1);
    }

}