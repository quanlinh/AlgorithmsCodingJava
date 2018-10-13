import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonotoIncreasingArrayTest {
    @Test
    void simpleTest1() {
        MonotoIncreasingArray monotoIncreasingArray = new MonotoIncreasingArray();

        assertTrue(monotoIncreasingArray.isMonotonic(new int[]{1,2,2,3,4,5}));
        assertFalse(monotoIncreasingArray.isMonotonic(new int[]{1,2,2,3,4,5,2}));
    }
}