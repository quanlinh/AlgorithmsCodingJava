import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetZeroInMaxtrixTest {
    @Test
    void  simpleTesstSetZeroMatrix() {
        SetZeroInMaxtrix setZeroInMaxtrix = new SetZeroInMaxtrix();
        int [][] a = {{1,1,1},{1,0,1},{1,1,1}};
//        setZeroInMaxtrix.setZeroes(a);
        setZeroInMaxtrix.setZeroesUpgrade(a);
        int [][] aSetZero = {{1,0,1},{0,0,0},{1,0,1}};
        assertArrayEquals(a,aSetZero);
        int[][] b = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        setZeroInMaxtrix.setZeroesUpgrade(b);

    }

}