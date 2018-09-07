import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumProductSubArrayTest {
    @Test
    void simpleTest() {
        MaximumProductSubArray maximumProductSubArray = new MaximumProductSubArray();
        assertEquals( maximumProductSubArray.maxProduct(new int[]{2,3,-2,4}),6);
        assertEquals( maximumProductSubArray.maxProduct(new int[]{-2,0,-1}),0);
        assertEquals( maximumProductSubArray.maxProduct(new int[]{-2,3,-4}),24);

    }

}