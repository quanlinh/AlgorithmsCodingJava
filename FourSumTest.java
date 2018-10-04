import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourSumTest {
    @Test
    void  simpleTest() {
        int[] testArray1 = new int[] {1, 0, -1, 0, -2, 2};
        FourSum fourSum =new FourSum();
        fourSum.fourSum(testArray1,0);
    }

}