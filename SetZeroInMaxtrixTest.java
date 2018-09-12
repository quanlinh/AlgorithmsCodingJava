import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetZeroInMaxtrixTest {
    @Test
    void  simpleTesstSetZeroMatrix() {
        SetZeroInMaxtrix setZeroInMaxtrix = new SetZeroInMaxtrix();
        int [][] a = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroInMaxtrix.setZeroes(a);
        int [][] aSetZero = {{1,0,1},{0,0,0},{1,0,1}};
    }

}