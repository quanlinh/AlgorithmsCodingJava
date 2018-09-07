import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {
    @Test
    void testReverseIntegerSimple() {
        ReverseInteger reverseInteger = new ReverseInteger();
        assertEquals(reverseInteger.reverse(-100000),-1);
        assertEquals(reverseInteger.reverse(123),321);
        assertEquals(reverseInteger.reverse(1534236469),0);
        assertEquals(reverseInteger.reverseOptimize(1534236469),0);
    }

}